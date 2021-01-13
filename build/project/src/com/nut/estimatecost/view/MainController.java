package com.nut.estimatecost.view;

import java.io.IOException;

import com.nut.estimatecost.MainApp;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class MainController extends Controller{
	@FXML
	private AnchorPane typeListPane;
	@FXML
	private AnchorPane operationPane;

	@FXML
	private ListView typeList;

	public MainController(){

	}

	@FXML
	private void initialize(){
		//
		typeList.getItems().add("กระดาษแผ่นเดียว");
		typeList.getItems().add("ซองจดหมาย");
		typeList.getItems().add("หนังสือ");

		//
		typeList.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showOperationView((String)typeList.getSelectionModel().selectedItemProperty().getValue()));



	}

	public void showOperationView(String value){
		String viewName = "";
		if(value == "กระดาษแผ่นเดียว"){
			viewName = "view/LetterPage.fxml";
		}else if(value == "ซองจดหมาย"){
			viewName = "view/Envelope.fxml";
		}else if(value == "หนังสือ"){
			viewName = "view/Book.fxml";
		}

		if(operationPane.getChildren().size() > 0){
			operationPane.getChildren().clear();
		}

		try{
			FXMLLoader loader = new  FXMLLoader();
			loader.setLocation(MainApp.class.getResource(viewName));
			AnchorPane view = (AnchorPane)loader.load();

			operationPane.getChildren().add(view);


			Controller controller = loader.getController();
			controller.setMainApp(mainApp);
			controller.setType(value);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
