package com.mckinsey.retailsystem.customermanagement.dao;

import com.mckinsey.retailsystem.common.exception.DataAccessException;
import com.mckinsey.retailsystem.customermanagement.domain.Customer;
import com.mckinsey.retailsystem.customermanagement.domain.CustomerTypes;

public class CustomerManagementDaoFileImpl implements CustomerManagementDao {
	
	@Override
	public Customer getCustomerFromCustomerId(long customerId) throws DataAccessException {
		
		// ideally this should be picked from file. hard coding for now!
		
		return getHardCodedCustomerFromCustomerId(customerId);
	}
	
	private Customer getHardCodedCustomerFromCustomerId(long customerId) {
		if (customerId == 111l) {
			return new Customer(CustomerTypes.EMPLOYEE);
		}
		
		if (customerId == 112l) {
			return new Customer(CustomerTypes.AFFILIATE);
		}
		
		if (customerId == 113l) {
			return new Customer(CustomerTypes.LOYAL_CUSTOMER);
		}
		return new Customer(CustomerTypes.ANYONE);
	}
	

}
