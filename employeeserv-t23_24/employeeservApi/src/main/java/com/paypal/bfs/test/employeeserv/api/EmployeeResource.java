package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.dao.*;
import com.paypal.bfs.test.employeeserv.model.*;
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
    ResponseEntity<EmployeeRequest> employeeGetById(@PathVariable("id") long id) throws Exception;

    /**
     * Creates the {@link Employee} resource
     *
     * @return {@link Employee} resource upon successful creation.
     */
    @PostMapping("/v1/bfs/employees")
    ResponseEntity<EmployeeRequest> createEmployee(@RequestBody EmployeeRequest employeeDetails);
}
