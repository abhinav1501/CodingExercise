package com.mckinsey.retailsystem.billmanagement.service;

import java.util.Map;
import java.util.Set;

import com.mckinsey.retailsystem.billmanagement.dao.BillManagementDao;
import com.mckinsey.retailsystem.billmanagement.domain.Bill;
import com.mckinsey.retailsystem.billmanagement.util.BillValidator;
import com.mckinsey.retailsystem.common.dao.DaoFactoryProvider;
import com.mckinsey.retailsystem.common.dao.DaoFactoryTypes;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.common.exception.DataAccessException;
import com.mckinsey.retailsystem.common.exception.ExceptionCodes;
import com.mckinsey.retailsystem.common.exception.SystemInitializationException;
import com.mckinsey.retailsystem.common.util.ServiceProvider;
import com.mckinsey.retailsystem.common.util.Services;
import com.mckinsey.retailsystem.customermanagement.domain.Customer;
import com.mckinsey.retailsystem.customermanagement.service.CustomerManagementService;
import com.mckinsey.retailsystem.discountmanagement.service.DiscountManagementService;
import com.mckinsey.retailsystem.inventorymanagement.domain.Product;

public class BillManagementServiceImpl implements BillManagementService {
	
	private DiscountManagementService	discountManagementService;
	private CustomerManagementService	customerManagementService;
	private BillManagementDao			billManagementDao;
	
	public BillManagementServiceImpl() {
		try {
			discountManagementService = (DiscountManagementService)ServiceProvider.getService(Services.DISCOUNT_MGMT.getName());
			customerManagementService = (CustomerManagementService)ServiceProvider.getService(Services.CUSTOMER_MGMT.getName());
			billManagementDao 		  = DaoFactoryProvider.getDaoFactory(DaoFactoryTypes.FILE.getType()).getBillManagementDao();	
		} catch (SystemInitializationException  sie) {
			// log exception
			// exit
		}
	}
	
	@Override
	public Bill generateBill(
		Map<Product, Integer> itemizedQuantity,
		Long customerId
	) throws ApplicationBusinessException {
		try {
			long billId = billManagementDao.getNextAvailableBillNo();
			Customer customer = customerManagementService.getCustomerFromCustomerId(customerId);	
			Bill bill = new Bill(billId, customer, itemizedQuantity);
			getNetPayableAmount(bill);
			return bill;
		} catch (DataAccessException e) {
			throw new ApplicationBusinessException(ExceptionCodes.UNKNOWN_EXCEPTION.getType());
		}
	}

	@Override
	public Double getNetPayableAmount(Bill bill)throws ApplicationBusinessException {
		BillValidator.validateBill(bill);
		bill.setTotalUndiscountedBillAmount(computeTotalUndiscountedBillAmount(bill));
		Double discount = discountManagementService.computeDiscountFromBill(bill);
		Double totalPayableAmount = bill.getTotalUndiscountedBillAmount() - discount;
		bill.setTotalDiscountAmount(discount);
		bill.setTotalPayableAmount(totalPayableAmount);
		return totalPayableAmount;
	}
	
	private Double computeTotalUndiscountedBillAmount(Bill bill) {
		Double undiscountedBillAmount = 0d;
		Map<Product, Integer>  itemizedQuantity  = bill.getItemizedQuantity();
		if (itemizedQuantity == null || itemizedQuantity.isEmpty()) {
			return undiscountedBillAmount;
		}
		Set<Map.Entry<Product, Integer>>  itemsSet = itemizedQuantity.entrySet();
		for (Map.Entry<Product, Integer>  itemsMap : itemsSet) {
			Double price = itemsMap.getKey().getPrice();
			undiscountedBillAmount = undiscountedBillAmount + (price * itemsMap.getValue());
		}
		return undiscountedBillAmount;
	}
	
	public void setDiscountManagementService(
			DiscountManagementService discountManagementService) {
		this.discountManagementService = discountManagementService;
	}

	public void setCustomerManagementService(
			CustomerManagementService customerManagementService) {
		this.customerManagementService = customerManagementService;
	}

	public void setBillManagementDao(BillManagementDao billManagementDao) {
		this.billManagementDao = billManagementDao;
	}
	
}