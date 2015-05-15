package com.machine.entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.machine.entity.Coin;

public class CoinTest {

	Coin coin = Coin.TenPence;

	@Test
	public void testCoin() {
		assertNotNull(coin);
		assertTrue(coin instanceof Coin);
	}

	@Test
	public void testGetDescription() {
		assertEquals("0.10", Coin.TenPence.getDescription());
	}

	@Test
	public void testGetPrice() {
		assertEquals(new BigDecimal("0.10"), Coin.TenPence.getPrice());
	}

	@Test
	public void testPutInvalidCont() {
		assertEquals(new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP),
				Coin.InvalidCoin.getPrice().setScale(2, RoundingMode.HALF_UP));
	}
}
