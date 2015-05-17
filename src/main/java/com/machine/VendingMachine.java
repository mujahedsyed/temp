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
public class VendingMachine implements Machine {

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

	/* (non-Javadoc)
	 * @see com.machine.Machine#getState()
	 */
	@Override
	public State getState() {
		return state;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#setState(com.machine.states.State)
	 */
	@Override
	public void setState(State state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#ejectCoins()
	 */
	@Override
	public void ejectCoins() {
		this.state.ejectCoins();
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#dispense()
	 */
	@Override
	public void dispense() throws InvalidUserActionException {
		this.state.dispense();
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#getProduct()
	 */
	@Override
	public Product getProduct() throws InvalidUserActionException {
		return product;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#setProduct(com.machine.entity.Product)
	 */
	@Override
	public void setProduct(Product product) {
		this.product = product;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#getProducts()
	 */
	@Override
	public Products getProducts() {
		return this.products;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#getCoins()
	 */
	@Override
	public List<Coin> getCoins() {
		return coins;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#setCoins(java.util.List)
	 */
	@Override
	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#getIdleState()
	 */
	@Override
	public State getIdleState() {
		return idleState;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#setIdleState(com.machine.states.State)
	 */
	@Override
	public void setIdleState(State idleState) {
		this.idleState = idleState;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#getInsertCoinsState()
	 */
	@Override
	public State getInsertCoinsState() {
		return insertCoinsState;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#setInsertCoinsState(com.machine.states.State)
	 */
	@Override
	public void setInsertCoinsState(State insertCoinsState) {
		this.insertCoinsState = insertCoinsState;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#getSwitchedOffState()
	 */
	@Override
	public State getSwitchedOffState() {
		return switchedOffState;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#setSwitchedOffState(com.machine.states.State)
	 */
	@Override
	public void setSwitchedOffState(State switchedOffState) {
		this.switchedOffState = switchedOffState;
	}

	/* (non-Javadoc)
	 * @see com.machine.Machine#toString()
	 */
	@Override
	public String toString() {
		return "VendingMachine [state=" + state + ", product=" + product
				+ ", products=" + products + ", coins=" + coins + "]";
	}
}