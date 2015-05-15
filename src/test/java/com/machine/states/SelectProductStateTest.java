package com.machine.states;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.Product;

public class SelectProductStateTest {

	VendingMachine machine = new VendingMachine();
	SelectProductState state = new SelectProductState(machine);

	@Test
	public void testSelectProductState() {
		assertNotNull(state);
		assertTrue(state instanceof State);
		assertTrue(state instanceof SelectProductState);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSwitchedOff() {
		state.switchedOff();
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSwitchedOn() {
		state.switchedOn();
	}

	@Test
	public void testSelectProduct() {
		Product selectedProduct = state.selectProduct(Product.A);
		assertNotNull(selectedProduct);
	}

	@Test
	public void testEnterAmountForSelectedProduct() {
		assertFalse(state.enterAmountForSelectedProduct(new ArrayList<Coin>()));
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testDispense() {
		state.dispense();
	}

	@Test
	public void testEjectCoins() {
		BigDecimal coins = state.ejectCoins(this.machine.getCoins());
		assertNotNull(coins);
		assertTrue(coins instanceof BigDecimal);
		assertEquals(machine.getCoins(), coins);
	}

}
