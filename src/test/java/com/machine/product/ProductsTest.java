package com.machine.product;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.machine.entity.Product;
import com.machine.inventory.Products;

/**
 * This class tests basic functionality provided by Products like remove the
 * product, put the product and get current stock
 * 
 * @author mujahedsyed
 *
 */
public class ProductsTest {

	Products p1 = Products.getSingeltonInstance();

	@Test
	public void testGetSingeltonInstance() {
		Products p2 = Products.getSingeltonInstance();
		assertTrue(p1 == p2);
	}

	@Test
	public void testRemoveProduct() {
		p1.removeProduct(Product.A);

		// 8 products were available by default removed one in above step
		List<Product> list = p1.getCurrentProducts();
		assertEquals(7, list.size());
		assertTrue(list.contains(Product.A));
		assertEquals(1, Collections.frequency(list, Product.A));
	}

	@Test
	public void testGetCurrentProducts() {
		// test same as testRemoveProducts()
		// skipping
	}

}
