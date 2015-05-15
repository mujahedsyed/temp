package com.machine.products;

import java.util.ArrayList;
import java.util.List;

import com.machine.entity.Product;

public class Products {

	private Products() {
	}

	private static final Products singeltonInstance = new Products();
	private static List<Product> products = new ArrayList<Product>();

	public static Products getSingeltonInstance() {
		return singeltonInstance;
	}

	// for demo - hardcoding the list of 8 products
	static {
		products.add(Product.A);
		products.add(Product.B);
		products.add(Product.C);
		products.add(Product.C);
		products.add(Product.C);
		products.add(Product.B);
		products.add(Product.B);
		products.add(Product.A);
	}

	public void removeProduct(Product p) {
		products.remove(p);
	}

	public List<Product> getCurrentProducts() {
		return products;
	}
}
