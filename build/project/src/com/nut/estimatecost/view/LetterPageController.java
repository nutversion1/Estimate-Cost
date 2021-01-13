package com.nut.estimatecost.view;

import java.util.HashMap;
import java.util.Map;

import com.nut.estimatecost.MainApp;
import com.nut.estimatecost.model.PriceDatabase;
import com.nut.estimatecost.model.Quatation;
import com.nut.estimatecost.model.QuatationData;
import com.nut.estimatecost.model.QuatationManager;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LetterPageController extends Controller{

	@FXML
	private TextField companyField;
	@FXML
	private TextField ordererField;

	@FXML
	private Label paperTypeValueText;

	@FXML
	private ChoiceBox paperTypeChoiceBox;
	@FXML
	private ChoiceBox paperSizeChoiceBox;
	@FXML
	private ChoiceBox paperThickChoiceBox;
	@FXML
	private TextField paperTotalField0;
	@FXML
	private TextField paperTotalField1;
	@FXML
	private TextField paperTotalField2;

	@FXML
	private ChoiceBox colorTotalChoiceBox;
	@FXML
	private ChoiceBox colorSetupChoiceBox;
	@FXML
	private CheckBox artworkCheckBox;
	@FXML
	private ChoiceBox artworkChoiceBox;
	@FXML
	private TextField profitField;
	@FXML
	private ChoiceBox shipChoiceBox;
	@FXML
	private CheckBox foilingCheckBox;
	@FXML
	private Label foilingWidthLabel;
	@FXML
	private TextField foilingWidthField;
	@FXML
	private Label foilingLengthLabel;
	@FXML
	private TextField foilingLengthField;
	@FXML
	private CheckBox embossingCheckBox;
	@FXML
	private Label embossingWidthLabel;
	@FXML
	private TextField embossingWidthField;
	@FXML
	private Label embossingLengthLabel;
	@FXML
	private TextField embossingLengthField;



	public LetterPageController(){

	}

	@FXML
	private void initialize(){
		//paper type
		paperTypeChoiceBox.getItems().add("Double A");
		paperTypeChoiceBox.getItems().add("Extra");
		paperTypeChoiceBox.getItems().add("Avalon");
		//paper size
		paperSizeChoiceBox.getItems().add("A5");
		paperSizeChoiceBox.getItems().add("A4");
		paperSizeChoiceBox.getItems().add("A3");
		//paper thick
		paperThickChoiceBox.getItems().add("60");
		paperThickChoiceBox.getItems().add("70");
		paperThickChoiceBox.getItems().add("80");
		paperThickChoiceBox.getItems().add("100");

		//color total
		colorTotalChoiceBox.getItems().add("1");
		colorTotalChoiceBox.getItems().add("2");
		colorTotalChoiceBox.getItems().add("4");
		colorTotalChoiceBox.getItems().add("6");
		//color setup
		for(int i = 0; i < 10; i++){
			colorSetupChoiceBox.getItems().add("ความยาก " + (i+1));
		}
		//artwork check box
		artworkCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(artworkCheckBox.isSelected()){
					artworkChoiceBox.setDisable(false);
				}else{
					artworkChoiceBox.setDisable(true);
				}

			}
		});

		//artwork choice box
		for(int i = 0; i < 10; i++){
			artworkChoiceBox.getItems().add("คุณภาพ " + (i+1));
		}
		artworkChoiceBox.getSelectionModel().selectFirst();
		//ship choice box
		shipChoiceBox.getItems().add("50");
		shipChoiceBox.getItems().add("100");
		shipChoiceBox.getItems().add("150");
		shipChoiceBox.getItems().add("200");
		//foiling check box
		foilingCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(foilingCheckBox.isSelected()){
					foilingWidthLabel.setDisable(false);
					foilingWidthField.setDisable(false);
					foilingLengthLabel.setDisable(false);
					foilingLengthField.setDisable(false);
				}else{
					foilingWidthLabel.setDisable(true);
					foilingWidthField.setDisable(true);
					foilingLengthLabel.setDisable(true);
					foilingLengthField.setDisable(true);
				}

			}
		});
		//embossing check box
		embossingCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(embossingCheckBox.isSelected()){
					embossingWidthLabel.setDisable(false);
					embossingWidthField.setDisable(false);
					embossingLengthLabel.setDisable(false);
					embossingLengthField.setDisable(false);
				}else{
					embossingWidthLabel.setDisable(true);
					embossingWidthField.setDisable(true);
					embossingLengthLabel.setDisable(true);
					embossingLengthField.setDisable(true);
				}

			}
		});

		//add listener
		paperTypeChoiceBox.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> setTypeValueText(PriceDatabase.getInstance().getPaperTypeCostList().get(paperTypeChoiceBox.getSelectionModel().selectedItemProperty().getValue())));

	}

	public void setTypeValueText(float value){
		paperTypeValueText.setText(Float.toString(value) + " บาท");
	}

	@FXML
	private void handleQuatation(){
		String paperType = (String) paperTypeChoiceBox.getSelectionModel().selectedItemProperty().getValue();
		String paperSize = (String) paperSizeChoiceBox.getSelectionModel().selectedItemProperty().getValue();
		String paperThick = (String) paperThickChoiceBox.getSelectionModel().selectedItemProperty().getValue();
		int paperTotal0 = Integer.parseInt(paperTotalField0.getText());
		int paperTotal1 = Integer.parseInt(paperTotalField1.getText());
		int paperTotal2 = Integer.parseInt(paperTotalField2.getText());
		int colorTotal = Integer.parseInt((String) colorTotalChoiceBox.getSelectionModel().getSelectedItem());
		String colorSetup = (String) colorSetupChoiceBox.getSelectionModel().getSelectedItem();
		String artwork = artworkCheckBox.isSelected() ? (String) artworkChoiceBox.getSelectionModel().getSelectedItem() : null;
		float foilingWidth = foilingCheckBox.isSelected() ? Float.parseFloat(foilingWidthField.getText()) : 0f;
		float foilingLength = foilingCheckBox.isSelected() ? Float.parseFloat(foilingLengthField.getText()) : 0f;
		float embossingWidth = embossingCheckBox.isSelected() ? Float.parseFloat(embossingWidthField.getText()) : 0f;
		float embossingLength = embossingCheckBox.isSelected() ? Float.parseFloat(embossingLengthField.getText()) : 0f;
		String ship = (String) shipChoiceBox.getSelectionModel().getSelectedItem();
		int profit = Integer.parseInt(profitField.getText());

		String company = companyField.getText();
		String orderer = ordererField.getText();
		String type = this.type;
		String paper = paperType + ", " + paperSize + ", " + paperThick;


		//ream cost
		float reamCost = QuatationManager.getInstance().calculateReamCost(paperType, paperThick);

		//quatation datas
		QuatationData[] quatationDatas = QuatationManager.getInstance().calculateQuatations(
				reamCost, paperType, paperSize, paperThick,
				paperTotal0, paperTotal1, paperTotal2,
				colorTotal, colorSetup, artwork, foilingWidth, foilingLength, embossingWidth, embossingLength, ship, profit);

		//show quatation
		Quatation quatation = new Quatation(company, orderer, type, paper, colorSetup, artwork, ship, profit,
				foilingWidth, foilingLength, embossingWidth, embossingLength, reamCost, quatationDatas);
		mainApp.showQuatation(quatation);
	}
}
