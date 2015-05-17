package com.machine.util;

import java.math.BigDecimal;
import java.util.List;

import com.machine.entity.Coin;

public class Utility {

	private Utility() {
	}

	/**
	 * Simple utility method to get the sum of coins.
	 * 
	 * @param coins
	 * @return total
	 */
	public static BigDecimal sum(List<Coin> coins) {
		BigDecimal sum = BigDecimal.valueOf(0.00);
		for (Coin c : coins) {
			sum = sum.add(c.getValue());
		}
		return sum;
	}
}
