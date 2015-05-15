package com.machine.states;

import java.math.BigDecimal;
import java.util.List;

import com.machine.entity.Coin;
import com.machine.entity.Product;

public interface State {

	boolean switchedOff();

	boolean switchedOn();

	Product selectProduct(Product product);

	boolean enterAmountForSelectedProduct(List<Coin> coins);

	Product dispense();

	BigDecimal ejectCoins(BigDecimal amount);
}
