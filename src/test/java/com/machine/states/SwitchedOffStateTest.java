package com.machine.states;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.machine.Machine;
import com.machine.VendingMachine;
import com.machine.entity.Coin;

public class SwitchedOffStateTest {

	private Machine machine = null;
	private State state = null;
	private static List<Coin> coins = null;

	@Before
	public void init() {
		machine = new VendingMachine();
		state = new SwitchedOffState(machine);
		machine.setState(state);
		coins = new ArrayList<Coin>();
		coins.add(Coin.FiftyPence);
		machine.setCoins(coins);
	}

	@Test
	public void testSwitchedOffState() {
		assertNotNull(state);
		assertTrue(machine.getState() instanceof SwitchedOffState);
		assertNotNull(machine);
	}

	@Test(expected = InvalidUserActionException.class)
	public void testSwitchedOff() throws InvalidUserActionException {
		state.switchedOff();
	}

	@Test
	public void testSwitchedOn() throws InvalidUserActionException {
		state.switchedOn();

		assertTrue(machine.getState() instanceof InitialState);
		assertFalse(machine.getState() instanceof SwitchedOffState);
	}

	@Test(expected = InvalidUserActionException.class)
	public void testSelectProduct() throws InvalidUserActionException {
		assertTrue(machine.getState() instanceof SwitchedOffState);
		state.selectProduct();
	}

	@Test(expected = InvalidUserActionException.class)
	public void testCancelSelection() throws InvalidUserActionException {
		assertTrue(machine.getState() instanceof SwitchedOffState);
		state.cancelSelection();
	}

	@Test(expected = InvalidUserActionException.class)
	public void testEnterAmountForSelectedProduct()
			throws InvalidUserActionException, InvalidCoinException {
		assertTrue(machine.getState() instanceof SwitchedOffState);
		state.enterAmountForSelectedProduct();
	}

	@Test(expected = InvalidUserActionException.class)
	public void testDispense() throws InvalidUserActionException {
		assertTrue(machine.getState() instanceof SwitchedOffState);
		state.dispense();
	}

	@Test
	public void testEjectCoins() throws InvalidCoinException {
		assertTrue(machine.getState() instanceof SwitchedOffState);
		List<Coin> returnedCoins = state.ejectCoins();

		assertTrue(machine.getState() instanceof SwitchedOffState);
		assertNotNull(returnedCoins);

		// does the list has any item?
		assertTrue(returnedCoins.size() == 1);

		// have we got our 50 pence back?
		assertEquals(returnedCoins.get(0), Coin.getEnum(("0.50")));

	}

}
