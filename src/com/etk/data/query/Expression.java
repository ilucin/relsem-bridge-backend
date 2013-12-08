package com.etk.data.query;

import java.util.List;

public class Expression {
	private boolean negated;
	private Operator operator;
	List<SelectionClause> clauses;
	
	
	public boolean isNegated() {
		return negated;
	}
	public Operator getOperator() {
		return operator;
	}
	public List<SelectionClause> getClauses() {
		return clauses;
	}
	
	

}
