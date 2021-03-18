package com.paypal.bfs.test.employeeserv.exception;

import java.util.*;

public class InvalidEmployeeDataException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidEmployeeDataException(String mesage) {
        super(mesage);
    }
}
