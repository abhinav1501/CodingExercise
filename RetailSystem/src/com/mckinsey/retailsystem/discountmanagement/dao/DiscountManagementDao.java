package com.mckinsey.retailsystem.discountmanagement.dao;

import java.util.List;

import com.mckinsey.retailsystem.common.exception.DataAccessException;
import com.mckinsey.retailsystem.discountmanagement.domain.Discount;

public interface DiscountManagementDao {
	
	public List<Discount>  getAllDiscounts() throws DataAccessException;
	

}
