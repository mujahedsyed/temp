package com.machine.states;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.Product;

/**
 * This class tests the insert coin and dispense product state for the machine.
 * 
 * Note: machine will remember the choosen product if it is in the middle of
 * taking coins.
 * 
 * @author mujahedsyed
 *
 */
public class InsertCoinsAndDispenseProductStateTests {

	VendingMachine machine = new VendingMachine();

	@Test
	public void testInsertCoinsAndDispenseProductState() {
		State state = new InsertCoinsAndDispenseProductState(machine);

		assertNotNull(state);
		assertTrue(state instanceof State);
		assertTrue(state instanceof InsertCoinsAndDispenseProductState);
	}

	@Test
	public void testSwitchedOff() {
		State state = new InsertCoinsAndDispenseProductState(machine);
		assertFalse(state.switchedOff());
	}

	@Test
	public void testSwitchedOn() {
		State state = new InsertCoinsAndDispenseProductState(machine);
		assertTrue(state.switchedOn());
	}

	@Test
	public void testSelectProduct() {
		// This functionality has been tested already in SelectProductStateTest
		// - skipping
	}

	@Test
	public void testEnterAmountForSelectedProduct() {
		State state = new InsertCoinsAndDispenseProductState(machine);
		machine.setProduct(Product.A);
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(Coin.TenPence);
		coins.add(Coin.FiftyPence);

		// put correct amount and see the result
		boolean result = state.enterAmountForSelectedProduct(coins);
		assertEquals(true, result);

		// put less amount and see what happens test; i.e. removing 10 pence and
		// trying to buy 60 pence product
		coins.remove(0);
		result = state.enterAmountForSelectedProduct(coins);
		assertEquals(false, result);

		// put more amount and see what happens test; i.e. putting another 50
		// pence making a total of 1 pound and
		// trying to buy 60 pence product
		coins.add(Coin.FiftyPence);
		result = state.enterAmountForSelectedProduct(coins);
		assertEquals(true, result);

	}

	@Test
	public void testDispense() {
		// This functionality has been tested already in
		// testEnterAmountForSelectedProduct
		// - skipping
	}

	@Test
	public void testEjectCoins() {
		// This functionality has been tested already in SelectProductStateTest
		// - skipping
	}

}
