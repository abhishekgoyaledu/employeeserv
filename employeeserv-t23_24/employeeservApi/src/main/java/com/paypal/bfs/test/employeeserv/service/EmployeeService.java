package com.paypal.bfs.test.employeeserv.service;

import java.util.Optional;
import com.paypal.bfs.test.employeeserv.dao.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	
	public Optional<Employee> getEmployeeByEmployeeByID(long id);

	public Optional<Employee> getEmployeeByEmployeeObject(Employee employee);
}
