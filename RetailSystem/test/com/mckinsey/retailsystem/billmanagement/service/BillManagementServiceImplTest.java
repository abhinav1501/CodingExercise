package com.mckinsey.retailsystem.billmanagement.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mckinsey.retailsystem.billmanagement.domain.Bill;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.inventorymanagement.domain.Product;
import com.mckinsey.retailsystem.inventorymanagement.domain.ProductTypes;

public class BillManagementServiceImplTest {

	@Test
	public void testGenerateBill1() throws ApplicationBusinessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		BillManagementServiceImpl	fixture = new BillManagementServiceImpl();
		Bill bill = fixture.generateBill(itemizedQty, 111l);
		
		assertNotNull(bill);
		assertEquals(950.0, bill.getTotalUndiscountedBillAmount(), 0);
		assertEquals(75.0, bill.getTotalDiscountAmount(), 0);
		assertEquals(875.0, bill.getTotalPayableAmount(), 0);		
	}
	
	@Test
	public void testGenerateBill2() throws ApplicationBusinessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		BillManagementServiceImpl	fixture = new BillManagementServiceImpl();
		Bill bill = fixture.generateBill(itemizedQty, 112l);
		
		assertNotNull(bill);
		assertEquals(950.0, bill.getTotalUndiscountedBillAmount(), 0);
		assertEquals(45.0, bill.getTotalDiscountAmount(), 0);
		assertEquals(905.0, bill.getTotalPayableAmount(), 0);		
	}
	
	@Test
	public void testGenerateBill3() throws ApplicationBusinessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		BillManagementServiceImpl	fixture = new BillManagementServiceImpl();
		Bill bill = fixture.generateBill(itemizedQty, 113l);
		
		assertNotNull(bill);
		assertEquals(950.0, bill.getTotalUndiscountedBillAmount(), 0);
		assertEquals(45.0, bill.getTotalDiscountAmount(), 0);
		assertEquals(905.0, bill.getTotalPayableAmount(), 0);		
	}

	
	@Test
	public void testGenerateBill4() throws ApplicationBusinessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		BillManagementServiceImpl	fixture = new BillManagementServiceImpl();
		Bill bill = fixture.generateBill(itemizedQty, 114l);
		
		assertNotNull(bill);
		assertEquals(950.0, bill.getTotalUndiscountedBillAmount(), 0);
		assertEquals(45.0, bill.getTotalDiscountAmount(), 0);
		assertEquals(905.0, bill.getTotalPayableAmount(), 0);		
	}

	
	@Test
	public void testGenerateBill5() throws ApplicationBusinessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		
		itemizedQty.put(product1, 50);
		
		BillManagementServiceImpl	fixture = new BillManagementServiceImpl();
		Bill bill = fixture.generateBill(itemizedQty, 111l);
		
		assertNotNull(bill);
		assertEquals(250.0, bill.getTotalUndiscountedBillAmount(), 0);
		assertEquals(75.0, bill.getTotalDiscountAmount(), 0);
		assertEquals(175.0, bill.getTotalPayableAmount(), 0);		
	}

	
	@Test
	public void testGenerateBill6() throws ApplicationBusinessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		
		itemizedQty.put(product1, 50);
		
		BillManagementServiceImpl	fixture = new BillManagementServiceImpl();
		Bill bill = fixture.generateBill(itemizedQty, 112l);
		
		assertNotNull(bill);
		assertEquals(250.0, bill.getTotalUndiscountedBillAmount(), 0);
		assertEquals(25.0, bill.getTotalDiscountAmount(), 0);
		assertEquals(225.0, bill.getTotalPayableAmount(), 0);		
	}

	
	@Test
	public void testGenerateBill7() throws ApplicationBusinessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product2, 100);
		
		BillManagementServiceImpl	fixture = new BillManagementServiceImpl();
		Bill bill = fixture.generateBill(itemizedQty, 113l);
		
		assertNotNull(bill);
		assertEquals(700.0, bill.getTotalUndiscountedBillAmount(), 0);
		assertEquals(35.0, bill.getTotalDiscountAmount(), 0);
		assertEquals(665.0, bill.getTotalPayableAmount(), 0);		
	}

	
	@Test
	public void testGenerateBill8() throws ApplicationBusinessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		
		itemizedQty.put(product1, 50);
		
		BillManagementServiceImpl	fixture = new BillManagementServiceImpl();
		Bill bill = fixture.generateBill(itemizedQty, 115l);
		
		assertNotNull(bill);
		assertEquals(250.0, bill.getTotalUndiscountedBillAmount(), 0);
		assertEquals(10.0, bill.getTotalDiscountAmount(), 0);
		assertEquals(240.0, bill.getTotalPayableAmount(), 0);		
	}

}
