package com.machine.states;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.CoinNotAllowedException;
import com.machine.entity.Product;

public class InitialStateTest {

	private VendingMachine machine = null;
	private State state = null;
	private static List<Coin> coins = null;

	@Before
	public void init() {
		machine = new VendingMachine();
		state = new InitialState(machine);
		machine.setState(state);
		coins = new ArrayList<Coin>();
		coins.add(Coin.FiftyPence);
		machine.setCoins(coins);
	}

	@Test
	public void testInitialState() {
		assertNotNull(state);
		assertTrue(machine.getState() instanceof InitialState);
		assertNotNull(machine);
	}

	@Test
	public void testSwitchedOff() throws InvalidUserActionException {
		state.switchedOff();
		assertFalse(machine.getState() instanceof InitialState);
		assertTrue(machine.getState() instanceof SwitchedOffState);
	}

	@Test(expected = InvalidUserActionException.class)
	public void testSwitchedOn() throws InvalidUserActionException {
		assertTrue(machine.getState() instanceof InitialState);
		state.switchedOn();
	}

	@Test
	public void testSelectProduct() throws InvalidUserActionException {
		Product A = state.selectProduct();
		assertFalse(machine.getState() instanceof InitialState);
		assertFalse(machine.getState() instanceof SwitchedOffState);
		assertTrue(machine.getState() instanceof InsertCoinsState);
		assertEquals(machine.getProduct(), A);
	}

	@Test(expected = InvalidUserActionException.class)
	public void testCancelSelection() throws InvalidUserActionException {
		assertTrue(machine.getState() instanceof InitialState);
		state.cancelSelection();
	}

	@Test(expected = InvalidUserActionException.class)
	public void testEnterAmountForSelectedProduct()
			throws InvalidUserActionException, InvalidCoinException {
		assertTrue(machine.getState() instanceof InitialState);
		state.enterAmountForSelectedProduct();
	}

	@Test(expected = InvalidUserActionException.class)
	public void testDispense() throws InvalidUserActionException {
		assertTrue(machine.getState() instanceof InitialState);
		state.dispense();
	}

	@Test
	public void testEjectCoins() throws CoinNotAllowedException {
		assertTrue(machine.getState() instanceof InitialState);
		List<Coin> returnedCoins = state.ejectCoins();

		assertTrue(machine.getState() instanceof InitialState);
		assertNotNull(this.machine.getCoins());

		// does the list has any item?
		assertTrue(returnedCoins.size() == 1);

		// have we got our 50 pence back?
		assertEquals(returnedCoins.get(0), Coin.getEnum(("0.50")));
	}
}
