package com.mckinsey.retailsystem.customermanagement.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.customermanagement.domain.Customer;
import com.mckinsey.retailsystem.customermanagement.domain.CustomerTypes;

public class CustomerManagementServiceImplTest {

	@Test
	public void testGetCustomerOfTypeEmployeeFromCustomerId() throws ApplicationBusinessException {
		CustomerManagementServiceImpl  fixture = new CustomerManagementServiceImpl();
		Customer result = fixture.getCustomerFromCustomerId(111l);
		assertNotNull(result);
		assertEquals(CustomerTypes.EMPLOYEE.getType(), result.getCustomerType().getType());
	}
	
	@Test
	public void testGetCustomerOfTypeAffiliateFromCustomerId() throws ApplicationBusinessException {
		CustomerManagementServiceImpl  fixture = new CustomerManagementServiceImpl();
		Customer result = fixture.getCustomerFromCustomerId(112l);
		assertNotNull(result);
		assertEquals(CustomerTypes.AFFILIATE.getType(), result.getCustomerType().getType());
	}
	
	@Test
	public void testGetCustomerOfTypeLoyalCustomerFromCustomerId() throws ApplicationBusinessException {
		CustomerManagementServiceImpl  fixture = new CustomerManagementServiceImpl();
		Customer result = fixture.getCustomerFromCustomerId(113l);
		assertNotNull(result);
		assertEquals(CustomerTypes.LOYAL_CUSTOMER.getType(), result.getCustomerType().getType());
	}
	
	@Test
	public void testGetCustomerOfTypeAnyoneFromCustomerId() throws ApplicationBusinessException {
		CustomerManagementServiceImpl  fixture = new CustomerManagementServiceImpl();
		Customer result = fixture.getCustomerFromCustomerId(118l);
		assertNotNull(result);
		assertEquals(CustomerTypes.ANYONE.getType(), result.getCustomerType().getType());
	}

}
