package com.paypal.bfs.test.employeeserv.utils;

import com.paypal.bfs.test.employeeserv.dao.*;
import com.paypal.bfs.test.employeeserv.model.*;

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

    public static EmployeeRequest convertEntityToResponse(Employee employeeRequest) {
        EmployeeRequest employee = new EmployeeRequest();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        return employee;
    }
}
