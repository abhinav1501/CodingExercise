package com.mckinsey.retailsystem.billmanagement.util;

import com.mckinsey.retailsystem.billmanagement.domain.Bill;
import com.mckinsey.retailsystem.common.exception.ApplicationBusinessException;
import com.mckinsey.retailsystem.common.exception.ExceptionCodes;

public class BillValidator {
	
	public static void validateBill(Bill bill) throws ApplicationBusinessException {
		billNullValidate(bill);
		billCutomerValidate(bill);
		billItemsValidate(bill);
	}
	
	private static void billNullValidate(Bill bill) throws ApplicationBusinessException {
		if (bill == null) {
			throw new ApplicationBusinessException(ExceptionCodes.BILL_INCOMPLETE.getType());
		}
	}
	
	private static void billCutomerValidate(Bill bill) throws ApplicationBusinessException {
		if (bill.getCustomer() == null) {
			throw new ApplicationBusinessException(ExceptionCodes.BILL_WITHOUT_CUSTOMER.getType());
		}
	}
	
	private static void billItemsValidate(Bill bill) throws ApplicationBusinessException {
		if (bill.getItemizedQuantity() == null || bill.getItemizedQuantity().isEmpty()) {
			throw new ApplicationBusinessException(ExceptionCodes.BILL_WITHOUT_ITEMS.getType());
		}
	}

}
