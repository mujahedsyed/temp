package com.machine.util;

import java.util.Arrays;

import com.machine.entity.Coin;

public class CoinUtil {

	public static boolean isValidCoin(Coin coin) {
		return Arrays.asList(Coin.values()).contains(coin.toString());
	}
}
