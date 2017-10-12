package com.alex.ts_parser;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.EpgTableInfoBean;
import com.alex.ts_parser.bean.EpgTableInfoBean.EIT_TYPE;
import com.alex.ts_parser.bean.descriptor.ContentDescriptor;
import com.alex.ts_parser.bean.descriptor.ContentInfo;
import com.alex.ts_parser.bean.descriptor.Descriptor;
import com.alex.ts_parser.bean.descriptor.ParentalRatingDescriptor;
import com.alex.ts_parser.bean.descriptor.ParentalRatingInfo;
import com.alex.ts_parser.bean.descriptor.ShortEventDescriptor;
import com.alex.ts_parser.bean.map.ContentNibbleLevelMap;
import com.alex.ts_parser.bean.si.EIT_Table;
import com.alex.ts_parser.bean.si.EitInfo;
import com.alex.ts_parser.ui.MainWindow;
import com.alex.ts_parser.ui.ToastOfSwing;
import com.alex.ts_parser.utils.TS_Utils;
import com.alex.ts_parser.vo.EpgTableInfoList;
import com.alex.ts_parser.vo.TableData;

public class FillEpgDataThread extends Thread {
	// TODO ��������������ݸ�ʽ����ȫ����Ҫ�ڷ���������һ��
	private static Logger logger = LogManager.getLogger("FillEpgDataThread");

	@Override
	public synchronized void start() {
		super.start();
	}

	@Override
	public void run() {
		try {
			EIT_Table[] eitPfActualData = TableData.getInstance().getEitPfArrays();
			EIT_Table[] eitSchedule50Data = TableData.getInstance().getEitSchedule50Arrays();
			EIT_Table[] eitSchedule51Data = TableData.getInstance().getEitSchedule51Arrays();
			EIT_Table[] eitData = new EIT_Table[eitPfActualData.length + eitSchedule50Data.length
					+ eitSchedule51Data.length];
			System.arraycopy(eitPfActualData, 0, eitData, 0, eitPfActualData.length);
			System.arraycopy(eitSchedule50Data, 0, eitData, eitPfActualData.length, eitSchedule50Data.length);
			System.arraycopy(eitSchedule51Data, 0, eitData, eitPfActualData.length + eitSchedule50Data.length,
					eitSchedule51Data.length);
			getEpgTableDataFromEit(eitData);
			MainWindow.epgTableInfoListVo = new ArrayList<>(EpgTableInfoList.getInstance().getEpgTableInfolist());
		} catch (Exception ex) {
			logger.error("run()", ex);
		} finally {
			MainWindow.programInfoTable.revalidate();
			MainWindow.frmTs.setEnabled(true);
			MainWindow.toast.setVisible(false);
			final ToastOfSwing toast = new ToastOfSwing(MainWindow.frmTs, "������ɣ�", 1000, ToastOfSwing.msg);
			toast.start();
		}
	}

	private void getEpgTableDataFromEit(EIT_Table[] eitData) {
		if (eitData == null || eitData.length <= 0) {
			return;
		}

		for (EIT_Table eit_Table : eitData) {
			EitInfo[] eitInfoArray = eit_Table.getEitInfoArray();
			for (EitInfo eitInfo : eitInfoArray) {
				EpgTableInfoBean epgTableInfoBean = new EpgTableInfoBean();
				epgTableInfoBean.setServiceId(eit_Table.getServiceId());
				switch (eit_Table.getTableId()) {
				case 0x4e:
					if (eit_Table.getSectionNumber() == 0) {
						epgTableInfoBean.setType(EIT_TYPE.P);
					} else if (eit_Table.getSectionNumber() == 1) {
						epgTableInfoBean.setType(EIT_TYPE.F);
					} else {
					}
					break;
				case 0x50:
					epgTableInfoBean.setType(EIT_TYPE.S);
					break;
				case 0x51:
					epgTableInfoBean.setType(EIT_TYPE.S);
					break;
				default:
					break;
				}

				epgTableInfoBean.setEventId(eitInfo.getEventId());
				long[] duringTime = eitInfo.getDuration();
				String strDuringTime = String.format("%02x:%02x:%02x", duringTime[0], duringTime[1], duringTime[2]);
				epgTableInfoBean.setDuringTime(strDuringTime);

				// TODO ��Ҫ��ʱ��ƫ�ƴ���,���������޸�Ϊ�����أ�
				long[] startTime = eitInfo.getStartTimeArray();
				String strStartTime = String.format("%s %02x:%02x:%02x",
						TS_Utils.mjd2Utc(startTime[0] * 16 * 16 + startTime[1]), startTime[2], startTime[3],
						startTime[4]);
				epgTableInfoBean.setStartTime(strStartTime);
				epgTableInfoBean.setEndTime(TS_Utils.addTime2Time(strStartTime, strDuringTime));
				for (Descriptor d : eitInfo.getDescriptorArray()) {
					if (d instanceof ShortEventDescriptor) {
						if (((ShortEventDescriptor) d).getEventNameChar() != null) {
							epgTableInfoBean.setProgramTitle(new String(((ShortEventDescriptor) d).getEventNameChar()));
						}
						if (((ShortEventDescriptor) d).getTextChar() != null) {
							epgTableInfoBean.setBriefIntroduction(String.format("(%s) %s",
									new String(
											((ShortEventDescriptor) d).getIso_639_LanguageCode().getPrivateDateByte()),
									new String(((ShortEventDescriptor) d).getTextChar())));
						}
					} else if (d instanceof ContentDescriptor) {
						ContentInfo[] contentInfos = ((ContentDescriptor) d).getContentInfoArray();
						String strProgramType = "";
						for (ContentInfo contentInfo : contentInfos) {
							strProgramType += ContentNibbleLevelMap.contentNibbleLevel1Map.getOrDefault(
									contentInfo.getContentNibbleLevel1(), "Reserved for future use") + ";";
						}
						epgTableInfoBean.setProgramType(strProgramType);
					} else if (d instanceof ParentalRatingDescriptor) {
						ParentalRatingInfo[] parentalRatingInfos = ((ParentalRatingDescriptor) d)
								.getParentalRatingInfoArray();
						if (parentalRatingInfos != null && parentalRatingInfos.length > 0) {
							String strParentalRatingInfo = "";
							for (ParentalRatingInfo parentalRatingInfo : parentalRatingInfos) {
								long ratingValue = parentalRatingInfo.getRating();
								if (ratingValue <= 0x0f && ratingValue > 0) {
									strParentalRatingInfo += String.format("%d�꣨%s��;", ratingValue + 3,
											new String(parentalRatingInfo.getCountryCode()));
								} else if (ratingValue == 0) {
									// strParentalRatingInfo += "undefined;";
								} else if (ratingValue > 0x0f && ratingValue <= 0xff) {
									strParentalRatingInfo += String.format("%d(defined by the broadcaster)��%s��;",
											ratingValue, new String(parentalRatingInfo.getCountryCode()));
								}
							}
							if (!strParentalRatingInfo.equals("")) {
								epgTableInfoBean.setProgramRating(
										strParentalRatingInfo.substring(0, strParentalRatingInfo.length() - 1));
							}
						}
					}
				}
				EpgTableInfoList.getInstance().getEpgTableInfolist().add(epgTableInfoBean);
			}
		}
	}
}
