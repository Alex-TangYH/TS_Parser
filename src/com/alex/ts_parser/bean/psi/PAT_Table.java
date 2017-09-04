package com.alex.ts_parser.bean.psi;

public class PAT_Table {
	private int uiTable_id;
	private int uiSection_syntax_indicator;
	private int uiZero;
	private int uiReserved_first;
	private int uiSection_length;
	private int uiTransport_stream_id;
	private int uiReserved_second;
	private int uiVersion_number;
	private int uiCurrent_next_indicator;
	private int uiSection_number;
	private int uiLast_section_number;
	PAT_ProgramInfo patProgramInfo[];
	private int uiNetwork_PID;
	private long uiCRC_32;

	public PAT_Table(int uiTable_id, int uiSection_syntax_indicator, int uiZero, int uiReserved_first,
			int uiSection_length, int uiTransport_stream_id, int uiReserved_second, int uiVersion_number,
			int uiCurrent_next_indicator, int uiSection_number, int uiLast_section_number,
			PAT_ProgramInfo[] patProgramInfo, int uiNetwork_PID, long uiCRC_32) {
		this.uiTable_id = uiTable_id;
		this.uiSection_syntax_indicator = uiSection_syntax_indicator;
		this.uiZero = uiZero;
		this.uiReserved_first = uiReserved_first;
		this.uiSection_length = uiSection_length;
		this.uiTransport_stream_id = uiTransport_stream_id;
		this.uiReserved_second = uiReserved_second;
		this.uiVersion_number = uiVersion_number;
		this.uiCurrent_next_indicator = uiCurrent_next_indicator;
		this.uiSection_number = uiSection_number;
		this.uiLast_section_number = uiLast_section_number;
		this.patProgramInfo = patProgramInfo;
		this.uiNetwork_PID = uiNetwork_PID;
		this.uiCRC_32 = uiCRC_32;
	}

	@Override
	public String toString() {
		return "PAT_Table [uiTable_id=" + uiTable_id + ", uiSection_syntax_indicator=" + uiSection_syntax_indicator
				+ ", uiZero=" + uiZero + ", uiReserved_first=" + uiReserved_first + ", uiSection_length="
				+ uiSection_length + ", uiTransport_stream_id=" + uiTransport_stream_id + ", uiReserved_second="
				+ uiReserved_second + ", uiVersion_number=" + uiVersion_number + ", uiCurrent_next_indicator="
				+ uiCurrent_next_indicator + ", uiSection_number=" + uiSection_number + ", uiLast_section_number="
				+ uiLast_section_number + ", patProgramInfo=" + patProgramInfo[0].toString() + ", uiNetwork_PID=" + uiNetwork_PID
				+ ", uiCRC_32=" + uiCRC_32 + "]";
	}
	
}

class PAT_ProgramInfo {
	private int uiProgram_number;
	private int uiReserved;
	private int uiProgram_map_PID;
	public PAT_ProgramInfo(int uiProgram_number, int uiReserved, int uiProgram_map_PID) {
		this.uiProgram_number = uiProgram_number;
		this.uiReserved = uiReserved;
		this.uiProgram_map_PID = uiProgram_map_PID;
	}
	@Override
	public String toString() {
		return "PAT_ProgramInfo [uiProgram_number=" + uiProgram_number + ", uiReserved=" + uiReserved
				+ ", uiProgram_map_PID=" + uiProgram_map_PID + "]";
	}
}