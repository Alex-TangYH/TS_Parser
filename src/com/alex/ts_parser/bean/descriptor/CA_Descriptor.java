package com.alex.ts_parser.bean.descriptor;

/**
 * CA������
 * 
 * @author Administrator
 *
 */
public class CA_Descriptor extends Descriptor {
	int descriptorTag;
	int descriptorLength;
	int caSystemId;
	int reserved;
	byte privateDataByte[];
}
