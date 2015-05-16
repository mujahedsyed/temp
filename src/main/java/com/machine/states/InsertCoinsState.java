package com.machine.states;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.CoinNotAllowedException;
import com.machine.entity.Product;
import com.machine.inventory.Products;
import com.machine.util.Utility;

/**
 * The machine moves from initial state to insert coin state when a user selects
 * a product.
 * 
 * <p>
 * Possible machine actions associated in this state are:
 * 
 * <ul>
 * 
 * <li>Switching off the machine turns it off. State of the machine is changed
 * from InsertCoinState to SwitchOffState</li>
 * 
 * <li>User will not be able to switch on the machine, as it is already switched
 * on. If this request is made than a InvalidUserActionException exception is
 * thrown.</li>
 * 
 * <li>Selecting a product is also not possible unless user cancels the
 * previously selected product.</li>
 * 
 * <li>enterAmountForSelectedProduct method takes the coins inserted and based
 * on the amount inserted it moves the machine in respective states i.e. if less
 * money is inserted machine requests for more money.</li>
 * 
 * @author mujahedsyed
 *
 */
public class InsertCoinsState implements State {

	private static final Logger LOGGER = Logger
			.getLogger(InsertCoinsState.class.getName());

	private VendingMachine machine;

	public InsertCoinsState(VendingMachine machine) {
		this.machine = machine;
	}

	@Override
	public void switchedOff() throws InvalidUserActionException {
		LOGGER.warning("Machine is going to be switched off!");
		this.machine.setState(new SwitchedOffState(machine));
	}

	@Override
	public void switchedOn() throws InvalidUserActionException {
		throw new InvalidUserActionException("Machine is already switched on!");
	}

	@Override
	public Product selectProduct() throws InvalidUserActionException {
		throw new InvalidUserActionException(this.machine.getProduct()
				.getDescription() + " selected already");
	}

	@Override
	public void cancelSelection() throws InvalidUserActionException {
		this.machine.setProduct(null);
		this.machine.setState(new InitialState(machine));
	}

	@Override
	public boolean enterAmountForSelectedProduct()
			throws InvalidUserActionException, InvalidCoinException {
		Product selectedProduct = this.machine.getProduct();
		List<Coin> enteredCoins = this.machine.getCoins();
		BigDecimal sumOfCoins = Utility.sum(enteredCoins);

		boolean willDispatch = false;

		LOGGER.warning("Please enter " + selectedProduct.getPrice()
				+ " to purchase your selection "
				+ selectedProduct.getDescription());

		if (enteredCoins == null) {
			enteredCoins = new ArrayList<Coin>();
		}

		if (sumOfCoins.compareTo(selectedProduct.getPrice()) == -1) {
			LOGGER.warning("WARN more coins needed to dispense the product; please put remaning "
					+ ((sumOfCoins.subtract(selectedProduct.getPrice()))
							.toString().substring(1)) + " amount");
			this.machine.setState(new InitialState(machine));
		} else if (sumOfCoins.compareTo(selectedProduct.getPrice()) == 0) {
			willDispatch = true;
			dispense();
		} else {
			willDispatch = true;
			consumeChange(sumOfCoins);
			dispense();
			ejectCoins();
		}
		this.machine.setState(new InitialState(machine));
		return willDispatch;
	}

	private void consumeChange(BigDecimal sumOfCoins)
			throws InvalidUserActionException {
		BigDecimal currentChangeToReturn = sumOfCoins.subtract(this.machine
				.getProduct().getPrice());
		Coin returnCoins = null;
		try {
			returnCoins = Coin.getEnum(currentChangeToReturn.toString());
		} catch (CoinNotAllowedException e) {
			e.printStackTrace();
		}

		List<Coin> changeToReturn = new ArrayList<Coin>();
		changeToReturn.add(returnCoins);
		this.machine.setCoins(changeToReturn);
	}

	@Override
	public Product dispense() throws InvalidUserActionException {
		LOGGER.warning("Here is your selection " + this.machine.getProduct());
		LOGGER.warning("Thank you for your custom");
		// update the inventory
		Products.getSingeltonInstance()
				.removeProduct(this.machine.getProduct());
		this.machine.setProduct(null);
		return null;
	}

	@Override
	public List<Coin> ejectCoins() {
		LOGGER.warning("Returning coins: " + this.machine.getCoins());
		return this.machine.getCoins();
	}

}
