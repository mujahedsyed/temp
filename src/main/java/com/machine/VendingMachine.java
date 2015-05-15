package com.machine;

import java.math.BigDecimal;

import com.machine.entity.Coin;
import com.machine.entity.Product;
import com.machine.products.Products;
import com.machine.states.IdleAndSwitchedOnState;
import com.machine.states.InsertCoinsAndDispenseProductState;
import com.machine.states.SelectProductState;
import com.machine.states.State;

/**
 * Vending Machine class, the class has State, May have Coins and Products.
 * 
 * @author mujahedsyed
 *
 */
public class VendingMachine {

	// Machine has a state
	private State state;
	// Machine can take or give a coin i.e. Machine HAS-A coin
	private BigDecimal coins = new BigDecimal(0.00);
	// Machine can take or give a product i.e. Machine HAS-A product.
	// Initialized with No product selected.
	private Product product = Product.NO_PRODUCT_SELECTED;
	private Products products;

	/**
	 * All possible states the machine can have.
	 */
	private State idleAndSwitchedOnState;
	private State selectProductState;
	private State insertCoinsAndDispenseProductState;

	/**
	 * Default constructor intialized with switched on and waiting to serve
	 * state.
	 */
	public VendingMachine() {
		this.idleAndSwitchedOnState = new IdleAndSwitchedOnState(this);
		this.selectProductState = new SelectProductState(this);
		this.insertCoinsAndDispenseProductState = new InsertCoinsAndDispenseProductState(
				this);

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

	/**
	 * Take the selection product and ask the user to enter enough coins
	 * 
	 * @param coin
	 * @param product
	 */
	public void getInput(BigDecimal coin, Product product) {
		this.coins = coins.add(coin);
		this.product = product;
	}

	/**
	 * how many coins were inserted in total
	 * 
	 * @return
	 */
	public BigDecimal getInsertedMoneyValue() {
		return getCoins();
	}

	public BigDecimal getCoins() {
		return coins;
	}

	public void putCoins(BigDecimal coins) {
		if (isValidCoin(coins)) {
			this.coins = this.coins.add(coins);
		} else
			ejectCoins();
	}

	private boolean isValidCoin(BigDecimal coins) {
		// TODO: Determine if the coin is valid
		return true;
	}

	public void ejectCoins() {
		state.ejectCoins(this.coins);
	}

	public void dispense() {
		state.dispense();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Products getProducts() {
		return products;
	}
}
