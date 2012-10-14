package com.mckinsey.retailsystem.common.util;

import com.mckinsey.retailsystem.billmanagement.service.BillManagementServiceImpl;
import com.mckinsey.retailsystem.common.exception.ExceptionCodes;
import com.mckinsey.retailsystem.common.exception.SystemInitializationException;
import com.mckinsey.retailsystem.customermanagement.service.CustomerManagementServiceImpl;
import com.mckinsey.retailsystem.discountmanagement.service.DiscountManagementServiceImpl;

public class ServiceProvider {
	
	public static Object getService(String serviceName) throws SystemInitializationException {
		if (serviceName == null) {
			throw new SystemInitializationException(ExceptionCodes.SERVICE_NOT_FOUND.getType());
		}
		
		if (Services.BILL_MGMT.getName().equals(serviceName)) {
			return new BillManagementServiceImpl();
		}
		
		if (Services.CUSTOMER_MGMT.getName().equals(serviceName)) {
			return new CustomerManagementServiceImpl();
		}
		
		if (Services.DISCOUNT_MGMT.getName().equals(serviceName)) {
			return new DiscountManagementServiceImpl();
		}
		
		throw new SystemInitializationException(ExceptionCodes.SERVICE_NOT_FOUND.getType());
		
	}

}
