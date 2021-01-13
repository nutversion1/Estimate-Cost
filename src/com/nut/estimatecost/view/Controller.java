package com.nut.estimatecost.view;

import com.nut.estimatecost.MainApp;

public abstract class Controller {
	protected MainApp mainApp;
	protected String type;
	protected int number;

	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}

	public void setType(String type){
		this.type = type;
	}

	public void setNumber(int number){
		this.number = number;
	}
}
