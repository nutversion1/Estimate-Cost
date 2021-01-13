package com.nut.estimatecost.model;



public class Quatation {
	public String type;
	public String paper;
	public String company;
	public String orderer;
	public String colorSetup;
	public String artwork;
	public String ship;
	public int profit;
	public float foilingWidth;
	public float foilingLength;
	public float embossingWidth;
	public float embossingLength;
	public float reamCost;
	public QuatationData[] quatationDatas;


	public Quatation(String company, String orderer, String type, String paper, String colorSetup, String artwork, String ship, int profit,
			float foilingWidth, float foilingLength, float embossingWidth, float embossingLength,
			float reamCost, QuatationData[] quatationDatas) {

		this.company = company;
		this.orderer = orderer;
		this.type = type;
		this.paper = paper;
		this.colorSetup = colorSetup;
		this.artwork = artwork;
		this.ship = ship;
		this.profit = profit;
		this.foilingWidth = foilingWidth;
		this.foilingLength= foilingLength;
		this.embossingWidth = embossingWidth;
		this.embossingLength = embossingLength;
		this.reamCost = reamCost;
		this.quatationDatas = quatationDatas;
	}

}
