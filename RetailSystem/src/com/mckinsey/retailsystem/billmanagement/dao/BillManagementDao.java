package com.mckinsey.retailsystem.billmanagement.dao;

import com.mckinsey.retailsystem.common.exception.DataAccessException;

public interface BillManagementDao {
	
	public long  getNextAvailableBillNo() throws DataAccessException;
	

}
