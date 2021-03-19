package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.dao.Employee;
import com.paypal.bfs.test.employeeserv.exception.*;
import com.paypal.bfs.test.employeeserv.model.*;
import com.paypal.bfs.test.employeeserv.service.*;
import com.paypal.bfs.test.employeeserv.utils.*;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

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
    	try {
    		Employee empEntity = employeeService.getEmployeeByEmployeeByID(id).get();
            EmployeeRequest employeeRequest = Utils.convertDaoObjectToModel(empEntity);
            return new ResponseEntity<>(employeeRequest, HttpStatus.OK);
    	} catch(NoSuchElementException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

    @Override
    @Transactional
    public ResponseEntity<EmployeeRequest> createEmployee(EmployeeRequest employeeDetails) {
        String validationError = Utils.isValidRequest(employeeDetails);
        if(validationError.length() == 0){
            Employee employeeEntity = Utils.convertModelToDaoObject(employeeDetails);
            try {
                employeeEntity = employeeService.getEmployeeByEmployeeObject(employeeEntity).get();
            } catch (Exception e) {
                employeeEntity = employeeService.createEmployee(employeeEntity);
            }
            return new ResponseEntity<>(employeeDetails, HttpStatus.CREATED);
        }
        throw new InvalidEmployeeDataException(validationError);
    }
}
