package com.machine.states;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.Product;

public class InsertCoinsStateTest {

	private VendingMachine machine = null;
	private State state = null;
	private static List<Coin> coins = null;

	@Before
	public void init() {
		machine = new VendingMachine();
		state = new InsertCoinsState(machine);
		machine.setProduct(Product.A);
		machine.setState(state);
		coins = new ArrayList<Coin>();
		coins.add(Coin.FiftyPence);
		this.machine.setCoins(coins);
	}

	@Test
	public void testInsertCoinsAndDispenseProductState()
			throws InvalidUserActionException {
		assertNotNull(state);
		assertTrue(state instanceof InsertCoinsState);
		assertNotNull(machine.getProduct());
	}

	@Test
	public void testSwitchedOff() throws InvalidUserActionException {
		state.switchedOff();
		assertTrue(machine.getState() instanceof SwitchedOffState);
	}

	@Test(expected = InvalidUserActionException.class)
	public void testSwitchedOn() throws InvalidUserActionException {
		state.switchedOn();
	}

	@Test(expected = InvalidUserActionException.class)
	public void testSelectProduct() throws InvalidUserActionException {
		state.selectProduct();
	}

	/*
	 * Trying to buy product A costing 60 pence with 50 pence initially;
	 * asserting that it will fail.
	 * 
	 * Later adding the requested difference. Asserting for true that the
	 * product will now be dispatched.
	 */
	@Test
	public void testEnterAmountForSelectedProduct()
			throws InvalidUserActionException, InvalidCoinException {
		boolean willDispatch = state.enterAmountForSelectedProduct();
		assertFalse(willDispatch);
		coins.add(Coin.TenPence);
		willDispatch = state.enterAmountForSelectedProduct();
		assertTrue(willDispatch);
	}

	/**
	 * Will the product be dispatched has been tested in above method
	 * {@link com.machine.states.InsertCoinsStateTest#testEnterAmountForSelectedProduct()}
	 * 
	 * And has the inventory been updated is already covered in junit method
	 * {@link com.machine.product.ProductsTest#testRemoveProduct()
	 * testRemoveProduct}
	 * 
	 * Also has the status of the machine changed from serving to ready to
	 * serve?
	 * 
	 * @throws InvalidCoinException
	 * @throws InvalidUserActionException
	 */
	@Test
	public void testDispense() throws InvalidUserActionException,
			InvalidCoinException {
		boolean willDispatch = state.enterAmountForSelectedProduct();
		assertFalse(willDispatch);
		coins.add(Coin.TenPence);
		willDispatch = state.enterAmountForSelectedProduct();
		assertTrue(this.machine.getState() instanceof InitialState);
	}

	/**
	 * This test case is covered in a separate class
	 * {@link com.machine.states.ChangeReturnAndInvalidCoinTest#testChangeReturn()
	 * testChangeReturn}
	 */
	@Test
	public void testEjectCoins() {
		assertTrue(true);
	}

}
