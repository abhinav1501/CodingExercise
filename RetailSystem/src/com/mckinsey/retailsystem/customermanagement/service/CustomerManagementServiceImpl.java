package com.mckinsey.retailsystem.customermanagement.service;

import com.mckinsey.retailsystem.common.dao.DaoFactoryProvider;
import com.mckinsey.retailsystem.common.dao.DaoFactoryTypes;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.common.exception.DataAccessException;
import com.mckinsey.retailsystem.common.exception.ExceptionCodes;
import com.mckinsey.retailsystem.common.exception.SystemInitializationException;
import com.mckinsey.retailsystem.customermanagement.dao.CustomerManagementDao;
import com.mckinsey.retailsystem.customermanagement.domain.Customer;


public class CustomerManagementServiceImpl implements CustomerManagementService {
	
	private CustomerManagementDao	customerManagementDao;
	
	public CustomerManagementServiceImpl() {
		try {
			customerManagementDao 	= DaoFactoryProvider.getDaoFactory(DaoFactoryTypes.FILE.getType()).getCustomerManagementDao();	
		} catch (SystemInitializationException  sie) {
			// log exception
			// exit
		}
	}
	
	@Override
	public Customer getCustomerFromCustomerId(long customerId) throws ApplicationBusinessException {
		try {
			return customerManagementDao.getCustomerFromCustomerId(customerId);
		} catch (DataAccessException dae) {
			// log exception
			throw new ApplicationBusinessException(ExceptionCodes.UNKNOWN_EXCEPTION.getType());
		}
	}
}
