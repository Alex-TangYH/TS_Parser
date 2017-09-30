package com.alex.ts_parser.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TS_Utils {
	public static boolean isTsFile(String fileName) {
		if (fileName.substring(fileName.length() - 3).equals(".TS")
				|| fileName.substring(fileName.length() - 3).equals(".ts")) {
			return true;
		} else { 
			return false;
		}
	}
	
	/**
	 * 计算两个时间相加，
	 * 
	 * @param strStartTime
	 *            格式： yyyy/MM/dd HH:mm:ss
	 * @param strDuringTime
	 *            格式: HH:mm:ss
	 * @return
	 */
	@SuppressWarnings({ "deprecation" })
	public static String addTime2Time(String strStartTime, String strDuringTime) {
		if (strStartTime == null || strStartTime.equals("")) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(strStartTime));
		cal.add(Calendar.HOUR_OF_DAY, new Integer(strDuringTime.substring(0, 2)));
		cal.add(Calendar.MINUTE, new Integer(strDuringTime.substring(3, 5)));
		cal.add(Calendar.SECOND, new Integer(strDuringTime.substring(6, 8)));
		return sdf.format(cal.getTime());
	}

	/**
	 * MJD格式转UTC
	 * 
	 * @param iMJD
	 * @return
	 */
	public static String mjd2Utc(long iMJD) {
		int k = -1;
		int iYear = (int) (((float) iMJD - 15078.2) / 365.25);
		int iMomth = (int) (((float) iMJD - 14956.1 - (int) (iYear * 365.25)) / 30.6001);
		int iDay = (int) (iMJD - 14956 - (int) (iYear * 365.25) - (int) (iMomth * 30.6001));
		if (iMomth == 14 || iMomth == 15) {
			k = 1;
		} else {
			k = 0;
		}

		iYear += k;
		iMomth = iMomth - 1 - k * 12;

		return String.format("%04d/%02d/%02d", iYear + 1900, iMomth, iDay);
	}
}
 