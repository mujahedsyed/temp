package com.machine.inventory;

import java.util.ArrayList;
import java.util.List;

import com.machine.entity.Coin;

public class Coins {

	private Coins() {
	}

	private static final Coins singletonInstance = new Coins();
	private static List<Coin> coins = new ArrayList<Coin>();

	public static Coins getSingeltonInstance() {
		return singletonInstance;
	}

	// for demo - hardcoding some change
	static {
		coins.add(Coin.FiftyPence);
		coins.add(Coin.FiftyPence);
		coins.add(Coin.FiftyPence);
		coins.add(Coin.TenPence);
		coins.add(Coin.TenPence);
		coins.add(Coin.TenPence);
		coins.add(Coin.TenPence);
		coins.add(Coin.OnePound);
		coins.add(Coin.OnePound);
		coins.add(Coin.OnePound);
		coins.add(Coin.TwentyPence);
		coins.add(Coin.TwentyPence);
		coins.add(Coin.TwentyPence);
	}

	public void removeCoin(Coin coin) {
		coins.remove(coin);
	}

	public List<Coin> getAvailableChange() {
		return coins;
	}

	public void addChange(List<Coin> change) {
		coins.addAll(change);
	}

}
