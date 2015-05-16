package com.machine.entity;

import java.math.BigDecimal;

/**
 * List of available products
 * 
 * @author mujahedsyed
 *
 */
public enum Product {

	A(new BigDecimal("0.60"), "A"), B(new BigDecimal("1.00"), "B"), C(
			new BigDecimal("1.70"), "C");

	Product(BigDecimal price, String description) {
		this.price = price;
		this.description = description;
	}

	private BigDecimal price;
	private String description;

	public BigDecimal getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return getDescription();
	}
}