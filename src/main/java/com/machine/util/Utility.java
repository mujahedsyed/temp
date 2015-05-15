package com.machine.util;

import java.math.BigDecimal;
import java.util.List;

import com.machine.entity.Coin;

public class Utility {
	public static BigDecimal sum(List<Coin> coins) {
		BigDecimal sum = new BigDecimal(0.00);
		for (Coin c : coins) {
			sum = sum.add(c.getPrice());
		}
		return sum;
	}
}
