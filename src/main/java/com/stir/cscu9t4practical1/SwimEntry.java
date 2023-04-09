package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

	private String where;

	public SwimEntry(String getWhere, int d, int m, int y, int h, int min, int s, float dist, String n) {

		super(n, d, m, y, h, min, s, dist);
		this.where = where;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
}