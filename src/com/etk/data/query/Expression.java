package com.etk.data.query;

import java.util.List;

public class Expression {
	private Operator operator;
	List<SelectionClause> clauses;
	
	public Expression(Operator oper, List<SelectionClause> clauses) {
		this.operator = oper;
		this.clauses = clauses;
	}
	
	public Operator getOperator() {
		return operator;
	}
	public List<SelectionClause> getClauses() {
		return clauses;
	}
	
	

}
