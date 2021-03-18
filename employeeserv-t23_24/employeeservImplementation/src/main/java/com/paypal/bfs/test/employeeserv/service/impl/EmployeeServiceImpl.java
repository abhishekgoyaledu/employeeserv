package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.*;
import com.paypal.bfs.test.employeeserv.dao.*;
import com.paypal.bfs.test.employeeserv.service.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeJpaRepository employeeDao;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Optional<Employee> getEmployee(int id) {
        return employeeDao.findById(Long.valueOf(id));
    }
}
