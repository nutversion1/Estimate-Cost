package com.nut.estimatecost;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import com.nut.estimatecost.model.PriceDatabase;
import com.nut.estimatecost.model.Quatation;
import com.nut.estimatecost.view.MainController;
import com.nut.estimatecost.view.QuatationController;
import com.nut.estimatecost.view.RootLayoutController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	public int number;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("NutEstimateCostApp");

		initRootLayout();

		showMain();

		load();

	}

	public void save(){
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		prefs.putInt("number", number);
	}

	public void load(){
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		number = prefs.getInt("number", 0);
	}

	public void initRootLayout() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane)loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public void showMain() {
		try{
			FXMLLoader loader = new  FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Main.fxml"));
			AnchorPane main = (AnchorPane)loader.load();

			rootLayout.setCenter(main);

			MainController controller = loader.getController();
			controller.setMainApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void showQuatation(Quatation quatation){

		try{
			FXMLLoader loader = new  FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Quatation.fxml"));
			AnchorPane page = (AnchorPane)loader.load();

			Stage stage = new Stage();
			stage.setTitle("ใบเสนอราคา");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			stage.setScene(scene);

			//dialogStage.getIcons().add(new Image("file:resources/images/icon.png"));


			QuatationController controller = loader.getController();
			controller.setMainApp(this);
			controller.setHostStage(stage);
			controller.setNumber(++number);
			controller.setValues(quatation);


			stage.showAndWait();






		}catch(IOException e){
			e.printStackTrace();

		}

	}






}
