package com.machine.states;

import java.util.List;

import com.machine.entity.Coin;
import com.machine.entity.Product;

public interface State {

	void switchedOff() throws InvalidUserActionException;

	void switchedOn() throws InvalidUserActionException;

	Product selectProduct() throws InvalidUserActionException;

	void cancelSelection() throws InvalidUserActionException;

	boolean enterAmountForSelectedProduct()
			throws InvalidUserActionException, InvalidCoinException;

	Product dispense() throws InvalidUserActionException;

	List<Coin> ejectCoins();
}
