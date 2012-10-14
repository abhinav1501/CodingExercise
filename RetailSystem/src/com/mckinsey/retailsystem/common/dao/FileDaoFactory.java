package com.mckinsey.retailsystem.common.dao;

import com.mckinsey.retailsystem.billmanagement.dao.BillManagementDao;
import com.mckinsey.retailsystem.billmanagement.dao.BillManagementDaoFileImpl;
import com.mckinsey.retailsystem.customermanagement.dao.CustomerManagementDao;
import com.mckinsey.retailsystem.customermanagement.dao.CustomerManagementDaoFileImpl;
import com.mckinsey.retailsystem.discountmanagement.dao.DiscountManagementDao;
import com.mckinsey.retailsystem.discountmanagement.dao.DiscountManagementDaoFileImpl;

public class FileDaoFactory  implements DaoFactory {

	@Override
	public CustomerManagementDao getCustomerManagementDao() {
		return new CustomerManagementDaoFileImpl();
	}

	@Override
	public DiscountManagementDao getDiscountManagementDao() {
		return new DiscountManagementDaoFileImpl();
	}

	@Override
	public BillManagementDao getBillManagementDao() {
		return new BillManagementDaoFileImpl();
	}
	
}