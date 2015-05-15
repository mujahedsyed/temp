package com.machine.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * valid input coins 0.10, 0.20, 0.50, 1.00 This class has getEnum method,
 * similar to valueOf returns the value of a coin; not relying on default values
 * that are used to compare the coins.
 * 
 * @author mujahedsyed
 *
 */
public enum Coin {

	// creating acceptable coins in Locale format
	TenPence(new BigDecimal(0.10), Locale.UK), TwentyPence(
			new BigDecimal(0.20), Locale.UK), FiftyPence(new BigDecimal(0.50),
			Locale.UK), OnePound(new BigDecimal(1.00), Locale.UK);

	Coin(BigDecimal value, Locale locale) {
		this.value = value;
		this.value = this.value.setScale(2, RoundingMode.HALF_EVEN);
		this.locale = locale;
	}

	private BigDecimal value;
	private Locale locale;

	public BigDecimal getValue() {
		return value;
	}

	public Locale getLocale() {
		return locale;
	}

	private String getCoinInLocalFormat() {
		NumberFormat gbpCostFormat = getCurrentCostFormat();
		return gbpCostFormat.format(value.doubleValue());
	}

	// Helper method for formatting coin, Ideally the Locale will be set in
	// property file, for simplicity using UK as Locale
	private static NumberFormat getCurrentCostFormat() {
		NumberFormat gbpCostFormat = NumberFormat
				.getCurrencyInstance(Locale.UK);
		gbpCostFormat.setMinimumFractionDigits(2);
		gbpCostFormat.setMaximumFractionDigits(2);
		return gbpCostFormat;
	}

	/**
	 * Overriding the default toString method to print the coins with Locale.
	 */
	@Override
	public String toString() {
		return getCoinInLocalFormat();
	}

	// This static method is equivlent of valueOf method, it is provided to
	// check if current provided coin is a valid coin or not.
	public static Coin getEnum(String value) throws CoinNotAllowedException {
		BigDecimal big = new BigDecimal(value);
		big.setScale(2, RoundingMode.HALF_EVEN);

		for (Coin coin : values()) {
			if (coin.getValue().equals(big)) {
				return coin;
			}
		}
		throw new CoinNotAllowedException(value);
	}
}
