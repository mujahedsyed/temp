package com.machine.states;

import java.math.BigDecimal;
import java.util.List;

import com.machine.VendingMachine;
import com.machine.entity.Coin;
import com.machine.entity.Product;

public class IdleAndSwitchedOnState implements State {

	private VendingMachine machine;

	public IdleAndSwitchedOnState(VendingMachine machine) {
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
		System.out.println("Select product ...");
		return product;
	}

	@Override
	public boolean enterAmountForSelectedProduct(List<Coin> coins) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product dispense() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal ejectCoins(BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
