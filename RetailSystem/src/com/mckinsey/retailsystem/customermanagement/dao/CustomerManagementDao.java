package com.mckinsey.retailsystem.customermanagement.dao;

import com.mckinsey.retailsystem.common.exception.DataAccessException;
import com.mckinsey.retailsystem.customermanagement.domain.Customer;

public interface CustomerManagementDao {
	
	public Customer getCustomerFromCustomerId(long customerId) throws DataAccessException;

}
