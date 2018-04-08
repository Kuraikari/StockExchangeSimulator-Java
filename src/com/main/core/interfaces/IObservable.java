package com.main.core.interfaces;

import com.main.core.Observer;

public interface IObservable {
	public void addObserver(Observer obs);
	public void removeObserver(Observer obs);
	public void notifyObserver();
}
