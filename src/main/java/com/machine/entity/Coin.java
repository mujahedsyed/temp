package com.machine.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * valid input coins 0.10, 0.20, 0.50, 1.00
 * 
 * @author mujahedsyed
 *
 */
public enum Coin {

	TenPence(new BigDecimal(0.10)), TwentyPence(new BigDecimal(0.20)), FiftyPence(
			new BigDecimal(0.50)), OnePound(new BigDecimal(1.00)), ;

	Coin(BigDecimal value) {
		this.value = value;
	}

	private BigDecimal value;

	public BigDecimal getValue() {
		this.value = this.value.setScale(2, RoundingMode.HALF_EVEN);
		return value;
	}

	public String getCoinInLocalFormat() {
		NumberFormat gbpCostFormat = getCurrentCostFormat();
		return gbpCostFormat.format(value.doubleValue());
	}

	private static NumberFormat getCurrentCostFormat() {

		NumberFormat gbpCostFormat = NumberFormat
				.getCurrencyInstance(Locale.UK);
		gbpCostFormat.setMinimumFractionDigits(2);
		gbpCostFormat.setMaximumFractionDigits(2);
		return gbpCostFormat;
	}
}
