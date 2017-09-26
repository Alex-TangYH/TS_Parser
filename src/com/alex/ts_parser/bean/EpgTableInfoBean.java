package com.alex.ts_parser.bean;

public class EpgTableInfoBean {
	private int eventId;//�¼�ID
	private String startTime;//��ʼʱ�䣨���أ�
	private String duringTime;//����ʱ��
	private String endTime;//����ʱ��
	private String programTitle;//��Ŀ�α���
	private String programType;//��Ŀ����
	private int programRating;//�ּ�
	private String briefIntroduction;//���
	private String detailedIntroduction;//���
	
	public EpgTableInfoBean(int eventId, String startTime, String duringTime, String endTime, String programTitle,
			String programType, int programRating, String briefIntroduction, String detailedIntroduction) {
		super();
		this.eventId = eventId;
		this.startTime = startTime;
		this.duringTime = duringTime;
		this.endTime = endTime;
		this.programTitle = programTitle;
		this.programType = programType;
		this.programRating = programRating;
		this.briefIntroduction = briefIntroduction;
		this.detailedIntroduction = detailedIntroduction;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getDuringTime() {
		return duringTime;
	}
	public void setDuringTime(String duringTime) {
		this.duringTime = duringTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getProgramTitle() {
		return programTitle;
	}
	public void setProgramTitle(String programTitle) {
		this.programTitle = programTitle;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public int getProgramRating() {
		return programRating;
	}
	public void setProgramRating(int programRating) {
		this.programRating = programRating;
	}
	public String getBriefIntroduction() {
		return briefIntroduction;
	}
	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}
	public String getDetailedIntroduction() {
		return detailedIntroduction;
	}
	public void setDetailedIntroduction(String detailedIntroduction) {
		this.detailedIntroduction = detailedIntroduction;
	}
}
