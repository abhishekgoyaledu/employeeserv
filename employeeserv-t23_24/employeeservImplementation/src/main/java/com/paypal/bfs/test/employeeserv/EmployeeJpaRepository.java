package com.paypal.bfs.test.employeeserv;

import com.paypal.bfs.test.employeeserv.dao.*;
import org.springframework.data.jpa.repository.*;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

}

