package com.mckinsey.retailsystem.customermanagement.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mckinsey.retailsystem.common.exception.DataAccessException;
import com.mckinsey.retailsystem.customermanagement.domain.Customer;
import com.mckinsey.retailsystem.customermanagement.domain.CustomerTypes;


public class CustomerManagementDaoFileImplTest {

	@Test
	public void testGetCustomerFromCustomerIdEmployeeType() throws DataAccessException {
		CustomerManagementDaoFileImpl  customerMgmtDaoFile = new CustomerManagementDaoFileImpl();
		Customer result = customerMgmtDaoFile.getCustomerFromCustomerId(111L);
		Customer expected = new Customer(CustomerTypes.EMPLOYEE);
		assertNotNull(result);
		assertEquals(result.getCustomerType().getType(), expected.getCustomerType().getType());
	}
	
	@Test
	public void testGetCustomerFromCustomerIdAffiliateType() throws DataAccessException {
		CustomerManagementDaoFileImpl  customerMgmtDaoFile = new CustomerManagementDaoFileImpl();
		Customer result = customerMgmtDaoFile.getCustomerFromCustomerId(112L);
		Customer expected = new Customer(CustomerTypes.AFFILIATE);
		assertNotNull(result);
		assertEquals(result.getCustomerType().getType(), expected.getCustomerType().getType());
	}
	
	@Test
	public void testGetCustomerFromCustomerIdLoyalCustomerType() throws DataAccessException {
		CustomerManagementDaoFileImpl  customerMgmtDaoFile = new CustomerManagementDaoFileImpl();
		Customer result = customerMgmtDaoFile.getCustomerFromCustomerId(113L);
		Customer expected = new Customer(CustomerTypes.LOYAL_CUSTOMER);
		assertNotNull(result);
		assertEquals(result.getCustomerType().getType(), expected.getCustomerType().getType());
	}
	
	@Test
	public void testGetCustomerFromCustomerIdAnyoneType() throws DataAccessException {
		CustomerManagementDaoFileImpl  customerMgmtDaoFile = new CustomerManagementDaoFileImpl();
		Customer result = customerMgmtDaoFile.getCustomerFromCustomerId(999L);
		Customer expected = new Customer(CustomerTypes.ANYONE);
		assertNotNull(result);
		assertEquals(result.getCustomerType().getType(), expected.getCustomerType().getType());
	}

}
