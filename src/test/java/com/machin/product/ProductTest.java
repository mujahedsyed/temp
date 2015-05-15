package com.machin.product;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.machine.entity.Product;

public class ProductTest {

	Product p = Product.A;

	@Test
	public void testProduct() {
		assertNotNull(p);
		assertTrue(p instanceof Product);
	}

	@Test
	public void testGetPrice() {
		assertEquals(new BigDecimal(0.60).setScale(2, RoundingMode.HALF_UP),
				Product.A.getPrice());
	}

	@Test
	public void testGetDescription() {
		assertEquals("A", Product.A.getDescription());
	}

}
