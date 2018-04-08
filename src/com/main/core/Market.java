package com.main.core;

import java.util.ArrayList;

public class Market {
	private static Market _instance;
	private ArrayList<Stock> avaiableStocks;

	private Market() {
		avaiableStocks = new ArrayList<Stock>();
	}
	private Market(ArrayList<Stock> savedStocks) {
		avaiableStocks = savedStocks;
	}
	
	public static Market getInstance() {
		if(_instance == null)
			_instance = new Market();
		return _instance;
	}
	
	public static Market getInstance(ArrayList<Stock> savedStocks) {
		if(_instance == null)
			_instance = new Market(savedStocks);
		return _instance;
	}
	
	public void addAvaiableStock(Stock stock) {
		avaiableStocks.add(stock);
	}
	public void removeAvaiableStock(Stock stock) {
		avaiableStocks.remove(stock);
	}
	public ArrayList<Stock> getAvaiableStocks() {
		return avaiableStocks;
	}
}
