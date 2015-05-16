package com.machine;

import java.util.List;
import java.util.logging.Logger;

import com.machine.entity.Coin;
import com.machine.entity.Product;
import com.machine.inventory.Products;
import com.machine.states.InitialState;
import com.machine.states.InsertCoinsState;
import com.machine.states.InvalidUserActionException;
import com.machine.states.State;
import com.machine.states.SwitchedOffState;

/**
 * Vending Machine class, the class has State, May have Coins and Products.
 * 
 * @author mujahedsyed
 *
 */
public class VendingMachine {

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(VendingMachine.class
			.getName());

	// Machine has a state
	private State state;
	// Machine can take or give a coin i.e. Machine HAS-A coin
	// Machine can take or give a product i.e. Machine HAS-A product.
	// Initialized with No product selected.
	private Product product = null;
	// inventory of products
	private Products products;
	private List<Coin> coins;

	/**
	 * All possible states the machine can have.
	 */
	private State idleState;
	private State insertCoinsState;
	private State switchedOffState;

	/**
	 * Default constructor intialized with switched on and waiting to serve
	 * state.
	 */
	public VendingMachine() {
		this.idleState = new InitialState(this);
		this.insertCoinsState = new InsertCoinsState(this);
		this.switchedOffState = new SwitchedOffState(this);
		this.products = Products.getSingeltonInstance();
	}

	/**
	 * Get the current state.
	 * 
	 * @return
	 */
	public State getState() {
		return state;
	}

	/**
	 * Pass the state and set it at machine
	 * 
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}

	public void ejectCoins() {
		this.state.ejectCoins();
	}

	public void dispense() throws InvalidUserActionException {
		this.state.dispense();
	}

	public Product getProduct() throws InvalidUserActionException {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Products getProducts() {
		return this.products;
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}

	public State getIdleState() {
		return idleState;
	}

	public void setIdleState(State idleState) {
		this.idleState = idleState;
	}

	public State getInsertCoinsState() {
		return insertCoinsState;
	}

	public void setInsertCoinsState(State insertCoinsState) {
		this.insertCoinsState = insertCoinsState;
	}

	public State getSwitchedOffState() {
		return switchedOffState;
	}

	public void setSwitchedOffState(State switchedOffState) {
		this.switchedOffState = switchedOffState;
	}

	@Override
	public String toString() {
		return "VendingMachine [state=" + state + ", product=" + product
				+ ", products=" + products + ", coins=" + coins + "]";
	}
}