package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.dao.*;
import com.paypal.bfs.test.employeeserv.model.*;
import com.paypal.bfs.test.employeeserv.service.*;
import com.paypal.bfs.test.employeeserv.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.*;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeRequest> employeeGetById(String id) {
        Employee employee = null;
        Employee empEntity = employeeService.getEmployee(Integer.parseInt(id.trim())).get();

        EmployeeRequest employeeRequest = Utils.convertEntityToResponse(empEntity);

        return new ResponseEntity<>(employeeRequest, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<Employee> createEmployee(EmployeeRequest employeeDetails) {
        Employee employeeEntity = Utils.convertRequestToEntity(employeeDetails);
        employeeEntity = employeeService.createEmployee(employeeEntity);
        return null;
    }

}
