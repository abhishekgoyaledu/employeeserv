package com.paypal.bfs.test.employeeserv.service;

import java.util.List;
import java.util.Optional;
import com.paypal.bfs.test.employeeserv.dao.*;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	
	public Optional<Employee> getEmployee(int id);
}
