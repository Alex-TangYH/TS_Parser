package com.alex.ts_parser.bean;

public class EpgTableInfoBean {
	public enum EIT_TYPE {
	     P, F, S  
	}
	
	private long serviceId;//节目号
	private int eventId;//事件ID
	private String startTime;//开始时间（本地）
	private String duringTime;//持续时间
	private String endTime;//结束时间
	private String programTitle;//节目段标题
	private String programType;//节目类型
	private String programRating;//分级
	private String briefIntroduction;//简介
	private String detailedIntroduction;//详介
	private EIT_TYPE type;
	
	public EpgTableInfoBean(long serviceId, int eventId, String startTime, String duringTime, String endTime,
			String programTitle, String programType, String programRating, String briefIntroduction,
			String detailedIntroduction, EIT_TYPE type) {
		super();
		this.serviceId = serviceId;
		this.eventId = eventId;
		this.startTime = startTime;
		this.duringTime = duringTime;
		this.endTime = endTime;
		this.programTitle = programTitle;
		this.programType = programType;
		this.programRating = programRating;
		this.briefIntroduction = briefIntroduction;
		this.detailedIntroduction = detailedIntroduction;
		this.type = type;
	}
	
	public EpgTableInfoBean() {
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
	public String getProgramRating() {
		return programRating;
	}
	public void setProgramRating(String programRating) {
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
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public EIT_TYPE getType() {
		return type;
	}
	public void setType(EIT_TYPE type) {
		this.type = type;
	}
}
