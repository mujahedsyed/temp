package com.machine.entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

import org.junit.Test;

import com.machine.entity.Coin;

/**
 * Coin Test
 * 
 * @author mujahedsyed
 *
 */
public class CoinTest {

	Coin coin = Coin.TenPence;

	/**
	 * is it behaving correctly?
	 */
	@Test
	public void testCoin() {
		assertNotNull(coin);
		assertTrue(coin instanceof Coin);
	}

	/**
	 * This tests the value with locale info.
	 */
	@Test
	public void testGetValue() {
		
		assertEquals(new BigDecimal("0.10"), Coin.TenPence.getValue());
	}

	/**
	 * an invalid coin is treated as having no value at all.
	 */
	@Test
	public void testPutInvalidCont() {
		BigDecimal invalidCoin = new BigDecimal("1.00").setScale(2,
				RoundingMode.HALF_UP);

		boolean result = Arrays.asList(Coin.values()).contains(
				invalidCoin.toString());

		System.out.println("invalidCoin: " + result + "; "
				+ invalidCoin.toString());
		for (Coin coin : Coin.values()) {
			System.out.println(coin.getValue());
		}
	}
}
