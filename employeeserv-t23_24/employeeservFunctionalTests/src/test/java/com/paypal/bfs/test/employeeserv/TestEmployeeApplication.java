package com.paypal.bfs.test.employeeserv;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import com.paypal.bfs.test.employeeserv.enums.RequestErrorEnums;
import com.paypal.bfs.test.employeeserv.utils.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestEmployeeApplication {
	
	@Test
	public void testFirstAndLastName() { 
		//null test case
		Assert.assertEquals(RequestErrorEnums.FIRST_NAME_ERROR.getErrorMessage(), Utils.isValidFirstAndLastName(null));
		
		//Empty string test case
		Assert.assertEquals(RequestErrorEnums.FIRST_NAME_ERROR.getErrorMessage(), Utils.isValidFirstAndLastName(""));
		
		//Success test case
		Assert.assertEquals(null, Utils.isValidFirstAndLastName("Abhishek"));
		
		//Alpha numeric test case
		Assert.assertEquals(RequestErrorEnums.FIRST_NAME_ERROR.getErrorMessage(), Utils.isValidFirstAndLastName("Abhishek123"));
		
		//Max Length check
		Assert.assertEquals(RequestErrorEnums.FIRST_NAME_ERROR.getErrorMessage(), Utils.isValidFirstAndLastName(getMaxLengthString(256)));
	}
	
	public String getMaxLengthString(int length) {
		char[] nameArr = new char[length+1];
		for(int i = 0; i < length+1; i++) {
			nameArr[i] = 'a';
		}
		return new String(nameArr);
	} 
	
	@Test
	public void testCityName() {
		//null test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_CITY_ERROR.getErrorMessage(), Utils.isValidCityName(null));
		
		//Empty string test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_CITY_ERROR.getErrorMessage(), Utils.isValidCityName(""));
		
		//Success test case
		Assert.assertEquals(null, Utils.isValidFirstAndLastName("Jaipur"));
		
		//Alpha numeric test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_CITY_ERROR.getErrorMessage(), Utils.isValidCityName("Jaipur123"));
		
		//Max Length check
		Assert.assertEquals(RequestErrorEnums.ADDRESS_CITY_ERROR.getErrorMessage(), Utils.isValidCityName(getMaxLengthString(95)));
	}
	
	@Test
	public void testStateName() {
		//null test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_STATE_ERROR.getErrorMessage(), Utils.isValidStateName(null));
		
		//Empty string test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_STATE_ERROR.getErrorMessage(), Utils.isValidStateName(""));
		
		//Success test case
		Assert.assertEquals(null, Utils.isValidFirstAndLastName("Rajasthan"));
		
		//Alpha numeric test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_STATE_ERROR.getErrorMessage(), Utils.isValidStateName("Raj123"));
		
		//Max Length check
		Assert.assertEquals(RequestErrorEnums.ADDRESS_STATE_ERROR.getErrorMessage(), Utils.isValidStateName(getMaxLengthString(95)));
	}
	
	@Test
	public void testCountryName() {
		//null test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_COUNTRY_ERROR.getErrorMessage(), Utils.isValidCountryName(null));
		
		//Empty string test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_COUNTRY_ERROR.getErrorMessage(), Utils.isValidCountryName(""));
		
		//Success test case
		Assert.assertEquals(null, Utils.isValidFirstAndLastName("Rajasthan"));
		
		//Alpha numeric test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_COUNTRY_ERROR.getErrorMessage(), Utils.isValidCountryName("Raj123"));
		
		//Max Length check
		Assert.assertEquals(RequestErrorEnums.ADDRESS_COUNTRY_ERROR.getErrorMessage(), Utils.isValidCountryName(getMaxLengthString(85)));
	}
	
	@Test
	public void testZipCode() {
		//null test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_ZIPCODE_ERROR.getErrorMessage(), Utils.isValidZipCode(null));
		
		//Empty string test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_ZIPCODE_ERROR.getErrorMessage(), Utils.isValidZipCode(""));
		
		//Success test case
		Assert.assertEquals(null, Utils.isValidFirstAndLastName("Rajasthan"));
		
		//Alpha numeric test case
		Assert.assertEquals(RequestErrorEnums.ADDRESS_ZIPCODE_ERROR.getErrorMessage(), Utils.isValidZipCode("Raj123"));
		
		//Max Length check
		Assert.assertEquals(RequestErrorEnums.ADDRESS_ZIPCODE_ERROR.getErrorMessage(), Utils.isValidZipCode(getMaxLengthString(85)));
	}
	
	@Test
	public void testDateOfBirth() {
		//null test case
		Assert.assertEquals(RequestErrorEnums.DOB_INVALID_ERROR.getErrorMessage(), Utils.isValidDateOfBirth(null));
		
		//Success test case
		Assert.assertEquals(null, Utils.isValidDateOfBirth("04/03/1992"));
	}
}
