package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.dao.*;
import com.paypal.bfs.test.employeeserv.exception.*;
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
    public ResponseEntity<EmployeeRequest> employeeGetById(long id) throws Exception {
        Employee employee = null;
        Employee empEntity = employeeService.getEmployee(id).get();
        EmployeeRequest employeeRequest = Utils.convertEntityToResponse(empEntity);
        return new ResponseEntity<>(employeeRequest, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<EmployeeRequest> createEmployee(EmployeeRequest employeeDetails) {
        String valiationError = Utils.isValidRequest(employeeDetails);
        if(valiationError.length() == 0){
            Employee employeeEntity = Utils.convertRequestToEntity(employeeDetails);
            employeeEntity = employeeService.createEmployee(employeeEntity);
            return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
        }
        throw new InvalidEmployeeDataException(valiationError);
    }

}
