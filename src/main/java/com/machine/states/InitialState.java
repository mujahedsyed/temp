package com.machine.states;

import java.util.List;
import java.util.logging.Logger;

import com.machine.Machine;
import com.machine.entity.Coin;
import com.machine.entity.Product;

/**
 * The initial state of the machine is switched on and ready to serve state. In
 * this state machine displays a greeting to the user and requests him to make a
 * selection.
 * 
 * <p>
 * <ul>
 * 
 * <li>If user switches off the machine than machine goes to switched on state.</li>
 * 
 * <li>User will not be able to switch on the machine, as it is already switched
 * on. If this request is made than a InvalidUserActionException exception is
 * thrown.</li>
 * 
 * <li>In a normal use case the user is expected to select a product so the
 * machine can move from InitialState to SelectProductState</li>
 * 
 * <li>cancelSelection, dispense, ejectCoins are not possible as there is no
 * product selected currently, if invoked they will throw
 * InvalidUserActionException</li>
 * 
 * @author mujahedsyed
 *
 */
public class InitialState implements State {

	private final static Logger LOGGER = Logger.getLogger(InitialState.class
			.getName());

	private Machine machine;

	public InitialState(Machine machine) {
		this.machine = machine;
	}

	/**
	 * Turn the machine off and switched the state to off.
	 */
	@Override
	public void switchedOff() throws InvalidUserActionException {
		LOGGER.warning("Machine is going to be switched off!");
		this.machine.setState(new SwitchedOffState(machine));
	}

	// machine already switched on
	@Override
	public void switchedOn() throws InvalidUserActionException {
		throw new InvalidUserActionException("Machine is already switched on!");
	}

	/**
	 * select the product and set the state to request for the money.
	 */
	@Override
	public Product selectProduct() throws InvalidUserActionException {
		this.machine.setProduct(this.machine.getProduct());
		this.machine.setState(new InsertCoinsState(machine));
		return this.machine.getProduct();
	}

	/**
	 * to cancel a selection there has to be selection first.
	 */
	@Override
	public void cancelSelection() throws InvalidUserActionException {
		throw new InvalidUserActionException("Product is not selected!");
	}

	@Override
	public boolean enterAmountForSelectedProduct()
			throws InvalidUserActionException, InvalidCoinException {
		ejectCoins();
		throw new InvalidUserActionException(
				"Coins Returned! Select a Product first.");
	}

	@Override
	public Product dispense() throws InvalidUserActionException {
		throw new InvalidUserActionException(
				"(1) Select Product, (2) Insert amount before invoking dispense");
	}

	@Override
	public List<Coin> ejectCoins() {
		LOGGER.warning("Returning coins, select product first before inserting any coins");
		return this.machine.getCoins();
	}

}
