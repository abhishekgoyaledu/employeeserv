package com.paypal.bfs.test.employeeserv.enums;

public enum RequestErrorEnums {

    //Name error mapping
    FIRST_NAME_ERROR("first name can contain only alphabets and maximum length allowed is 255"),
    LAST_NAME_ERROR("last name can contain only alphabets and maximum length allowed is 255"),

    //date of birth error enum
    DOB_INVALID_ERROR ("date of birth is invalid."),

    //address error scenarios enum
    ADDRESS_LINE_1_ERROR("address line 1 is mandatory field"),
    ADDRESS_CITY_ERROR("city can only contain alphabet and maximum length is 90"),
    ADDRESS_STATE_ERROR("city can only contain alphabet and maximum length is 90"),
    ADDRESS_COUNTRY_ERROR("city can only contain alphabet and maximum length is 80"),
    ADDRESS_ZIPCODE_ERROR("city can only contain numeric values and maximum length is 20");

    private final String errorMessage;

    RequestErrorEnums(String type) {
        this.errorMessage = type;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
