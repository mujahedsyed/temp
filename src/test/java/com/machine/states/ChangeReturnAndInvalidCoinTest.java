package com.machine.states;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.machine.Machine;
import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.Product;
import com.machine.inventory.Coins;
import com.machine.util.Utility;

public class ChangeReturnAndInvalidCoinTest {

	/**
	 * putting more money to check if i will get the remaining change back
	 * 
	 * @throws InvalidCoinException
	 * @throws InvalidUserActionException
	 */
	@Test
	public void testChangeReturn() throws InvalidUserActionException,
			InvalidCoinException {
		Machine changeMachine = new VendingMachine();
		State newState = new InsertCoinsState(changeMachine);

		// selecting B with cost £1.00
		changeMachine.setProduct(Product.B);
		changeMachine.setState(newState);

		// putting £1.10
		List<Coin> newCoins = new ArrayList<Coin>();
		newCoins.add(Coin.FiftyPence);
		newCoins.add(Coin.FiftyPence);
		newCoins.add(Coin.TenPence);
		changeMachine.setCoins(newCoins);

		assertTrue(Utility.sum(changeMachine.getCoins()).equals(
				new BigDecimal("1.10")));
		boolean willDispatch = newState.enterAmountForSelectedProduct();
		assertTrue(willDispatch);

		// 10 pence change is returned back
		changeMachine.getCoins();
		assertTrue(Utility.sum(changeMachine.getCoins()).equals(
				new BigDecimal("0.10")));
	}

	/**
	 * 
	 * This test meets the SPEC: (1) Available change – # of Ten Pence, Twenty
	 * Pence, Fifty Pence, and Pounds available (2) Currently inserted money (3)
	 * The user may hit a “coin return” button to get back the money they’ve
	 * entered so far. This test case is covered above
	 * {@link com.machine.states.ChangeReturnAndInvalidCoinTest#testChangeReturn()
	 * testChangeReturn} (4) If you put more money in than the item’s price, you
	 * get change back.
	 * 
	 * @throws InvalidUserActionException
	 * @throws InvalidCoinException
	 */
	@Test
	public void hasCoinsInventoryUpdatedTest()
			throws InvalidUserActionException, InvalidCoinException {
		Machine changeMachine = new VendingMachine();
		State newState = new InsertCoinsState(changeMachine);

		// selecting C; c costs 1.70£
		changeMachine.setProduct(Product.C);
		changeMachine.setState(newState);

		// putting £3.30
		List<Coin> newCoins = new ArrayList<Coin>();
		newCoins.add(Coin.FiftyPence);
		newCoins.add(Coin.FiftyPence);
		newCoins.add(Coin.FiftyPence);
		newCoins.add(Coin.FiftyPence);
		newCoins.add(Coin.OnePound);
		newCoins.add(Coin.TenPence);
		newCoins.add(Coin.TwentyPence);
		changeMachine.setCoins(newCoins);

		// asserting before purchase available coins we have; refer static block
		// in Coins class.
		List<Coin> availableChange = Coins.getSingeltonInstance()
				.getAvailableChange();
		assertEquals(com.machine.util.Utility.sum(availableChange),
				new BigDecimal("5.50"));
		assertFalse(availableChange.isEmpty());
		assertTrue(availableChange.size() == 13);

		boolean willDispatch = newState.enterAmountForSelectedProduct();
		assertTrue(willDispatch);

		// after purchase has the coin inventory updated?
		assertFalse(availableChange.isEmpty());
		assertFalse(availableChange.size() == 13);

		// The returned changed would be 1.60£
		// so the inventory should be up from 5.50£ + 1.70£ (cost of C) to 7.20£
		assertEquals(com.machine.util.Utility.sum(availableChange),
				new BigDecimal("7.20"));
	}

	/**
	 * putting a invalid coin
	 * 
	 * This test is already performed in JUnit class
	 * CoinTest.testPutInvalidCoin, so skipping it here.
	 */
	@Test
	public void invalidCoinTest() {
		assertTrue(true);
	}
}
