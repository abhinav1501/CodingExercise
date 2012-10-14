package com.mckinsey.retailsystem.discountmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mckinsey.retailsystem.billmanagement.domain.Bill;
import com.mckinsey.retailsystem.common.dao.DaoFactoryProvider;
import com.mckinsey.retailsystem.common.dao.DaoFactoryTypes;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.common.exception.DataAccessException;
import com.mckinsey.retailsystem.common.exception.ExceptionCodes;
import com.mckinsey.retailsystem.common.exception.SystemInitializationException;
import com.mckinsey.retailsystem.customermanagement.domain.CustomerTypes;
import com.mckinsey.retailsystem.discountmanagement.dao.DiscountManagementDao;
import com.mckinsey.retailsystem.discountmanagement.domain.Discount;
import com.mckinsey.retailsystem.discountmanagement.domain.DiscountTypes;
import com.mckinsey.retailsystem.discountmanagement.util.DiscountStrategy;
import com.mckinsey.retailsystem.discountmanagement.util.DiscountStrategyProvider;
import com.mckinsey.retailsystem.inventorymanagement.domain.Product;
import com.mckinsey.retailsystem.inventorymanagement.domain.ProductTypes;

public class DiscountManagementServiceImpl implements DiscountManagementService {
	
	private DiscountManagementDao	discountManagementDao;

	public DiscountManagementServiceImpl() {
		try {
			discountManagementDao 	= DaoFactoryProvider.getDaoFactory(DaoFactoryTypes.FILE.getType()).getDiscountManagementDao();	
		} catch (SystemInitializationException  sie) {
			// log exception
			// exit
		}
	}

	@Override
	public Double computeDiscountFromBill(Bill bill) throws ApplicationBusinessException {
		List<Discount>  discounts = null;
		try {
			discounts = discountManagementDao.getAllDiscounts();
		} catch (DataAccessException e) {
			throw new ApplicationBusinessException(ExceptionCodes.UNKNOWN_EXCEPTION.getType());
		}
		if (discounts == null || discounts.isEmpty()) {
			return null;
		}
		DiscountStrategy  discountStrategy  = DiscountStrategyProvider.getDiscountStrategy(null); 
		return discountStrategy.getFinalDiscount(getApplicableDiscountValues(bill, discounts));
	}
	
	private List<Double> getApplicableDiscountValues(Bill bill, List<Discount>  discounts) {
		List<Double> applicableDiscounts = new ArrayList<Double>();
		for (Discount discount : discounts) {
			if (isItemizedDiscount(discount.getDiscountType().getType())) {
				applicableDiscounts.add(computeItemizedDiscount(bill, discount));	
			} else if (isTotalDiscount(discount.getDiscountType().getType())) {
				applicableDiscounts.add(computeTotalDiscount(bill, discount));	
			}
		}
		return applicableDiscounts;
	}
	
	private boolean isItemizedDiscount(String discountType) {
		if (DiscountTypes.ITEMIZED_ABSOLUTE.getType().equals(discountType) || DiscountTypes.ITEMIZED_PERCENTAGE.getType().equals(discountType)) {
			return true;
		}
		return false;
	}
	
	private boolean isTotalDiscount(String discountType) {
		if (DiscountTypes.TOTAL_ABSOULTE.getType().equals(discountType) || DiscountTypes.TOTAL_PERCENTAGE.getType().equals(discountType)) {
			return true;
		}
		return false;
	}
	
	private Double computeTotalDiscount(Bill bill, Discount discount) {
		Double applicableDiscount = 0d;
		
		if (DiscountTypes.TOTAL_ABSOULTE.getType().equals(discount.getDiscountType().getType())) {
			applicableDiscount = getTotalAbsoluteDiscount(
									bill.getTotalUndiscountedBillAmount(), 
									discount.getDiscountValue(), 
									discount.getAbsoluteDiscountChunkSize()
								);
		} else if (DiscountTypes.TOTAL_PERCENTAGE.getType().equals(discount.getDiscountType().getType())) {
			applicableDiscount = getTotalPercentageDiscount(
									bill.getTotalUndiscountedBillAmount(), 
									discount.getDiscountValue()
								);
		}
		
		return applicableDiscount;
	}
	
	private Double computeItemizedDiscount(Bill bill, Discount discount) {
		Double applicableDiscount = 0d;
		String billCustomerType  = bill.getCustomer().getCustomerType().getType();
		String discountCustomerType = discount.getDiscountCustomerType().getType();
		if (billCustomerType.equals(discountCustomerType) || CustomerTypes.ANYONE.getType().equals(discountCustomerType)) {
			Map<Product, Integer> itemizedMap = bill.getItemizedQuantity();
			if (itemizedMap == null || itemizedMap.isEmpty()) {
				return 0d;
			}
			Set<Map.Entry<Product, Integer>>  mapRecordSet =  itemizedMap.entrySet();
			for (Map.Entry<Product, Integer>  mapEntry : mapRecordSet) {
				applicableDiscount = applicableDiscount + getDiscountBillProduct(mapEntry, discount);
			}
		}
		return applicableDiscount;
	}
	
	private Double getDiscountBillProduct(Map.Entry<Product, Integer>  mapEntry, Discount discount) {
		Double applicableDiscountByBillProduct = 0d;
		Product product = mapEntry.getKey();
		String billProductType = product.getProductType().getType();
		String discountProductType = discount.getDiscountProductType().getType();
		if (billProductType.equals(discountProductType) || ProductTypes.ANY.getType().equals(discountProductType)) {
			Double productPrice = product.getPrice();
			Integer quantity = mapEntry.getValue();
			if (DiscountTypes.ITEMIZED_ABSOLUTE.getType().equals(discount.getDiscountType().getType())) {
				applicableDiscountByBillProduct = getItemizedAbsoluteDiscount(
															productPrice, 
															quantity, 
															discount.getDiscountValue(), 
															discount.getAbsoluteDiscountChunkSize()
												  );
			} else if (DiscountTypes.ITEMIZED_PERCENTAGE.getType().equals(discount.getDiscountType().getType())) {
				applicableDiscountByBillProduct = getItemizedPercentageDiscount(
															productPrice, 
															quantity, 
															discount.getDiscountValue()
												  );
			}
		}
		return applicableDiscountByBillProduct;
	}
	
	private Double getItemizedAbsoluteDiscount(
		Double productPrice, 
		Integer quantity, 
		Integer discountValue,
		Integer  chunkSize
	) {
		return Math.floor(productPrice * quantity / chunkSize)*discountValue;
	}
	
	private Double getItemizedPercentageDiscount(
		Double productPrice, 
		Integer quantity, 
		Integer discountPercentage
	) {
		return productPrice * quantity * discountPercentage / 100;
	}
	
	private Double getTotalAbsoluteDiscount(
		Double billAmount, 
		Integer discountValue, 
		Integer  chunkSize
	) {
		return Math.floor(billAmount / chunkSize)*discountValue;
	}
	
	private Double getTotalPercentageDiscount(
		Double billAmount, 
		Integer discountPercentage
	) {	
		return billAmount * discountPercentage / 100;
	}
	
	public void setDiscountManagementDao(DiscountManagementDao discountManagementDao) {
		this.discountManagementDao = discountManagementDao;
	}
	
}