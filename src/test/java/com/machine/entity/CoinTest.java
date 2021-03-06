package com.machine.entity;


import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.machine.entity.Coin;
import com.machine.states.InvalidCoinException;

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
	 * an invalid coin is treated as having no value at all. From the vending
	 * machine it will be ejected.
	 * 
	 * @throws InvalidCoinException
	 */
	@Test(expected = InvalidCoinException.class)
	public void testPutInvalidCoin() throws InvalidCoinException {
		Coin.getEnum("2.00");
	}

	/**
	 * a valid coin test.
	 * 
	 * @throws InvalidCoinException
	 */
	@Test
	public void testPutValidCoin() throws InvalidCoinException {
		Coin.getEnum("0.10");
	}
}