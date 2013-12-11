package com.etk.data.query;

public class Properties {
	private int limit;
	private int offset;
	private boolean label;
	
	public Properties(int limit, int offset, boolean label) {
		this.offset = offset;
		this.limit = limit;
		this.label = label;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public boolean isLabel() {
		return label;
	}

	public void setLabel(boolean label) {
		this.label = label;
	}
	
	

}
