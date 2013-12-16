package com.dw.party.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtil
 * @author xingkong1221
 *
 */
public class DateUtil {

	/**
	 * Formatting date to string
	 * @param data
	 * @param format
	 * @return String 
	 */
	public static String dateToString(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
}
