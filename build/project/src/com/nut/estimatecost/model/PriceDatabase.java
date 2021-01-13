package com.nut.estimatecost.model;

import java.util.HashMap;
import java.util.Map;

public class PriceDatabase {
	private Map<String, Float> paperTypeCostList;
	private Map<String, Float> paperSizeCostList;
	private Map<String, Float> paperThickCostList;
	private Map<String, Float> artworkCostList;
	private Map<String, Float> colorSetupCostList;
	private Map<String, Float> shipCostList;

	private float colorCost;

	private static PriceDatabase INSTANCE;

	public static PriceDatabase getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new PriceDatabase();
        }

        return INSTANCE;
    }

	private PriceDatabase(){
		//paper type cost list
		paperTypeCostList = new HashMap<String, Float>();
		paperTypeCostList.put("Double A", 31.0f);
		paperTypeCostList.put("Extra", 32.0f);
		paperTypeCostList.put("Avalon", 33.0f);

		//paper size cost list
		paperSizeCostList = new HashMap<String, Float>();
		paperSizeCostList.put("A5", 0.0f);
		paperSizeCostList.put("A4", 0.0f);
		paperSizeCostList.put("A3", 0.0f);

		//paper thick cost list
		paperThickCostList = new HashMap<String, Float>();
		paperThickCostList.put("60", 60f);
		paperThickCostList.put("70", 70f);
		paperThickCostList.put("80", 80f);
		paperThickCostList.put("100", 100f);

		//artwork cost list
		artworkCostList = new HashMap<String, Float>();
		for(int i = 0; i < 10; i++){
			String key = "คุณภาพ "+(i+1);
			float value = (i+1) * 200;

			artworkCostList.put(key, value);
		}

		//color setup cost list
		colorSetupCostList = new HashMap<String, Float>();
		for(int i = 0; i < 10; i++){
			String key = "ความยาก "+(i+1);
			float value = 500 + (i*100);

			colorSetupCostList.put(key, value);
		}
		//ship cost list
		shipCostList = new HashMap<String, Float>();
		shipCostList.put("50", 50f);
		shipCostList.put("100", 100f);
		shipCostList.put("150", 150f);
		shipCostList.put("200", 200f);


		//color cost
		colorCost = 250;
	}



	public Map<String, Float> getPaperTypeCostList(){
		return paperTypeCostList;
	}

	public Map<String, Float> getPaperSizeCostList(){
		return paperSizeCostList;
	}

	public Map<String, Float> getPaperThickCostList(){
		return paperThickCostList;
	}

	public Map<String, Float> getArtworkCostList(){
		return artworkCostList;
	}

	public Map<String, Float> getColorSetupCostList(){
		return colorSetupCostList;
	}

	public Map<String, Float> getShipCostList(){
		return shipCostList;
	}

	public float getColorCost(){
		return colorCost;
	}
}
