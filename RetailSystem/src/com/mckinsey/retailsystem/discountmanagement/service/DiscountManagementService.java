package com.mckinsey.retailsystem.discountmanagement.service;

import com.mckinsey.retailsystem.billmanagement.domain.Bill;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;

public interface DiscountManagementService {
	
	public Double computeDiscountFromBill(Bill  bill)  throws ApplicationBusinessException ;
	
}
