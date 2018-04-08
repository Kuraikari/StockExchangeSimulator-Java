package com.main.core;

import com.main.model.BaseModel;

import java.util.ArrayList;

public class Customer extends BaseModel {
	
	public ArrayList<Stock> boughtStocks;
	private Observer observer;
	public String bankAccount;
	
	public Customer(String name, String bankAccount) {
		observer = new Observer();
		this.name = name;
		this.bankAccount = bankAccount;
	}

	@Override
	public void save() {

	}

	@Override
	public void update() {

	}

	@Override
	public void delete() {

	}
}