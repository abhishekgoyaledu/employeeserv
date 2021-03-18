package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @GetMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);

    /**
     * Creates the {@link Employee} resource
     *
     * @return {@link Employee} resource upon successful creation.
     */
    @PostMapping("/v1/bfs/employees")
    ResponseEntity<Employee> employeeGetById(@RequestBody Employee employeeDetails);
}
