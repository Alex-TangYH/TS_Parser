package com.alex.ts_parser.native_function;

public class TestClass {
	int i;
	boolean bl;
	char c;
	float f;
	double d;
	byte by;
	short s;
	long l;

	String str;

	public TestClass(int i, boolean bl, char c, float f, double d, byte by, short s, long l, String str) {
		this.i = i;
		this.bl = bl;
		this.c = c;
		this.f = f;
		this.d = d;
		this.by = by;
		this.s = s;
		this.l = l;
		this.str = str;
	}

	@Override
	public String toString() {
		return "TestClass [i=" + i + ", bl=" + bl + ", c=" + c + ", f=" + f + ", d=" + d + ", by=" + by + ", s=" + s
				+ ", l=" + l + ", str=" + str + "]";
	}

}
