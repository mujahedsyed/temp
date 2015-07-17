package com.machine.states;

import java.util.List;
import java.util.logging.Logger;

import com.machine.Machine;
import com.machine.entity.Coin;
import com.machine.entity.Product;

/**
 * Switched off state
 * 
 * @author mujahedsyed
 *
 */
public class SwitchedOffState implements State {

	private Machine machine;
	private static final Logger LOGGER = Logger
			.getLogger(SwitchedOffState.class.getName());

	public SwitchedOffState(Machine machine) {
		this.machine = machine;
	}

	@Override
	public void switchedOff() throws InvalidUserActionException {
		throw new InvalidUserActionException("Machine is OFF!");
	}

	@Override
	public void switchedOn() {
		this.machine.setState(new InitialState(machine));
		LOGGER.warning("ON");
	}

	@Override
	public Product selectProduct() throws InvalidUserActionException {
		throw new InvalidUserActionException("Turn On");
	}

	@Override
	public void cancelSelection() throws InvalidUserActionException {
		throw new InvalidUserActionException("Turn On");
	}

	@Override
	public boolean enterAmountForSelectedProduct()
			throws InvalidUserActionException, InvalidCoinException {
		throw new InvalidUserActionException("Turn On");
	}

	@Override
	public Product dispense() throws InvalidUserActionException {
		throw new InvalidUserActionException("Turn On");
	}

	@Override
	public List<Coin> ejectCoins() {
		LOGGER.warning("Return coins");
		return this.machine.getCoins();
	}
}