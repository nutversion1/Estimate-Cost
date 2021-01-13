package com.nut.estimatecost.model;

public class QuatationData{
	public int paperTotal;
	public int bigPaperTotal;
	public float paperCost;
	public float colorSetupCost;
	public float artworkCost;
	public float plateCost;
	public float printCost;
	public float foilingBlockCost;
	public float foilingCost;
	public float embossingBlockCost;
	public float embossingCost;
	public float wrapCost;
	public float shipCost;
	public float principalCost;
	public float profitCost;
	public float price;
	public float unitCost;

	public QuatationData(int paperTotal, int bigPaperTotal, float paperCost, float colorSetupCost, float artworkCost, float plateCost, float printCost,
			float foilingBlockCost, float foilingCost, float embossingBlockCost, float embossingCost,
			float wrapCost, float shipCost, float principalCost, float profitCost, float price, float unitCost){
		this.paperTotal = paperTotal;
		this.bigPaperTotal = bigPaperTotal;
		this.paperCost = paperCost;
		this.colorSetupCost = colorSetupCost;
		this.artworkCost = artworkCost;
		this.plateCost = plateCost;
		this.printCost = printCost;
		this.foilingBlockCost = foilingBlockCost;
		this.foilingCost = foilingCost;
		this.embossingBlockCost = embossingBlockCost;
		this.embossingCost = embossingCost;
		this.wrapCost = wrapCost;
		this.shipCost = shipCost;
		this.principalCost = principalCost;
		this.profitCost = profitCost;
		this.price = price;
		this.unitCost = unitCost;
	}
}
