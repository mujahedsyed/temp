package com.machine.states;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.Product;
import com.machine.util.Utility;

/**
 * throwing runtime exception on invalid methods for this state as they are
 * uncheckedexception TODO Create custom exceptions to handle situation
 * appropriately (if required)
 * 
 * @author mujahedsyed
 *
 */
public class SelectProductState implements State {

	private final static Logger LOGGER = Logger
			.getLogger(SelectProductState.class.getName());

	private VendingMachine machine;

	public SelectProductState(VendingMachine machine) {
		this.machine = machine;
	}

	@Override
	public boolean switchedOff() {
		throw new RuntimeException("WARN: Machine is selecting product");
	}

	@Override
	public boolean switchedOn() {
		throw new RuntimeException("WARN: Machine is already switched on");
	}

	@Override
	public Product selectProduct(Product product) {
		LOGGER.info("Selected product is " + product.getDescription());
		this.machine.setProduct(product);
		this.machine.setState(new InsertCoinsAndDispenseProductState(machine));
		return product;
	}

	@Override
	public boolean enterAmountForSelectedProduct(List<Coin> coins) {
		LOGGER.warning("Choose your selection first .. returning your money");
		ejectCoins(Utility.sum(coins));
		return false;
	}

	@Override
	public Product dispense() {
		throw new RuntimeException("WARN: Product not selected yet");
	}

	@Override
	public BigDecimal ejectCoins(BigDecimal amount) {
		this.machine.setState(new IdleAndSwitchedOnState(machine));
		return machine.getCoins();
	}
}
