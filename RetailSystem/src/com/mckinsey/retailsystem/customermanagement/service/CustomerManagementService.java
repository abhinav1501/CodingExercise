package com.mckinsey.retailsystem.customermanagement.service;

import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.customermanagement.domain.Customer;

public interface CustomerManagementService {
	
	public Customer getCustomerFromCustomerId(long customerId)  throws ApplicationBusinessException;

}
