package com.crazyapps.crazynudgemail;

public class ToBuilder {

	private static final String	NUDGEMAIL_COM	= "@nudgemail.com";

	public static String hours(int hours) {
		return String.valueOf(hours).concat("h").concat(NUDGEMAIL_COM);
	}

	public static String days(int days) {
		return String.valueOf(days).concat("d").concat(NUDGEMAIL_COM);
	}

	public static String date(int year, int month, int day) {
		return new StringBuilder().append(String.format("%02d", month)).append(String.format("%02d", day)).append(year)
				.append(NUDGEMAIL_COM).toString();
	}

}
