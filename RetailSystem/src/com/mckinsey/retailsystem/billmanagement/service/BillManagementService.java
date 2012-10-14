package com.mckinsey.retailsystem.billmanagement.service;

import java.util.Map;

import com.mckinsey.retailsystem.billmanagement.domain.Bill;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.inventorymanagement.domain.Product;

public interface BillManagementService {
	
	public Double getNetPayableAmount(Bill bill) throws ApplicationBusinessException;
	
	public Bill generateBill(Map<Product, Integer>  itemizedQuantity, Long customerId) throws ApplicationBusinessException;

}
