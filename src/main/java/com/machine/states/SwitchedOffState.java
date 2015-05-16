package com.machine.states;

import java.util.List;
import java.util.logging.Logger;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.Product;

/**
 * Switched off state
 * 
 * @author mujahedsyed
 *
 */
public class SwitchedOffState implements State {

	private VendingMachine machine;
	private static final Logger LOGGER = Logger
			.getLogger(SwitchedOffState.class.getName());

	public SwitchedOffState(VendingMachine machine) {
		this.machine = machine;
	}

	@Override
	public void switchedOff() throws InvalidUserActionException {
		throw new InvalidUserActionException("Machine is OFF!");
	}

	@Override
	public void switchedOn() {
		LOGGER.warning("Machine is switching ON");
		this.machine.setState(new InitialState(machine));
	}

	@Override
	public Product selectProduct() throws InvalidUserActionException {
		throw new InvalidUserActionException("Machine is OFF!");
	}

	@Override
	public void cancelSelection() throws InvalidUserActionException {
		throw new InvalidUserActionException("Machine is OFF!");
	}

	@Override
	public boolean enterAmountForSelectedProduct()
			throws InvalidUserActionException, InvalidCoinException {
		throw new InvalidUserActionException("Machine is OFF!");
	}

	@Override
	public Product dispense() throws InvalidUserActionException {
		throw new InvalidUserActionException("Machine is OFF!");
	}

	@Override
	public List<Coin> ejectCoins() {
		LOGGER.warning("Returning coins: Machine is OFF!");
		return this.machine.getCoins();
	}
}