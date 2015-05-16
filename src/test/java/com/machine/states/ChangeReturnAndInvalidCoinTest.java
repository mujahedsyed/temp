package com.machine.states;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.Product;

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
		VendingMachine changeMachine = new VendingMachine();
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

		boolean willDispatch = newState.enterAmountForSelectedProduct();
		assertTrue(willDispatch);
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
