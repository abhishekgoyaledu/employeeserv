package com.paypal.bfs.test.employeeserv.utils;

import com.paypal.bfs.test.employeeserv.dao.*;
import com.paypal.bfs.test.employeeserv.model.*;

import java.text.*;
import java.util.*;
import java.util.regex.*;

//Utility class in order to validate the request
public class Utils {

    public static Employee convertRequestToEntity(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();

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

    public static EmployeeRequest convertEntityToResponse(Employee employeeRequest) throws Exception {
        EmployeeRequest employee = new EmployeeRequest();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(Utils.parseDateOfBirth(employeeRequest.getDateOfBirth()));
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

    public static DateOfBirth parseDateOfBirth(String dateOfBirth) throws Exception {
        Date date = null;
        DateOfBirth employeeDateOfBirth = new DateOfBirth();
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
            employeeDateOfBirth.setDate(date.getDay());
            employeeDateOfBirth.setMonth(date.getMonth());
            employeeDateOfBirth.setYear(date.getYear());
        } catch (Exception exception){
            throw new Exception("Cannot parse date of birth");
        }
        return employeeDateOfBirth;
    }

    public static boolean isValidRequest(EmployeeRequest employeeRequest) {
        if(!Utils.isValidRequestField(Constants.FULL_NAME_REGEX, employeeRequest.getFirstName())){
            return false;
        }
        if(!Utils.isValidRequestField(Constants.FULL_NAME_REGEX, employeeRequest.getLastName())){
            return false;
        }
        if(!Utils.isValidRequestField(Constants.STATE_CITY_REGEX, employeeRequest.getAddress().getCity())){
            return false;
        }
        if(!Utils.isValidRequestField(Constants.STATE_CITY_REGEX, employeeRequest.getAddress().getState())){
            return false;
        }
        if(!Utils.isValidRequestField(Constants.COUNTRY_REGEX, employeeRequest.getAddress().getCountry())){
            return false;
        }
        if(!Utils.isValidRequestField(Constants.ZIP_CODE_REGEX, employeeRequest.getAddress().getZipCode())){
            return false;
        }
        return true;
    }

    public static boolean isValidRequestField(String fieldRegex, String requestField) {
        if(requestField.length() == 0) {
            return false;
        }
        Pattern p = Pattern.compile(fieldRegex);
        Matcher m = p.matcher(requestField);
        return m.matches();
    }
}
