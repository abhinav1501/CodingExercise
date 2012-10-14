package com.mckinsey.retailsystem.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mckinsey.retailsystem.billmanagement.service.BillManagementService;
import com.mckinsey.retailsystem.common.exception.ExceptionCodes;
import com.mckinsey.retailsystem.common.exception.SystemInitializationException;
import com.mckinsey.retailsystem.customermanagement.service.CustomerManagementService;
import com.mckinsey.retailsystem.discountmanagement.service.DiscountManagementService;

public class ServiceProviderTest {

	@Test
	public void testGetCustomerMgmtService() throws SystemInitializationException {
		Object service = ServiceProvider.getService(Services.CUSTOMER_MGMT.getName());
		assertTrue(service instanceof CustomerManagementService);
	}
	
	@Test
	public void testGetBillingMgmtService() throws SystemInitializationException {
		Object service = ServiceProvider.getService(Services.BILL_MGMT.getName());
		assertTrue(service instanceof BillManagementService);
	}
	
	@Test
	public void testGetDiscountMgmtService() throws SystemInitializationException {
		Object service = ServiceProvider.getService(Services.DISCOUNT_MGMT.getName());
		assertTrue(service instanceof DiscountManagementService);
	}
	
	@Test(expected=SystemInitializationException.class)
	public void testGetUnknownService1() throws SystemInitializationException {
		Object service = ServiceProvider.getService("unknown");
	}
	
	@Test
	public void testGetUnknownService2() {
		try {
			Object service = ServiceProvider.getService("unknown");
		} catch (SystemInitializationException e) {
			assertEquals(e.getMessage(), ExceptionCodes.SERVICE_NOT_FOUND.getType());
		}
	}
	
	@Test(expected=SystemInitializationException.class)
	public void testGetNullService1() throws SystemInitializationException {
		Object service = ServiceProvider.getService(null);
	}
	
	@Test
	public void testGetNullService2() {
		try {
			Object service = ServiceProvider.getService(null);
		} catch (SystemInitializationException e) {
			assertEquals(e.getMessage(), ExceptionCodes.SERVICE_NOT_FOUND.getType());
		}
	}

}
