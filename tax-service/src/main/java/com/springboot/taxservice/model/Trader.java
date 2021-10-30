package com.springboot.taxservice.model;

import java.math.BigDecimal;

/**
 * Class Trader is a transfer object to pass data around the application.
 * @author Matej
 * 
 */
public class Trader {
	private BigDecimal tax_rate;
	private BigDecimal tax_amount;
	int tax_type_id;
	
	public Trader(BigDecimal tax_rate, BigDecimal tax_amount, int tax_type_id) {
		this.tax_rate = tax_rate;
		this.tax_amount = tax_amount;
		this.tax_type_id = tax_type_id;
	}

	public BigDecimal getTaxRate() {
		return tax_rate;
	}

	public void setTaxRate(BigDecimal tax_rate) {
		this.tax_rate = tax_rate;
	}

	public BigDecimal getTaxAmount() {
		return tax_amount;
	}

	public void setTaxAmount(BigDecimal tax_amount) {
		this.tax_amount = tax_amount;
	}

	public int getTaxTypeId() {
		return tax_type_id;
	}

	public void setTaxType(int tax_type_id) {
		this.tax_type_id = tax_type_id;
	}
	
}
