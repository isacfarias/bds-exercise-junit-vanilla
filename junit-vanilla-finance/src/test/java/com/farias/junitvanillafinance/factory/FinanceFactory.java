package com.farias.junitvanillafinance.factory;

import com.farias.junitvanillafinance.entities.Finance;

public class FinanceFactory {
	
	
	
	public static Finance createFinanceConstructor(int months, double income, double totalAmount) {
		return new Finance(months, income, totalAmount);
	}

}
