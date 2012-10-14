package com.mckinsey.retailsystem.common.dao;

import com.mckinsey.retailsystem.billmanagement.dao.BillManagementDao;
import com.mckinsey.retailsystem.billmanagement.dao.BillManagementDaoDBImpl;
import com.mckinsey.retailsystem.customermanagement.dao.CustomerManagementDao;
import com.mckinsey.retailsystem.customermanagement.dao.CustomerManagementDaoDBImpl;
import com.mckinsey.retailsystem.discountmanagement.dao.DiscountManagementDao;
import com.mckinsey.retailsystem.discountmanagement.dao.DiscountManagementDaoDBImpl;

public class DataBaseDaoFactory implements DaoFactory {

	@Override
	public CustomerManagementDao getCustomerManagementDao() {
		return new CustomerManagementDaoDBImpl();
	}

	@Override
	public DiscountManagementDao getDiscountManagementDao() {
		return new DiscountManagementDaoDBImpl();
	}
	
	@Override
	public BillManagementDao getBillManagementDao() {
		return new BillManagementDaoDBImpl();
	}

}
