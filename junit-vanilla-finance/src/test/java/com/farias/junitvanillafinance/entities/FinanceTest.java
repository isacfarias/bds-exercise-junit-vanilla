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
		var months = 12;
		var income = 5000.0;
		var totalAmount = 10000.0;

		var entry = totalAmount * entryPerc;
		var quota = (totalAmount - entry) / months;

		var quotalimite = income * 0.50;

		assertTrue(quota <= quotalimite);
	}


	@Test
	void financeConstructorShouldCalculateDownPaymentAndInstallmentsWhenSuccessful() {
		var totalAmount = 10000.0;
		var income = 5000.0;
		var months = 12;

		var entry = totalAmount * 0.20;
		var quota = (totalAmount - entry)/months;
		var quotalimite = income * 0.50;

		var finance = FinanceFactory.createFinanceConstructor(months, income, totalAmount);

		assertEquals(entry, finance.entry());
		assertEquals(quota, finance.quota());
		assertTrue(finance.quota() <= quotalimite);
	}

	@Test
	void financeShouldCalculateDownPaymentAndInstallmentsWhenSuccessful() {
		var totalAmount = 10000.0;
		var income = 5000.0;
		var months = 12;

		var entry = totalAmount * 0.20;
		var quota = (totalAmount - entry)/months;
		var quotalimite = income * 0.50;

		var finance = new Finance();
		finance.setTotalAmount(totalAmount);
		finance.setIncome(income);
		finance.setMonths(months);

		assertEquals(entry, finance.entry());
		assertEquals(quota, finance.quota());
		assertTrue(finance.quota() <= quotalimite);
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
	void financeConstructorShouldThrowsExceptionWhenQuotaIsGreaterThanHalfOfIncome() {
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
	void financeConstructorShouldThrowsExceptionWhenMonthsIsEmpty() {
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
	void financeConstructorShouldThrowsExceptionWhenIncomeIsEmpty() {
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
	void financeConstructorShouldThrowsExceptionWhenTotalAmountIsEmpty() {
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
