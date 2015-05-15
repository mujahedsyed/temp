package com.machine.entity;


import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.junit.Test;

import com.machine.entity.Coin;

/**
 * Coin Test
 * 
 * @author mujahedsyed
 *
 */
public class CoinTest {

	private final static Logger LOGGER = Logger.getLogger(CoinTest.class
			.getName());
	
	Coin coin = Coin.TenPence;

	/**
	 * is it behaving correctly?
	 */
	@Test
	public void testCoin() {
		assertNotNull(coin);
		assertTrue(coin instanceof Coin);
		LOGGER.info("CoinTest passed :: testCoin()");
	}

	/**
	 * This tests the value with locale info.
	 */
	@Test
	public void testGetValue() {
		assertEquals(new BigDecimal("0.10"), Coin.TenPence.getValue());
		LOGGER.info("CoinTest passed :: testGetValue()");
	}

	/**
	 * an invalid coin is treated as having no value at all. From the vending
	 * machine it will be ejected.
	 * 
	 * @throws CoinNotAllowedException
	 */
	@Test(expected = CoinNotAllowedException.class)
	public void testPutInvalidCoin() throws CoinNotAllowedException {
		Coin.getEnum("2.00");
	}

	/**
	 * a valid coin test.
	 * 
	 * @throws CoinNotAllowedException
	 */
	@Test
	public void testPutValidCoin() throws CoinNotAllowedException {
		Coin.getEnum("0.10");
		LOGGER.info("CoinTest passed :: testPutValidCoin()");
	}
}