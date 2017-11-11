package com.android_assistant;

public class Integer {
	public static final int MAX_VALUE = java.lang.Integer.MAX_VALUE;
	
	public static int parseInt(String string, int radix, int defaultValue) {
		try {
			return java.lang.Integer.parseInt(string, radix);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
}
