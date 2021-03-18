package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.dao.*;
import com.paypal.bfs.test.employeeserv.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Override
    public ResponseEntity<EmployeeRequest> employeeGetById(String id) {

        EmployeeRequest employeeRequest = new EmployeeRequest();
//        employee.setId(Integer.valueOf(id));
//        employee.setFirstName("BFS");
//        employee.setLastName("Developer");

        return new ResponseEntity<>(employeeRequest, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeRequest employeeDetails) {
        return null;
    }

}
