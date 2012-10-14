package com.mckinsey.retailsystem.discountmanagement.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.mckinsey.retailsystem.billmanagement.domain.Bill;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.customermanagement.domain.Customer;
import com.mckinsey.retailsystem.customermanagement.domain.CustomerTypes;
import com.mckinsey.retailsystem.inventorymanagement.domain.Product;
import com.mckinsey.retailsystem.inventorymanagement.domain.ProductTypes;

public class DiscountManagementServiceImplTest {
	
	
	@Test
	public void testComputeDiscountFromBill1() throws ApplicationBusinessException {
		DiscountManagementServiceImpl  fixture = new DiscountManagementServiceImpl();
		
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		Customer customer = new Customer(CustomerTypes.EMPLOYEE);
		
		Bill bill = new Bill(999l, customer, itemizedQty);
		computeTotalUndiscountedBillAmount(bill);
		Double result = fixture.computeDiscountFromBill(bill);
		assertNotNull(result);
		assertEquals(75.0, result.doubleValue(), 0);
	}
	
	@Test
	public void testComputeDiscountFromBill2() throws ApplicationBusinessException {
		DiscountManagementServiceImpl  fixture = new DiscountManagementServiceImpl();
		
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 500);
		itemizedQty.put(product2, 100);
		
		Customer customer = new Customer(CustomerTypes.AFFILIATE);
		
		Bill bill = new Bill(999l, customer, itemizedQty);
		computeTotalUndiscountedBillAmount(bill);
		Double result = fixture.computeDiscountFromBill(bill);
		assertNotNull(result);
		assertEquals(250, result.doubleValue(), 0);
	}
	
	@Test
	public void testComputeDiscountFromBill3() throws ApplicationBusinessException {
		DiscountManagementServiceImpl  fixture = new DiscountManagementServiceImpl();
		
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 500);
		itemizedQty.put(product2, 100);
		
		Customer customer = new Customer(CustomerTypes.LOYAL_CUSTOMER);
		
		Bill bill = new Bill(999l, customer, itemizedQty);
		computeTotalUndiscountedBillAmount(bill);
		Double result = fixture.computeDiscountFromBill(bill);
		assertNotNull(result);
		assertEquals(160, result.doubleValue(), 0);
	}
	
	@Test
	public void testComputeDiscountFromBill4() throws ApplicationBusinessException {
		DiscountManagementServiceImpl  fixture = new DiscountManagementServiceImpl();
		
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 250);
		itemizedQty.put(product2, 100);
		
		Customer customer = new Customer(CustomerTypes.ANYONE);
		
		Bill bill = new Bill(997l, customer, itemizedQty);
		computeTotalUndiscountedBillAmount(bill);
		Double result = fixture.computeDiscountFromBill(bill);
		assertNotNull(result);
		assertEquals(95.0, result.doubleValue(),0);
	}
	
	@Test
	public void testComputeDiscountFromBill5() throws ApplicationBusinessException {
		DiscountManagementServiceImpl  fixture = new DiscountManagementServiceImpl();
		
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		
		itemizedQty.put(product1, 50);
		
		Customer customer = new Customer(CustomerTypes.EMPLOYEE);
		
		Bill bill = new Bill(999l, customer, itemizedQty);
		computeTotalUndiscountedBillAmount(bill);
		Double result = fixture.computeDiscountFromBill(bill);
		assertNotNull(result);
		assertEquals(75.0, result.doubleValue(), 0);
	}
	
	@Test
	public void testComputeDiscountFromBill6() throws ApplicationBusinessException {
		DiscountManagementServiceImpl  fixture = new DiscountManagementServiceImpl();
		
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		
		itemizedQty.put(product1, 500);
		
		Customer customer = new Customer(CustomerTypes.AFFILIATE);
		
		Bill bill = new Bill(999l, customer, itemizedQty);
		computeTotalUndiscountedBillAmount(bill);
		Double result = fixture.computeDiscountFromBill(bill);
		assertNotNull(result);
		assertEquals(250, result.doubleValue(), 0);
	}
	
	@Test
	public void testComputeDiscountFromBill7() throws ApplicationBusinessException {
		DiscountManagementServiceImpl  fixture = new DiscountManagementServiceImpl();
		
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		
		itemizedQty.put(product1, 500);
		
		Customer customer = new Customer(CustomerTypes.LOYAL_CUSTOMER);
		
		Bill bill = new Bill(999l, customer, itemizedQty);
		computeTotalUndiscountedBillAmount(bill);
		Double result = fixture.computeDiscountFromBill(bill);
		assertNotNull(result);
		assertEquals(125, result.doubleValue(), 0);
	}
	
	@Test
	public void testComputeDiscountFromBill8() throws ApplicationBusinessException {
		DiscountManagementServiceImpl  fixture = new DiscountManagementServiceImpl();
		
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		
		itemizedQty.put(product1, 250);
		
		Customer customer = new Customer(CustomerTypes.ANYONE);
		
		Bill bill = new Bill(997l, customer, itemizedQty);
		computeTotalUndiscountedBillAmount(bill);
		Double result = fixture.computeDiscountFromBill(bill);
		assertNotNull(result);
		assertEquals(95.0, result.doubleValue(),0);
	}
	
	private void computeTotalUndiscountedBillAmount(Bill bill) {
		Double undiscountedBillAmount = 0d;
		Map<Product, Integer>  itemizedQuantity  = bill.getItemizedQuantity();
		if (itemizedQuantity == null || itemizedQuantity.isEmpty()) {
			return;
		}
		Set<Map.Entry<Product, Integer>>  itemsSet = itemizedQuantity.entrySet();
		for (Map.Entry<Product, Integer>  itemsMap : itemsSet) {
			Double price = itemsMap.getKey().getPrice();
			undiscountedBillAmount = undiscountedBillAmount + (price * itemsMap.getValue());
		}
		bill.setTotalUndiscountedBillAmount(undiscountedBillAmount);
	}

}
