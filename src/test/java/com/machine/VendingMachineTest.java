package com.machine;

import static org.junit.Assert.*;

import org.junit.Test;

import com.machine.states.InsertCoinsState;

/**
 * Testing vending machine; complete vending machine test states are broken into
 * respective state classes.
 * 
 * @author mujahedsyed
 *
 */
public class VendingMachineTest {

	private VendingMachine machine = new VendingMachine();

	@Test
	public void testVendingMachine() {
		assertNotNull(machine);
	}

	@Test
	public void testGetState() {
		machine.setState(new InsertCoinsState(machine));
		assertTrue(machine.getState() instanceof InsertCoinsState);
	}
}
