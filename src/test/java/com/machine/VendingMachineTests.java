package com.machine;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.machine.entity.Product;

public class VendingMachineTests {

	VendingMachine machine = new VendingMachine();

	@Test
	public void getInputTest() {
		machine.getInput(new BigDecimal("0.10"), Product.A);

		BigDecimal value = machine.getInsertedMoneyValue();
		assertEquals(new BigDecimal("0.10"), value);

		assertEquals(Product.A, machine.getProduct());
	}
}