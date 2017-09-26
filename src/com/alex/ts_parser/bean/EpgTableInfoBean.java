package com.alex.ts_parser.bean;

public class EpgTableInfoBean {
	private int eventId;//事件ID
	private String startTime;//开始时间（本地）
	private String duringTime;//持续时间
	private String endTime;//结束时间
	private String programTitle;//节目段标题
	private String programType;//节目类型
	private int programRating;//分级
	private String briefIntroduction;//简介
	private String detailedIntroduction;//详介
	
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
