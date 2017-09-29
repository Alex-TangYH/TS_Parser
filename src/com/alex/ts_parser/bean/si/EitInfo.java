package com.alex.ts_parser.bean.si;

import com.alex.ts_parser.bean.descriptor.Descriptor;
import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class EitInfo{
	private int eventId;
	private long[] startTimeArray;
	private long[] duration;
	private int runningStatus;
	private int freeCaMode;
	private int descriptorsLoopLength;
	private Descriptor[] descriptorArray;
	public EitInfo(int eventId, int[] startTimeArray, int[] duration, int runningStatus, int freeCaMode,
			int descriptorsLoopLength, Descriptor[] descriptorArray) {
		super();
		this.eventId = eventId;
		this.startTimeArray = CTypeFormat2JavaType.getUnsignedIntArray2LongArray(startTimeArray);
		this.duration = CTypeFormat2JavaType.getUnsignedIntArray2LongArray(duration);
		this.runningStatus = runningStatus;
		this.freeCaMode = freeCaMode;
		this.descriptorsLoopLength = descriptorsLoopLength;
		this.descriptorArray = descriptorArray;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public long[] getStartTimeArray() {
		return startTimeArray;
	}
	public void setStartTimeArray(long[] startTimeArray) {
		this.startTimeArray = startTimeArray;
	}
	public long[] getDuration() {
		return duration;
	}
	public void setDuration(long[] duration) {
		this.duration = duration;
	}
	public int getRunningStatus() {
		return runningStatus;
	}
	public void setRunningStatus(int runningStatus) {
		this.runningStatus = runningStatus;
	}
	public int getFreeCaMode() {
		return freeCaMode;
	}
	public void setFreeCaMode(int freeCaMode) {
		this.freeCaMode = freeCaMode;
	}
	public int getDescriptorsLoopLength() {
		return descriptorsLoopLength;
	}
	public void setDescriptorsLoopLength(int descriptorsLoopLength) {
		this.descriptorsLoopLength = descriptorsLoopLength;
	}
	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}
	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}
}
