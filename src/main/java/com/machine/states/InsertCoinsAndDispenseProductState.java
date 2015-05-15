package com.machine.states;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.Product;
import com.machine.util.Utility;

public class InsertCoinsAndDispenseProductState implements State {

	private final static Logger LOGGER = Logger
			.getLogger(InsertCoinsAndDispenseProductState.class.getName());

	private VendingMachine machine;

	public InsertCoinsAndDispenseProductState(VendingMachine machine) {
		this.machine = machine;
	}

	@Override
	public boolean switchedOff() {
		return false;
	}

	@Override
	public boolean switchedOn() {
		return true;
	}

	@Override
	public Product selectProduct(Product product) {
		return product;
	}

	public boolean enterAmountForSelectedProduct(List<Coin> coins) {
		Product selectedProduct = this.machine.getProduct();
		BigDecimal selectedProductValue = selectedProduct.getPrice();
		BigDecimal sumOfCoins = Utility.sum(coins);
		int comareResult = sumOfCoins.compareTo(selectedProductValue);

		if (comareResult == -1) {
			LOGGER.warning("WARN more coins needed to dispense the product; please put remaning "
					+ (selectedProductValue.subtract(sumOfCoins)) + " amount");
			return false;
		} else if (comareResult == 1) {
			dispense();
			ejectCoins(sumOfCoins.subtract(selectedProductValue));
		} else {
			dispense();

		}
		this.machine.setState(new IdleAndSwitchedOnState(machine));
		return true;
	}

	@Override
	public Product dispense() {
		LOGGER.warning("here is your selection :"
				+ this.machine.getProduct().getDescription());
		return this.machine.getProduct();
	}

	@Override
	public BigDecimal ejectCoins(BigDecimal amount) {
		LOGGER.warning("Returning " + amount);
		this.machine.setState(new IdleAndSwitchedOnState(machine));
		return machine.getCoins();
	}

}
