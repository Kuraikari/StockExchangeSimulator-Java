package com.main.core;
import com.main.core.interfaces.IObserver;

public class Observer implements IObserver{
	
	protected static int id = 0;
	protected String bankAccount;

	public Observer(){
		id++;
	}

	@Override
	public void update() {

	}
}
