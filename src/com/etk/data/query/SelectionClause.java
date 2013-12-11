package com.etk.data.query;

public class SelectionClause {
	private String attribute;
	private Operator operator;
	private Object value;
	private boolean negated;
	
	public SelectionClause(String attribute, Operator oper, Object value, boolean negated)  {
		this.attribute = attribute;
		this.operator = oper;
		this.value = value;
		this.negated = negated;
	}

	public String getAttribute() {
		return attribute;
	}
	
	public Operator getOperator() {
		return operator;
	}

	public Object getValue() {
		return value;
	}
	
	
}
