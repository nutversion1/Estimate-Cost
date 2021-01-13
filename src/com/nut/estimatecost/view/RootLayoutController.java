package com.nut.estimatecost.view;



import com.nut.estimatecost.MainApp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController extends Controller{
	public void RootLayoutController(){

	}

	@FXML
	private void initialize(){
	}

	@FXML
	private void handleAbout(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("NutEstimateCostApp");
		alert.setHeaderText("About");
		alert.setContentText("Author: Nuttapong Phisitbutr");
		alert.showAndWait();
	}

	@FXML
	private void handleExit(){
		System.exit(0);
	}
}
