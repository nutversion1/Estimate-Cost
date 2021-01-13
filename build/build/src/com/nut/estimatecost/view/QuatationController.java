package com.nut.estimatecost.view;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.nut.estimatecost.MainApp;
import com.nut.estimatecost.model.Quatation;
import com.nut.estimatecost.util.Utility;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuatationController extends Controller{

	private Stage hostStage;

	private Quatation quatation;

	@FXML
	private AnchorPane page;

	@FXML
	Button printButton;

	@FXML
	private Label companyText;
	@FXML
	private Label ordererText;
	@FXML
	private Label typeText;
	@FXML
	private Label paperText;

	@FXML
	private Label foilingLabel;
	@FXML
	private Label foilingtText;
	@FXML
	private Label embossingLabel;
	@FXML
	private Label embossingText;
	@FXML
	private Label colorSetupText;
	@FXML
	private Label artworkText;
	@FXML
	private Label shipText;
	@FXML
	private Label profitText;

	@FXML
	private Label reamCostText;

	@FXML
	private Label paperTotalText0;
	@FXML
	private Label paperTotalText1;
	@FXML
	private Label paperTotalText2;

	@FXML
	private Label paperCostText0;
	@FXML
	private Label paperCostText1;
	@FXML
	private Label paperCostText2;

	@FXML
	private Label colorSetupCostText0;
	@FXML
	private Label colorSetupCostText1;
	@FXML
	private Label colorSetupCostText2;

	@FXML
	private Label artworkCostText0;
	@FXML
	private Label artworkCostText1;
	@FXML
	private Label artworkCostText2;

	@FXML
	private Label plateCostText0;
	@FXML
	private Label plateCostText1;
	@FXML
	private Label plateCostText2;

	@FXML
	private Label printCostText0;
	@FXML
	private Label printCostText1;
	@FXML
	private Label printCostText2;

	@FXML
	private Label foilingBlockCostText0;
	@FXML
	private Label foilingBlockCostText1;
	@FXML
	private Label foilingBlockCostText2;

	@FXML
	private Label foilingCostText0;
	@FXML
	private Label foilingCostText1;
	@FXML
	private Label foilingCostText2;

	@FXML
	private Label embossingBlockCostText0;
	@FXML
	private Label embossingBlockCostText1;
	@FXML
	private Label embossingBlockCostText2;

	@FXML
	private Label embossingCostText0;
	@FXML
	private Label embossingCostText1;
	@FXML
	private Label embossingCostText2;

	@FXML
	private Label wrapCostText0;
	@FXML
	private Label wrapCostText1;
	@FXML
	private Label wrapCostText2;

	@FXML
	private Label shipCostText0;
	@FXML
	private Label shipCostText1;
	@FXML
	private Label shipCostText2;

	@FXML
	private Label pricipalCostText0;
	@FXML
	private Label pricipalCostText1;
	@FXML
	private Label pricipalCostText2;

	@FXML
	private Label profitCostText0;
	@FXML
	private Label profitCostText1;
	@FXML
	private Label profitCostText2;

	@FXML
	private Label priceText0;
	@FXML
	private Label priceText1;
	@FXML
	private Label priceText2;

	@FXML
	private Label unitCostText0;
	@FXML
	private Label unitCostText1;
	@FXML
	private Label unitCostText2;

	@FXML
	private Label dateText;
	@FXML
	private Label numberText;



	public void setValues(Quatation quatation){
		this.quatation = quatation;

		companyText.setText(quatation.company);
		ordererText.setText(quatation.orderer);
		typeText.setText(quatation.type);
		paperText.setText(quatation.paper);
		colorSetupText.setText(quatation.colorSetup);
		artworkText.setText(quatation.artwork);
		shipText.setText(quatation.ship + " บาท");
		profitText.setText(Integer.toString(quatation.profit) + " %");

		if(quatation.foilingWidth == 0f && quatation.foilingLength == 0f){
			foilingLabel.setVisible(false);
			foilingtText.setVisible(false);
		}else{
			foilingtText.setText(Float.toString(quatation.foilingWidth) + " x " + Float.toString(quatation.foilingLength) + " ตร.น.");
		}

		if(quatation.embossingWidth == 0f && quatation.embossingLength == 0f){
			embossingLabel.setVisible(false);
			embossingText.setVisible(false);
		}else{
			embossingText.setText(Float.toString(quatation.embossingWidth) + " x " + Float.toString(quatation.embossingLength) + " ตร.น.");
		}


		reamCostText.setText("R "+Utility.convertToCostFormat(quatation.reamCost));

		paperTotalText0.setText(Integer.toString(quatation.quatationDatas[0].paperTotal));
		paperTotalText1.setText(Integer.toString(quatation.quatationDatas[1].paperTotal));
		paperTotalText2.setText(Integer.toString(quatation.quatationDatas[2].paperTotal));

		paperCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].paperCost) +
				(" (" + Integer.toString(quatation.quatationDatas[0].bigPaperTotal) + ")"));
		paperCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].paperCost) +
				(" (" + Integer.toString(quatation.quatationDatas[1].bigPaperTotal) + ")"));
		paperCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].paperCost) +
				(" (" + Integer.toString(quatation.quatationDatas[2].bigPaperTotal) + ")"));

		colorSetupCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].colorSetupCost));
		colorSetupCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].colorSetupCost));
		colorSetupCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].colorSetupCost));

		artworkCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].artworkCost));
		artworkCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].artworkCost));
		artworkCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].artworkCost));

		plateCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].plateCost));
		plateCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].plateCost));
		plateCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].plateCost));

		printCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].printCost));
		printCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].printCost));
		printCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].printCost));

		foilingBlockCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].foilingBlockCost));
		foilingBlockCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].foilingBlockCost));
		foilingBlockCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].foilingBlockCost));

		foilingCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].foilingCost));
		foilingCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].foilingCost));
		foilingCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].foilingCost));

		embossingBlockCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].embossingBlockCost));
		embossingBlockCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].embossingBlockCost));
		embossingBlockCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].embossingBlockCost));

		embossingCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].embossingCost));
		embossingCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].embossingCost));
		embossingCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].embossingCost));

		wrapCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].wrapCost));
		wrapCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].wrapCost));
		wrapCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].wrapCost));

		shipCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].shipCost));
		shipCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].shipCost));
		shipCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].shipCost));

		pricipalCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].principalCost));
		pricipalCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].principalCost));
		pricipalCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].principalCost));

		profitCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].profitCost));
		profitCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].profitCost));
		profitCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].profitCost));

		priceText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].price));
		priceText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].price));
		priceText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].price));

		unitCostText0.setText(Utility.convertToCostFormat(quatation.quatationDatas[0].unitCost));
		unitCostText1.setText(Utility.convertToCostFormat(quatation.quatationDatas[1].unitCost));
		unitCostText2.setText(Utility.convertToCostFormat(quatation.quatationDatas[2].unitCost));

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		dateText.setText(dateFormat.format(date));

		numberText.setText("เลขที่ " + number);
		mainApp.save();
	}

	@FXML
	private void handlePrint(){
		PrinterJob job = PrinterJob.createPrinterJob();
		if(job != null){
			//show print setup
			boolean print = job.showPrintDialog(hostStage);

			//
			if(print){

				//hide print button
				printButton.setVisible(false);

				//scale page(a4)
				//scalePageToA4(page);

				//print
				boolean success = job.printPage(page);
				if(success){
					job.endJob();
				}

				//show print button
				printButton.setVisible(true);

			}
		}
	}

	private void scalePageToA4(Node node){
		//A4 = 487, 734

		Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
        double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
        node.getTransforms().add(new Scale(scaleX, scaleY));
	}



	public void setHostStage(Stage stage){
		hostStage = stage;
	}
}
