package com.nut.estimatecost.util;

import java.text.DecimalFormat;

public class Utility {
	public static String convertToCostFormat(float value){
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);

		return df.format(value);
	}
}
