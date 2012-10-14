package com.mckinsey.retailsystem.billmanagement.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.mckinsey.retailsystem.customermanagement.domain.Customer;
import com.mckinsey.retailsystem.inventorymanagement.domain.Product;

public final class Bill {
	
	private final Long	billId;
	private final Customer   customer;
	private final Map<Product, Integer>  itemizedQuantity;
	private double totalUndiscountedBillAmount;
	private double totalDiscountAmount;
	private double totalPayableAmount;
	
	public Bill(
		Long billId,
		Customer customer,
		Map<Product, Integer> itemizedQuantity
	) {
		this.billId = billId;
		this.customer = customer;
		this.itemizedQuantity = itemizedQuantity;
	}

	public Long getBillId() {
		return this.billId;
	}

	public Customer getCustomer() {
		if (this.customer == null) {
			return null;
		}
		Customer customerClone = null;
		try {
			customerClone = (Customer)this.customer.clone();
		} catch (CloneNotSupportedException  cnse) {
			customerClone = null;
		}
		return customerClone;
	}

	public Map<Product, Integer> getItemizedQuantity() {
		if (this.itemizedQuantity == null || this.itemizedQuantity.isEmpty()) {
			return null;
		}
		Map<Product, Integer>  itemizedQuantityClone = null;
		Set<Map.Entry<Product, Integer>>  mapEntrySet = null;
		try {
			itemizedQuantityClone = new HashMap<Product, Integer>();
			mapEntrySet = itemizedQuantity.entrySet();
			for (Map.Entry<Product, Integer> mapEntry : mapEntrySet) {
				Product productClone = (Product)mapEntry.getKey().clone();
				itemizedQuantityClone.put(productClone, mapEntry.getValue());
			}
		} catch (CloneNotSupportedException  cnse) {
			itemizedQuantityClone = null;
		}
		return itemizedQuantityClone;
	}

	public double getTotalUndiscountedBillAmount() {
		return totalUndiscountedBillAmount;
	}

	public void setTotalUndiscountedBillAmount(double totalUndiscountedBillAmount) {
		this.totalUndiscountedBillAmount = totalUndiscountedBillAmount;
	}

	public double getTotalDiscountAmount() {
		return totalDiscountAmount;
	}

	public void setTotalDiscountAmount(double totalDiscountAmount) {
		this.totalDiscountAmount = totalDiscountAmount;
	}

	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
	
}
