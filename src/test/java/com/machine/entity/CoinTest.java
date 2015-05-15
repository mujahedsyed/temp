package com.machine.entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
	 * This tests the description. T
	 */
	@Test
	public void testGetDescription() {
		assertEquals("0.10", Coin.TenPence.getDescription());
	}

	/**
	 * Get the value of the coin test.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(new BigDecimal("0.10"), Coin.TenPence.getPrice());
	}

	/**
	 * an invalid coin is treated as having no value at all.
	 */
	@Test
	public void testPutInvalidCont() {
		assertEquals(new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP),
				Coin.InvalidCoin.getPrice().setScale(2, RoundingMode.HALF_UP));
	}
}
