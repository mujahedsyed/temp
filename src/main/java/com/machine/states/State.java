package com.machine.states;

import java.util.List;

import com.machine.entity.Coin;
import com.machine.entity.Product;

/**
 * State interface is the main interface for the Vending Machine, this interface
 * has all possible methods associated with actions. This is demonstrating the
 * State pattern or the behavioural design pattern.
 * 
 * @author mujahedsyed
 *
 */
public interface State {

	/**
	 * Lets you switch the machine OFF
	 * 
	 * @throws InvalidUserActionException
	 */
	void switchedOff() throws InvalidUserActionException;

	void switchedOn() throws InvalidUserActionException;

	/**
	 * Select the product
	 * 
	 * @return selection
	 * @throws InvalidUserActionException
	 */
	Product selectProduct() throws InvalidUserActionException;

	void cancelSelection() throws InvalidUserActionException;

	/**
	 * Request the user to enter the amount to dispatch the product.
	 * 
	 * update the inventory to decrease the count of the selected product after
	 * dispatching the product.
	 * 
	 * @return willDispatch
	 * @throws InvalidUserActionException
	 * @throws InvalidCoinException
	 */
	boolean enterAmountForSelectedProduct() throws InvalidUserActionException,
			InvalidCoinException;

	Product dispense() throws InvalidUserActionException;

	/**
	 * If the user has changed his mind after selecting the product or if he
	 * mistakenly puts coins before making a selection than in this case just
	 * returned the coins back to the user.
	 * 
	 * @return refund or change
	 */
	List<Coin> ejectCoins();
}
