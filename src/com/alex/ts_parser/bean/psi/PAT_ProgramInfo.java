package com.alex.ts_parser.bean.psi;

public class PAT_ProgramInfo {
	private int programNumber;
	private int reserved;
	private int programMapPID;

	public PAT_ProgramInfo(int programNumber, int reserved, int programMapPID) {
		super();
		this.programNumber = programNumber;
		this.reserved = reserved;
		this.programMapPID = programMapPID;
	}

	public int getProgramNumber() {
		return programNumber;
	}

	public void setProgramNumber(int programNumber) {
		this.programNumber = programNumber;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getProgramMapPID() {
		return programMapPID;
	}

	public void setProgramMapPID(int programMapPID) {
		this.programMapPID = programMapPID;
	}

	@Override
	public String toString() {
		return "PAT_ProgramInfo [programNumber=" + programNumber + ", reserved=" + reserved + ", programMapPID="
				+ programMapPID + "]";
	}
}
