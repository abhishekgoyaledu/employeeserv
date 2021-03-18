package com.paypal.bfs.test.employeeserv.utils;

public class Constants {

    //Contains only upper and lower case A-Z a-z with maximum length of 255
    public static final String FULL_NAME_REGEX = "^[A-Za-z]{1,255}$";

    //Contains only upper and lower case A-Z a-z with maximum length of 90
    public static final String STATE_CITY_REGEX = "^[A-Za-z]{1,90}$";

    //Contains only upper and lower case A-Z a-z with maximum length of 80
    public static final String COUNTRY_REGEX = "^[A-Za-z]{1,80}$";

    //Contains only numeric from 6-20 digits only
    public static final String ZIP_CODE_REGEX = "^[0-9]{6,20}$";
}

