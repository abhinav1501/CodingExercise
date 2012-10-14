package com.mckinsey.retailsystem.billmanagement.dao;

import com.mckinsey.retailsystem.common.exception.DataAccessException;

public class BillManagementDaoFileImpl implements BillManagementDao {
	
	@Override
	public long getNextAvailableBillNo() throws DataAccessException {
		return getHardCodedAvailableBillNo();
	}
	
	private long getHardCodedAvailableBillNo() {
		return 999l;
	}
}