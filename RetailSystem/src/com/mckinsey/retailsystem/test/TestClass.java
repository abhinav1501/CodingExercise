package com.mckinsey.retailsystem.test;

import java.util.HashMap;
import java.util.Map;

import com.mckinsey.retailsystem.billmanagement.domain.Bill;
import com.mckinsey.retailsystem.billmanagement.service.BillManagementServiceImpl;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.inventorymanagement.domain.Product;
import com.mckinsey.retailsystem.inventorymanagement.domain.ProductTypes;

public class TestClass {
	
	public static void main(String[] args) {
		
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 500);
		itemizedQty.put(product2, 100);
		
		BillManagementServiceImpl	billService = new BillManagementServiceImpl();
		try {
			Bill bill = billService.generateBill(itemizedQty, 113l);
			System.out.println("-----"+bill.getTotalDiscountAmount());
		} catch (ApplicationBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
