package com.mckinsey.retailsystem.billmanagement.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mckinsey.retailsystem.billmanagement.dao.BillManagementDao;
import com.mckinsey.retailsystem.billmanagement.dao.BillManagementDaoFileImpl;
import com.mckinsey.retailsystem.billmanagement.domain.Bill;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.common.exception.DataAccessException;
import com.mckinsey.retailsystem.customermanagement.domain.Customer;
import com.mckinsey.retailsystem.customermanagement.domain.CustomerTypes;
import com.mckinsey.retailsystem.customermanagement.service.CustomerManagementService;
import com.mckinsey.retailsystem.customermanagement.service.CustomerManagementServiceImpl;
import com.mckinsey.retailsystem.discountmanagement.dao.DiscountManagementDao;
import com.mckinsey.retailsystem.discountmanagement.domain.Discount;
import com.mckinsey.retailsystem.discountmanagement.domain.DiscountTypes;
import com.mckinsey.retailsystem.discountmanagement.service.DiscountManagementService;
import com.mckinsey.retailsystem.discountmanagement.service.DiscountManagementServiceImpl;
import com.mckinsey.retailsystem.inventorymanagement.domain.Product;
import com.mckinsey.retailsystem.inventorymanagement.domain.ProductTypes;

public class BillManagementServiceImplShould {
	
	DiscountManagementService	discountManagementService;
	CustomerManagementService	customerManagementService;	
	BillManagementDao			billManagementDao;	
	DiscountManagementDao		discountManagementDao;
	BillManagementServiceImpl	fixture;
	
	@Before
	public void fixtureSetup() {
		fixture = new BillManagementServiceImpl();
		customerManagementService = mock(CustomerManagementServiceImpl.class);
		billManagementDao = mock(BillManagementDaoFileImpl.class);
		discountManagementService = mock(DiscountManagementServiceImpl.class);
		discountManagementDao = mock(DiscountManagementDao.class);
		((DiscountManagementServiceImpl)discountManagementService).setDiscountManagementDao(discountManagementDao);
		fixture.setBillManagementDao(billManagementDao);
		fixture.setCustomerManagementService(customerManagementService);
		fixture.setDiscountManagementService(discountManagementService);
	}
	
	@Test (expected=ApplicationBusinessException.class)
	public void testGenerateBillShould1() throws ApplicationBusinessException, DataAccessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		Bill bill = fixture.generateBill(itemizedQty, 111l);
		when(billManagementDao.getNextAvailableBillNo()).thenThrow(new DataAccessException());
		verify(billManagementDao).getNextAvailableBillNo();
	}
	
	@Test (expected=ApplicationBusinessException.class)
	public void testGenerateBillShould2() throws ApplicationBusinessException, DataAccessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		Bill bill = fixture.generateBill(itemizedQty, 111l);
		when(billManagementDao.getNextAvailableBillNo()).thenReturn(999l);
		verify(billManagementDao).getNextAvailableBillNo();
		when(customerManagementService.getCustomerFromCustomerId(111l)).thenThrow(new ApplicationBusinessException());
		verify(customerManagementService).getCustomerFromCustomerId(111l);
	}
	
	@Test (expected=ApplicationBusinessException.class)
	public void testGenerateBillShould3() throws ApplicationBusinessException, DataAccessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		Customer customer = new Customer(CustomerTypes.EMPLOYEE);
		
		Bill bill = fixture.generateBill(itemizedQty, 111l);
		when(billManagementDao.getNextAvailableBillNo()).thenReturn(999l);
		verify(billManagementDao).getNextAvailableBillNo();
		when(customerManagementService.getCustomerFromCustomerId(111l)).thenReturn(customer);
		verify(customerManagementService).getCustomerFromCustomerId(111l);
		when(discountManagementService.computeDiscountFromBill(bill)).thenThrow(new DataAccessException());
		verify(discountManagementService).computeDiscountFromBill(bill);
	}
	
	@Test (expected=ApplicationBusinessException.class)
	public void testGenerateBillShould4() throws ApplicationBusinessException, DataAccessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		Customer customer = new Customer(CustomerTypes.EMPLOYEE);
		
		Bill bill = fixture.generateBill(itemizedQty, 111l);
		when(billManagementDao.getNextAvailableBillNo()).thenReturn(999l);
		verify(billManagementDao).getNextAvailableBillNo();
		when(customerManagementService.getCustomerFromCustomerId(111l)).thenReturn(customer);
		verify(customerManagementService).getCustomerFromCustomerId(111l);
		when(discountManagementDao.getAllDiscounts()).thenThrow(new DataAccessException());
		verify(discountManagementService).computeDiscountFromBill(bill);
		verify(discountManagementDao).getAllDiscounts();
	}
	
	@Test
	public void testGenerateBillShould5() throws ApplicationBusinessException, DataAccessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		
		List<Discount> discounts = new ArrayList<Discount>();
		Discount discount = new Discount(
								CustomerTypes.EMPLOYEE,
								ProductTypes.NON_GROCERY,
								DiscountTypes.ITEMIZED_PERCENTAGE,
								30,
								null
							 );
		
		discounts.add(discount);
		
		Customer customer = new Customer(CustomerTypes.EMPLOYEE);
		when(customerManagementService.getCustomerFromCustomerId(111l)).thenReturn(customer);
		when(billManagementDao.getNextAvailableBillNo()).thenReturn(999l);
		when(discountManagementDao.getAllDiscounts()).thenReturn(discounts);
		Bill bill = fixture.generateBill(itemizedQty, 111l);
		verify(billManagementDao).getNextAvailableBillNo();
		verify(customerManagementService).getCustomerFromCustomerId(111l);
		verify(discountManagementService).computeDiscountFromBill(bill);
		
		assertNotNull(bill);
		assertEquals(950.0, bill.getTotalUndiscountedBillAmount(), 0);
		
	}
	
	@Test (expected=ApplicationBusinessException.class)
	public void testGenerateBillShould6() throws ApplicationBusinessException, DataAccessException {
		Map<Product, Integer>  itemizedQty = new HashMap<Product, Integer>();
		Product product1 = new Product(1l, ProductTypes.NON_GROCERY, 888l, 5d);
		Product product2 = new Product(2l, ProductTypes.GROCERY, 888l, 7d);
		
		itemizedQty.put(product1, 50);
		itemizedQty.put(product2, 100);
		when(billManagementDao.getNextAvailableBillNo()).thenReturn(999l);
		when(customerManagementService.getCustomerFromCustomerId(111l)).thenReturn(null);
		Bill bill = fixture.generateBill(itemizedQty, 111l);
		verify(billManagementDao).getNextAvailableBillNo();
		verify(customerManagementService).getCustomerFromCustomerId(111l);
	}
}