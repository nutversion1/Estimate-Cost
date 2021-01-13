package com.nut.estimatecost.model;

public class QuatationManager {
	private static QuatationManager INSTANCE;

	public static QuatationManager getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new QuatationManager();
        }

        return INSTANCE;
    }

	private QuatationManager(){

	}

	public float calculateReamCost(String paperType, String paperThick){
		float paperTypeCost = PriceDatabase.getInstance().getPaperTypeCostList().get(paperType);
		float paperThickCost = PriceDatabase.getInstance().getPaperThickCostList().get(paperThick);

		float reamCost = ((24f * 35f * paperThickCost) / 3100f) * paperTypeCost;

		return reamCost;
	}

	public QuatationData[] calculateQuatations(float reamCost, String paperType, String paperSize, String paperThick,
			int paperTotal0, int paperTotal1, int paperTotal2,
			int colorTotal, String colorSetup, String artwork,
			float foilingWidth, float foilingLength, float embossingWidth, float embossingLength,
			String ship, int profit){

		//create quatation datas
		QuatationData quatationData0 = calculateQuatation(reamCost, paperType, paperSize, paperThick, paperTotal0, colorTotal, colorSetup, artwork,
				foilingWidth, foilingLength, embossingWidth, embossingLength, ship, profit);
		QuatationData quatationData1 = calculateQuatation(reamCost, paperType, paperSize, paperThick, paperTotal1, colorTotal, colorSetup, artwork,
				foilingWidth, foilingLength, embossingWidth, embossingLength, ship, profit);
		QuatationData quatationData2 = calculateQuatation(reamCost, paperType, paperSize, paperThick, paperTotal2, colorTotal, colorSetup, artwork,
				foilingWidth, foilingLength, embossingWidth, embossingLength, ship, profit);

		QuatationData[] quatationDatas = {quatationData0, quatationData1, quatationData2};

		return quatationDatas;
	}

	private QuatationData calculateQuatation(float reamCost, String paperType, String paperSize, String paperThick, int paperTotal,
			int colorTotal, String colorSetup, String artwork,
			float foilingWidth, float foilingLength, float embossingWidth, float embossingLength,
			String ship, int profit){
		int bigPaperTotal = calculateBigPaperTotal(paperTotal);
		float paperCost = calculatePaperCost(reamCost, bigPaperTotal);
		float colorSetupCost = calculateColorSetupCost(colorSetup);
		float artworkCost = calculateArtworkCost(artwork);
		float plateCost = calculatePlateCost(colorTotal);
		float printCost = calculatePrintCost(paperTotal);
		float wrapCost = calculateWrapCost(paperTotal);
		float foilingBlockCost = calculateFoilingBlockCost(foilingWidth, foilingLength);
		float foilingCost = calculateFoilingCost(foilingWidth, foilingLength, paperTotal);
		float embossingBlockCost = calculateEmbossingBlockCost(embossingWidth, embossingLength);
		float embossingCost = calculateEmbossingCost(embossingWidth, embossingLength, paperTotal);
		float shipCost = calculateShipCost(ship);
		float principalCost = caculatePrincipalCost(paperCost, colorSetupCost, artworkCost, plateCost, printCost, wrapCost,
				foilingBlockCost, foilingCost, embossingBlockCost, embossingCost, shipCost);
		float profitCost = calculateProfitCost(profit, principalCost);
		float price = calculatePrice(principalCost, profitCost);
		float unitCost = calculateUnitCost(paperTotal, price);

		QuatationData quatationData = new QuatationData(paperTotal,
				bigPaperTotal,
				paperCost,
				colorSetupCost,
				artworkCost,
				plateCost,
				printCost,
				foilingBlockCost,
				foilingCost,
				embossingBlockCost,
				embossingCost,
				wrapCost,
				shipCost,
				principalCost,
				profitCost,
				price,
				unitCost);

		return quatationData;
	}

	private int calculateBigPaperTotal(int paperTotal){
		int bigPaperTotal = (int) Math.ceil(paperTotal / 8f);

		return bigPaperTotal;
	}

	private float calculatePaperCost(float reamCost, int bigPaperTotal){
		float paperCost = (reamCost * bigPaperTotal) / 500f;

		return paperCost;
	}

	private float calculateArtworkCost(String artwork){
		if(artwork == null){
			return 0f;
		}

		//calculate artwork cost
		float artworkCost = PriceDatabase.getInstance().getArtworkCostList().get(artwork);

		return artworkCost;
	}

	private float calculateColorSetupCost(String colorSetup){
		//calculate color setup cost
		float colorSetupCost = PriceDatabase.getInstance().getColorSetupCostList().get(colorSetup);

		return colorSetupCost;
	}

	private float calculatePlateCost(int colorTotal){
		float plateCost = colorTotal * PriceDatabase.getInstance().getColorCost();

		return plateCost;
	}

	private float calculatePrintCost(int paperTotal){
		int unit = paperTotal / 1000;

		float printCost = 500 + (unit*100);

		return printCost;
	}

	private float calculateFoilingBlockCost(float foilingWidth, float foilingLength){
		float foilingSize = foilingWidth * foilingLength;

		if(foilingSize == 0f){
			return 0f;
		}

		int unit = (int) Math.ceil(foilingSize / 1f);

		float foilingBlockCost = 100 + (unit*50);


		return foilingBlockCost;
	}

	private float calculateFoilingCost(float foilingWidth, float foilingLength, int paperTotal){
		float foilingSize = foilingWidth * foilingLength;

		if(foilingSize == 0f){
			return 0f;
		}

		float foilingCost = 400 + (foilingSize * 0.30f * paperTotal);

		return foilingCost;
	}

	private float calculateEmbossingBlockCost(float embossingWidth, float embossingLength){
		float embossingSize = embossingWidth * embossingLength;

		if(embossingSize == 0f){
			return 0f;
		}

		int unit = (int) Math.ceil(embossingSize / 1f);

		float embossingBlockCost = 200 + (unit*100);

		return embossingBlockCost;
	}

	private float calculateEmbossingCost(float embossingWidth, float embossingLength, int paperTotal){
		float embossingSize = embossingWidth * embossingLength;

		if(embossingSize == 0f){
			return 0f;
		}

		float embossingCost = 500 + (0.20f * paperTotal);

		return embossingCost;
	}

	private float calculateWrapCost(int paperTotal){
		/*
		int unit = (int) Math.ceil(paperTotal / 500f);

		float wrapCost = 100 + (unit*20);*/

		float wrapCost = 100 + ((paperTotal / 500) * 20);

		return wrapCost;
	}

	private float calculateShipCost(String ship){
		float shipCost = PriceDatabase.getInstance().getShipCostList().get(ship);

		return shipCost;
	}

	private float caculatePrincipalCost(float paperCost, float colorSetupCost, float artworkCost, float plateCost, float printCost,
			float foilingBlockCost, float foilingCost, float embossingBlockCost, float embossingCost, float wrapCost, float shipCost){
		float principalCost = paperCost + colorSetupCost + artworkCost + plateCost + printCost + foilingBlockCost + foilingCost + embossingBlockCost+ embossingCost
				+ wrapCost + shipCost;

		return principalCost;
	}

	private float calculateProfitCost(int profit, float principalCost){
		float profitCost =  principalCost * (profit / 100f);

		return profitCost;
	}

	private float calculatePrice(float principalCost, float profitCost){
		float price = principalCost + profitCost;

		return price;
	}

	private float calculateUnitCost(int paperTotal, float price) {
		float unitCost = price / paperTotal;

		return unitCost;
	}

}
