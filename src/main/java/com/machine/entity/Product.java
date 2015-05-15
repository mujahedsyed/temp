package com.machine.entity;

import java.math.BigDecimal;

public enum Product {

	A(new BigDecimal("0.60"), "A"), B(new BigDecimal("1.00"), "B"), C(
			new BigDecimal("1.70"), "C"), NO_PRODUCT_SELECTED(
			new BigDecimal(0.00), "No Product Selected");

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

}
