package com.springboot.taxservice.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class TaxService is a transfer object used to shape data to be returned from service.
 * @author Matej
 * 
 */
public class TaxService {
	
	private BigDecimal possibleReturnAmount;
	private BigDecimal possibleReturnAmountBefTax;
	private BigDecimal possibleReturnAmountAfterTax;
	private BigDecimal taxRate;
	private BigDecimal taxAmount;

	public TaxService(BigDecimal possibleReturnAmount, BigDecimal possibleReturnAmountBefTax, BigDecimal possibleReturnAmountAfterTax, BigDecimal taxRate, BigDecimal taxAmount) {
		this.possibleReturnAmount = possibleReturnAmount;
		this.possibleReturnAmountBefTax = possibleReturnAmountBefTax;
		this.possibleReturnAmountAfterTax = possibleReturnAmountAfterTax;
		this.taxRate = taxRate;
		this.taxAmount = taxAmount;
	}
	
	public TaxService() {}
	
	/**
	 * Rounds every not null value in TaxService object to two decimal places.
	 */
	public void roundDataToTwoDecimalPlaces() {
		if(this.possibleReturnAmount != null) {
			this.possibleReturnAmount = this.possibleReturnAmount.setScale(2, RoundingMode.HALF_EVEN);
		}
		if(this.possibleReturnAmountBefTax != null) {
			this.possibleReturnAmountBefTax = this.possibleReturnAmountBefTax.setScale(2, RoundingMode.HALF_EVEN);
		}
		if(this.possibleReturnAmountAfterTax != null) {
			this.possibleReturnAmountAfterTax = this.possibleReturnAmountAfterTax.setScale(2, RoundingMode.HALF_EVEN);
		}
		if(this.taxRate != null) {
			this.taxRate = this.taxRate.setScale(2, RoundingMode.HALF_EVEN);
		}
		if(this.taxAmount != null) {
			this.taxAmount = this.taxAmount.setScale(2, RoundingMode.HALF_EVEN);
		}

	}

	public BigDecimal getPossibleReturnAmount() {
		return possibleReturnAmount;
	}

	public BigDecimal getPossibleReturnAmountBefTax() {
		return possibleReturnAmountBefTax;
	}

	public BigDecimal getPossibleReturnAmountAfterTax() {
		return possibleReturnAmountAfterTax;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setPossibleReturnAmount(BigDecimal possibleReturnAmount) {
		this.possibleReturnAmount = possibleReturnAmount;
	}

	public void setPossibleReturnAmountBefTax(BigDecimal possibleReturnAmountBefTax) {
		this.possibleReturnAmountBefTax = possibleReturnAmountBefTax;
	}

	public void setPossibleReturnAmountAfterTax(BigDecimal possibleReturnAmountAfterTax) {
		this.possibleReturnAmountAfterTax = possibleReturnAmountAfterTax;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

}
