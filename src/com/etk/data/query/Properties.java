package com.etk.data.query;

public class Properties {
	private int limit;
	private int offset;
	private boolean label;
	private String entitySuperClass;
	private int depthFrom;
	private int depthTo;

	public Properties(int limit, int offset, boolean label,
			String entitySuperClass, int depthFrom, int depthTo) {
		super();
		this.limit = limit;
		this.offset = offset;
		this.label = label;
		this.entitySuperClass = entitySuperClass;
		this.depthFrom = depthFrom;
		this.depthTo = depthTo;
	}
	
	public Properties(){
		this(0, 0, false, null, 1, 1);
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

	public String getEntitySuperClass() {
		return entitySuperClass;
	}

	public void setEntitySuperClass(String entitySuperClass) {
		this.entitySuperClass = entitySuperClass;
	}

	public int getDepthFrom() {
		return depthFrom;
	}

	public void setDepthFrom(int depthFrom) {
		this.depthFrom = depthFrom;
	}

	public int getDepthTo() {
		return depthTo;
	}

	public void setDepthTo(int depthTo) {
		this.depthTo = depthTo;
	}
	
	

}
