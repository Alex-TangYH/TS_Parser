package com.alex.ts_parser.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TS_Utils {
	public static String getDigit(String text) {
		Pattern p = Pattern.compile("(\\d+)");
		Matcher m = p.matcher(text);
		String digitResult = "";
		while (m.find()) {
			digitResult += m.group(1).toString();
		}
		return digitResult;
	}

	/**
	 * ����ļ��Ƿ�Ϊts�ļ�
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isTsFile(String fileName) {
		if (fileName.substring(fileName.length() - 3).equals(".TS")
				|| fileName.substring(fileName.length() - 3).equals(".ts")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ����ļ��Ƿ�Ϊtrp�ļ�
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isTrpFile(String fileName) {
		if (fileName.substring(fileName.length() - 4).equals(".TRP")
				|| fileName.substring(fileName.length() - 4).equals(".trp")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ����ļ��Ƿ�Ϊmts�ļ�
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isMtsFile(String fileName) {
		if (fileName.substring(fileName.length() - 4).equals(".MTS")
				|| fileName.substring(fileName.length() - 4).equals(".mts")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ����ļ��Ƿ�Ϊ�ɽ����ļ���Ŀǰ�ɽ����ļ����Ͱ�����ts��mts��trp
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isResolvableFile(String fileName) {
		if (isTsFile(fileName) || isTrpFile(fileName) || isMtsFile(fileName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��������ʱ����ӣ�
	 * 
	 * @param strStartTime
	 *            ��ʽ�� yyyy/MM/dd HH:mm:ss
	 * @param strDuringTime
	 *            ��ʽ: HH:mm:ss
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
	 * MJD��ʽתUTC
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
