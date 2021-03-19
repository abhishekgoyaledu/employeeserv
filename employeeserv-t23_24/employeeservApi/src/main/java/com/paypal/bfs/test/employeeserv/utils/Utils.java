package com.paypal.bfs.test.employeeserv.utils;

import com.paypal.bfs.test.employeeserv.dao.Employee;
import com.paypal.bfs.test.employeeserv.enums.*;
import com.paypal.bfs.test.employeeserv.model.*;

import java.text.*;
import java.util.*;
import java.util.regex.*;

//Utility class in order to validate the request
public class Utils {

    public static Employee convertModelToDaoObject(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        if (employeeRequest.getId() != 0) {
            // ignoring for post calls
            employee.setId(Long.valueOf(employeeRequest.getId()));
        }
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth().getDate() + "/" + employeeRequest.getDateOfBirth().getMonth() + "/" + employeeRequest.getDateOfBirth().getYear());
        employee.setAddressLine1(employeeRequest.getAddress().getLine1());
        employee.setAddressLine2(employeeRequest.getAddress().getLine2());
        employee.setCity(employeeRequest.getAddress().getCity());
        employee.setState(employeeRequest.getAddress().getState());
        employee.setCountry(employeeRequest.getAddress().getCountry());
        employee.setZipCode(employeeRequest.getAddress().getZipCode());

        return employee;
    }

    public static DateOfBirth parseDateOfBirth(String dateOfBirth) throws Exception {
        Date date = null;
        DateOfBirth employeeDateOfBirth = new DateOfBirth();
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            employeeDateOfBirth.setDate(calendar.get(Calendar.DAY_OF_MONTH));
            //Addting 1 as calender months starts from 0
            employeeDateOfBirth.setMonth(calendar.get(Calendar.MONTH)+1);
            employeeDateOfBirth.setYear(calendar.get(Calendar.YEAR));
        } catch (Exception exception){
            throw new Exception("Cannot parse date of birth");
        }
        return employeeDateOfBirth;
    }

    public static String isValidRequest(EmployeeRequest employeeRequest) {
        if(!Utils.isValidRequestField(Constants.FULL_NAME_REGEX, employeeRequest.getFirstName())){
            return Utils.getErrorMessage(RequestErrorEnums.FIRST_NAME_ERROR);
        }
        if(!Utils.isValidRequestField(Constants.FULL_NAME_REGEX, employeeRequest.getLastName())){
            return Utils.getErrorMessage(RequestErrorEnums.LAST_NAME_ERROR);
        }
        if(!Utils.isValidRequestField(Constants.STATE_CITY_REGEX, employeeRequest.getAddress().getCity())){
            return Utils.getErrorMessage(RequestErrorEnums.ADDRESS_CITY_ERROR);
        }
        if(!Utils.isValidRequestField(Constants.STATE_CITY_REGEX, employeeRequest.getAddress().getState())){
            return Utils.getErrorMessage(RequestErrorEnums.ADDRESS_STATE_ERROR);
        }
        if(!Utils.isValidRequestField(Constants.COUNTRY_REGEX, employeeRequest.getAddress().getCountry())){
            return Utils.getErrorMessage(RequestErrorEnums.ADDRESS_COUNTRY_ERROR);
        }
        if(!Utils.isValidRequestField(Constants.ZIP_CODE_REGEX, employeeRequest.getAddress().getZipCode())){
            return Utils.getErrorMessage(RequestErrorEnums.ADDRESS_ZIPCODE_ERROR);
        }
        return "";
    }
    
    public static String isValidFirstAndLastName(final String nameValue) {
		boolean isValidRequestField = Utils.isValidRequestField(Constants.FULL_NAME_REGEX, nameValue);
		if (isValidRequestField) {
			return null;
		}
		return RequestErrorEnums.FIRST_NAME_ERROR.getErrorMessage();
	}
    
    public static String isValidCityName(final String cityValue) {
		boolean isValidRequestField = Utils.isValidRequestField(Constants.STATE_CITY_REGEX, cityValue);
		if (isValidRequestField) {
			return null;
		}
		return RequestErrorEnums.ADDRESS_CITY_ERROR.getErrorMessage();
	}
    
    public static String isValidStateName(final String stateValue) {
		boolean isValidRequestField = Utils.isValidRequestField(Constants.STATE_CITY_REGEX, stateValue);
		if (isValidRequestField) {
			return null;
		}
		return RequestErrorEnums.ADDRESS_STATE_ERROR.getErrorMessage();
	}
    
    public static String isValidCountryName(final String countryValue) {
		boolean isValidRequestField = Utils.isValidRequestField(Constants.COUNTRY_REGEX, countryValue);
		if (isValidRequestField) {
			return null;
		}
		return RequestErrorEnums.ADDRESS_COUNTRY_ERROR.getErrorMessage();
	}
    
    public static String isValidZipCode(final String zipcodeValue) {
		boolean isValidRequestField = Utils.isValidRequestField(Constants.ZIP_CODE_REGEX, zipcodeValue);
		if (isValidRequestField) {
			return null;
		}
		return RequestErrorEnums.ADDRESS_ZIPCODE_ERROR.getErrorMessage();
	}
    
    public static String isValidDateOfBirth(final String dateOfBirth) {
    	if (dateOfBirth != null) {
    		return null;
    	}
    	return RequestErrorEnums.DOB_INVALID_ERROR.getErrorMessage();
    }

    public static boolean isValidRequestField(String fieldRegex, String requestField) {
        if(requestField == null || requestField.length() == 0) {
            return false;
        }
        Pattern p = Pattern.compile(fieldRegex);
        Matcher m = p.matcher(requestField);
        return m.matches();
    }

    public static String getErrorMessage(RequestErrorEnums errorEnums) {
        return errorEnums.getErrorMessage();
    }

	public static EmployeeRequest convertDaoObjectToModel(Employee employeeRequest) {
		EmployeeRequest employee = new EmployeeRequest();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        try {
			employee.setDateOfBirth(Utils.parseDateOfBirth(employeeRequest.getDateOfBirth()));
		} catch (Exception e) {
			e.printStackTrace();
		}
        Address address = new Address();
        address.setLine1(employeeRequest.getAddressLine1());
        address.setLine2(employeeRequest.getAddressLine2());
        address.setCity(employeeRequest.getCity());
        address.setState(employeeRequest.getState());
        address.setCountry(employeeRequest.getCountry());
        address.setZipCode(employeeRequest.getZipCode());
        employee.setAddress(address);
        return employee;
	}
}
