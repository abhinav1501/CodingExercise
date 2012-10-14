package com.mckinsey.retailsystem.common.dao;

import com.mckinsey.retailsystem.billmanagement.dao.BillManagementDao;
import com.mckinsey.retailsystem.customermanagement.dao.CustomerManagementDao;
import com.mckinsey.retailsystem.discountmanagement.dao.DiscountManagementDao;

public interface DaoFactory {
	
	public CustomerManagementDao getCustomerManagementDao();
	
	public DiscountManagementDao getDiscountManagementDao();
	
	public BillManagementDao	getBillManagementDao();
	
	

}
