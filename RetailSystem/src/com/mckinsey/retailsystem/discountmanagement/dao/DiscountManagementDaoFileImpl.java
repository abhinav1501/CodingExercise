package com.mckinsey.retailsystem.discountmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.mckinsey.retailsystem.common.exception.DataAccessException;
import com.mckinsey.retailsystem.customermanagement.domain.CustomerTypes;
import com.mckinsey.retailsystem.discountmanagement.domain.Discount;
import com.mckinsey.retailsystem.discountmanagement.domain.DiscountTypes;
import com.mckinsey.retailsystem.inventorymanagement.domain.ProductTypes;

public class DiscountManagementDaoFileImpl implements DiscountManagementDao {
	
	public List<Discount>  getAllDiscounts() throws DataAccessException {
		// load possible discount from file. As of now creating a hard coded method
		// to load all possible discounts
		// same is used in mock test cases as well.
		return getHardcodedDiscounts();
	}
	
	private List<Discount> getHardcodedDiscounts() {
		List<Discount> discounts = new ArrayList<Discount>();
		Discount discount1 = new Discount(
								CustomerTypes.EMPLOYEE,
								ProductTypes.NON_GROCERY,
								DiscountTypes.ITEMIZED_PERCENTAGE,
								30,
								null
							 );
		
		Discount discount2 = new Discount(
								CustomerTypes.AFFILIATE,
								ProductTypes.NON_GROCERY,
								DiscountTypes.ITEMIZED_PERCENTAGE, 
								10,
								null
							 );

		
		Discount discount3 = new Discount(
								CustomerTypes.LOYAL_CUSTOMER,
								ProductTypes.NON_GROCERY,
								DiscountTypes.ITEMIZED_PERCENTAGE,
								5,
								null
							 );
		
		Discount discount4 = new Discount(
								CustomerTypes.ANYONE,
								ProductTypes.ANY,
								DiscountTypes.TOTAL_ABSOULTE,
								5,
								100
							 );
		
		discounts.add(discount1);
		discounts.add(discount2);
		discounts.add(discount3);
		discounts.add(discount4);
		
		return discounts;
	}
}