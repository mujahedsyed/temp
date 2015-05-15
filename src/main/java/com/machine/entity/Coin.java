package com.machine.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * valid input coins 0.10, 0.20, 0.50, 1.00
 * 
 * @author mujahedsyed
 *
 */
public enum Coin {

	TenPence(new BigDecimal(0.10).setScale(2, RoundingMode.HALF_UP), "0.10"), TwentyPence(
			new BigDecimal(0.20).setScale(2, RoundingMode.HALF_UP), "0.20"), FiftyPence(
			new BigDecimal(0.50).setScale(2, RoundingMode.HALF_UP), "0.50"), OnePound(
			new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP), "1.00"), InvalidCoin(
			new BigDecimal(0.00), "0.00");

	Coin(BigDecimal value, String description) {
		this.description = description;
		this.price = value;
	}

	private String description;
	private BigDecimal price;

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
