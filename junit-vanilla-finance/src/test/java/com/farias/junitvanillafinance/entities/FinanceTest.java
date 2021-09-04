package com.farias.junitvanillafinance.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.farias.junitvanillafinance.factory.FinanceFactory;

class FinanceTest {

	/**
	 * - O valor da entrada deve ser 20% do montante
	 * - O valor da prestacao deve ser os 80% restanta de montante, divididos pelo numero de parcelas;
	 * - O valor da pretação não pode ser maior que metade da renda do cliente.
	 */
	@Test
	void test() {

		var entryPerc = 0.20;
		var months = 80;
		var income = 2000.0;
		var totalAmount = 100000.0;

		var entry = totalAmount * entryPerc;
		var quota = (totalAmount - entry) / months;

		var quotalimite = income * 0.50;

		assertTrue(quota <= quotalimite);
	}

	
	@Test
	void entryShouldReturnTwentyPercentOfTotalAmount() {
		var totalAmount = 10000.0;
		var income = 5000.0;
		var months = 12;

		var finance = FinanceFactory.createFinanceConstructor(months, income, totalAmount);
		var expectedEntryValue = totalAmount * 0.20;

		assertEquals(expectedEntryValue, finance.entry());
	}
	
	@Test
	void quotaShouldReturnCorrectQuotaValue() {
		var totalAmount = 10000.0;
		var income = 5000.0;
		var months = 12;

		var finance = FinanceFactory.createFinanceConstructor(months, income, totalAmount);
		var entry = totalAmount * 0.20;
		var expectedQuota = (totalAmount - entry)/months;
		
		assertEquals(expectedQuota, finance.quota());
	}


	@Test
	void constructorShouldSetValuesWhenValidData() {
		var totalAmount = 10000.0;
		var income = 5000.0;
		var months = 12;

		var finance = FinanceFactory.createFinanceConstructor(months, income, totalAmount);

		assertEquals(totalAmount, finance.getTotalAmount());
		assertEquals(income, finance.getIncome());
		assertEquals(months, finance.getMonths());
	}

	@Test
	void financeShouldSetValuesWhenValidData() {
		var totalAmount = 10000.0;
		var income = 5000.0;
		var months = 12;


		var finance = new Finance();
		finance.setTotalAmount(totalAmount);
		finance.setIncome(income);
		finance.setMonths(months);

		assertEquals(totalAmount, finance.getTotalAmount());
		assertEquals(income, finance.getIncome());
		assertEquals(months, finance.getMonths());
	}


	@Test
	void financeShouldThrowsExceptionWhenQuotaIsGreaterThanHalfOfIncome() {
		var totalAmount = 50000.0;
		var income = 5000.0;
		var months = 12;


		assertThrows(IllegalArgumentException.class, () -> {
			var finance = new Finance();
			finance.setTotalAmount(totalAmount);
			finance.setIncome(income);
			finance.setMonths(months);
			finance.entry();
			finance.quota();
			});
	}
	
	@Test
	void constructorShouldThrowsExceptionWhenQuotaIsGreaterThanHalfOfIncome() {
		var totalAmount = 50000.0;
		var income = 5000.0;
		var months = 12;


		assertThrows(IllegalArgumentException.class, () -> {
			var finance = FinanceFactory.createFinanceConstructor(months, income, totalAmount);
			finance.entry();
			finance.quota();
			});
	}
	
	@Test
	void constructorShouldThrowsExceptionWhenMonthsIsEmpty() {
		var totalAmount = 50000.0;
		var income = 5000.0;
		var months = 0;


		assertThrows(IllegalArgumentException.class, () -> {
			var finance = FinanceFactory.createFinanceConstructor(months, income, totalAmount);
			finance.entry();
			finance.quota();
			});
	}
	
	
	@Test
	void financeShouldThrowsExceptionWhenMonthsIsEmpty() {
		var totalAmount = 50000.0;
		var income = 5000.0;
		var months = 0;


		assertThrows(IllegalArgumentException.class, () -> {
			var finance = new Finance();
			finance.setTotalAmount(totalAmount);
			finance.setIncome(income);
			finance.setMonths(months);
			finance.entry();
			finance.quota();
			});
	}
	
	
	@Test
	void constructorShouldThrowsExceptionWhenIncomeIsEmpty() {
		var totalAmount = 50000.0;
		var income = 0.0;
		var months = 12;


		assertThrows(IllegalArgumentException.class, () -> {
			var finance = FinanceFactory.createFinanceConstructor(months, income, totalAmount);
			finance.entry();
			finance.quota();
			});
	}
	
	
	@Test
	void financeShouldThrowsExceptionWhenIncomeIsEmpty() {
		var totalAmount = 50000.0;
		var income = 0.0;
		var months = 12;


		assertThrows(IllegalArgumentException.class, () -> {
			var finance = new Finance();
			finance.setTotalAmount(totalAmount);
			finance.setIncome(income);
			finance.setMonths(months);
			finance.entry();
			finance.quota();
			});
	}
	
	@Test
	void constructorShouldThrowsExceptionWhenTotalAmountIsEmpty() {
		var totalAmount = 0.0;
		var income = 5000.0;
		var months = 12;


		assertThrows(IllegalArgumentException.class, () -> {
			var finance = FinanceFactory.createFinanceConstructor(months, income, totalAmount);
			finance.entry();
			finance.quota();
			});
	}
	
	
	@Test
	void financeShouldThrowsExceptionWhenTotalAmountIsEmpty() {
		var totalAmount = 0.0;
		var income = 5000.0;
		var months = 12;


		assertThrows(IllegalArgumentException.class, () -> {
			var finance = new Finance();
			finance.setTotalAmount(totalAmount);
			finance.setIncome(income);
			finance.setMonths(months);
			finance.entry();
			finance.quota();
			});
	}

}
