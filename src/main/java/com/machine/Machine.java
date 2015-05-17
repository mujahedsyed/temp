package com.machine;

import java.util.List;

import com.machine.entity.Coin;
import com.machine.entity.Product;
import com.machine.inventory.Products;
import com.machine.states.InvalidUserActionException;
import com.machine.states.State;

public interface Machine {

	/**
	 * Get the current state. Machine has a state
	 * 
	 * @return
	 */
	public abstract State getState();

	/**
	 * Pass the state and set it at machine
	 * 
	 * @param state
	 */
	public abstract void setState(State state);

	/**
	 * Machine can take or give a coin i.e. Machine HAS-A coin
	 */
	public abstract void ejectCoins();

	public abstract void dispense() throws InvalidUserActionException;

	/**
	 * Machine can take or give a product i.e. Machine HAS-A product.
	 * 
	 * @return
	 * @throws InvalidUserActionException
	 */
	public abstract Product getProduct() throws InvalidUserActionException;

	public abstract void setProduct(Product product);

	/**
	 * get all the products
	 * 
	 * @return
	 */
	public abstract Products getProducts();

	/**
	 * get currently inserted coins or current coins
	 * 
	 * @return
	 */
	public abstract List<Coin> getCoins();

	public abstract void setCoins(List<Coin> coins);

	// all possible states defined from here
	public abstract State getIdleState();

	public abstract void setIdleState(State idleState);

	public abstract State getInsertCoinsState();

	public abstract void setInsertCoinsState(State insertCoinsState);

	public abstract State getSwitchedOffState();

	public abstract void setSwitchedOffState(State switchedOffState);

}