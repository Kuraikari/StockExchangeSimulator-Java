package com.main.core;

import java.util.ArrayList;

import com.main.core.interfaces.IObservable;

public class Stock implements IObservable {
	public ArrayList<Observer> users;
	public boolean isInStock;
	public double value;
	public int countOnMarket;
	public double annualPercentageRate;
	public int demand;
	
	public Stock(double value, int count) {
		this.users = new ArrayList<Observer>();
		isInStock = false;
		this.value = value;
		this.countOnMarket = count;
		this.annualPercentageRate = 0.0;
		this.demand = 0;
	}

	@Override
	public void addObserver(Observer obs) {
		this.users.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		this.users.remove(obs);
	}

	@Override
	public void notifyObserver() {

	}

	public void updateValue(){
		int temp =demand;
		if(demand++ >= countOnMarket){
			if (countOnMarket != 0)
				value = (temp / (1-(demand/countOnMarket)));
			else
				value = (temp / (1+(demand/countOnMarket+1)^2))*2;
		}
	}
}
