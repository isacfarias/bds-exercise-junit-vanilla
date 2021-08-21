package com.farias.junitvanillafinance.entities;

public class Finance {

	private double quotaLimitePerc =  0.50;
	private double entryPerc = 0.20;
	
	private int months;
	private double income;
	private double totalAmount;

	public Finance() {}
	
	public Finance(int months, double income, double totalAmount) {
		if (totalAmount == 0 || totalAmount < 0) throw new IllegalArgumentException("Valor financiado incompativel.");
		if (months == 0 || months < 1) throw new IllegalArgumentException("Valor do mês incompativel.");
		if (income == 0 || income < 1) throw new IllegalArgumentException("Valor da renda incompativel.");
		this.months = months;
		this.income = income;
		this.totalAmount = totalAmount;
		bussines();
	}

	public double entry() {
		return totalAmount * entryPerc;
	}
	
	public double quota() {
		return bussines();
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		if (months == 0 || months < 1) throw new IllegalArgumentException("Valor do mês incompativel.");
		this.months = months;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		if (income == 0 || income < 1) throw new IllegalArgumentException("Valor da renda incompativel.");
		this.income = income;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		if (totalAmount == 0 || totalAmount < 0) throw new IllegalArgumentException("Valor financiado incompativel.");
		this.totalAmount = totalAmount;
	}
	
	private double bussines() {
		final var quota = (totalAmount - entry()) / months; 
		final var quotalimite = income * quotaLimitePerc;
		if (quota > quotalimite) throw new IllegalArgumentException("Valor da parcela excede 50% da renda.");
		return quota;
	}

}
