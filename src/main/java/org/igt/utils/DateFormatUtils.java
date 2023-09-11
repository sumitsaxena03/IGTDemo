/**
 * 
 */
package org.igt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Apr 7, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see
 */
public class DateFormatUtils {
	
	private static String pattern = "yyyy-MM-dd'T'HH:mm:ss-SSSSZ";
	private static final String NEWYORKDATETIME = "America/New_York";  
	/**
	 * Method to provide date format in yyyy-MM-dd format
	 * Apr 7, 2022
	 * @author Mandeep Sheoran
	 * @see SimpleDateFormat
	 */
	public static String yyyyMmDdFormat() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);		
		return smpldtfrmt.format(new Date());
	}
	/**
	 * Method to provide date format in "yyyy-MM-dd'T'HH:mm:ss-SSSSZ" format for New York(America) zone.
	 * Apr 7, 2022
	 * @author Mandeep Sheoran
	 * @see SimpleDateFormat
	 */
	public static String amsCurrentDateTimeFormat() {	
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern, Locale.US);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date());
		return date.substring(0, 24);
	}
	
	/**
	 * Method to provide date format in "yyyy-MM-dd'T'HH:mm:ss-SSSSZ" format after adding one hour in current New York(America) time.
	 * Apr 7, 2022
	 * @author Mandeep Sheoran
	 * @see SimpleDateFormat
	 */
	public static String amsPlusOneHourFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 3600000));
		return date.substring(0, 20).concat("0500");
	}
	
	/**
	 * Method to provide date format in "yyyy-MM-dd'T'HH:mm:ss-SSSSZ" format after substracting one hour from current New York(America) time.
	 * Apr 7, 2022
	 * @author Mandeep Sheoran
	 * @see SimpleDateFormat
	 */
	public static String amsMinusOneHourFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() - 3600000));
		return date.substring(0, 20).concat("0500");
	}
		
		public static String amsPlusTwoHourFormat() {
			SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
			smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
			String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 7200000));
			return date.substring(0, 20).concat("0500");
		
	}
	public static String amsPlusOneHourFourtyMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 6000000));
		return date.substring(0, 20).concat("0500");
	}
	
	public static String amsPlusOneHourThirtyMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 5400000));
		return date.substring(0, 20).concat("0500");
	}

	public static String amsPlusOneHourTwentyMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 4800000));
		return date.substring(0, 20).concat("0500");
	}
	
	public static String amsPlusOneHourTenMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 4200000));
		return date.substring(0, 20).concat("0500");
	}
	public static String amsPlusFiftyMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 3000000));
		return date.substring(0, 20).concat("0500");
	}
	public static String amsPlusFourtyMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 2400000));
		return date.substring(0, 20).concat("0500");
	}
	
	public static String amsPlusThirtyMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 1800000));
		return date.substring(0, 20).concat("0500");
	}
	
	public static String amsPlusTwentyMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 1200000));
		return date.substring(0, 20).concat("0500");
	}
	
	public static String amsPlusTwoHourFiveMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 7500000));
		return date.substring(0, 20).concat("0500");
	}
		
		public static String amsPlusTwoHourTenMinsFormat() {
			SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
			smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
			String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 7800000));
			return date.substring(0, 20).concat("0500");
		
	
}
	public static String amsPlusTwoHourThirtyMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 8900000));
		return date.substring(0, 20).concat("0500");
	
}
	public static String amsPlusTwoHourThirtyFiveMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() +9300000));
		return date.substring(0, 20).concat("0500");
	
}
	public static String amsPlusTwoHourFourtyMinsFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() +9600000));
		return date.substring(0, 20).concat("0500");
	}
	
		public static String amsPlusTwoHourFiftyMinsFormat() {
			SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
			smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
			String date = smpldtfrmt.format(new Date(System.currentTimeMillis() +10200000));
			return date.substring(0, 20).concat("0500");
		
}
		
		public static String amsPlusTwoHourFiftyFiveMinsFormat() {
			SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
			smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
			String date = smpldtfrmt.format(new Date(System.currentTimeMillis() +10500000));
			return date.substring(0, 20).concat("0500");
		
}
	public static String amsPlusThreeHourFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 10700000));
		return date.substring(0, 20).concat("0500");
	
}
	public static String currentUTCDateTimeFormat() {	
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern, Locale.US);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone("UTC"));
		String date = smpldtfrmt.format(new Date());
		return date.substring(0, 24);
	}
	public static String currentASIADateTimeFormat() {	
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern, Locale.US);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
		String date = smpldtfrmt.format(new Date());
		return date.substring(0, 24);
	}
}