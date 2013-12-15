package com.etk.data.query;

public class OperatorMapping {
	public static String getOperator( Operator o ){
		switch (o) {
		case EQ:
			return " = ";
		case GT:
			return " > ";
		case LT:
			return " < ";
		case GE:
			return " >= ";
		case LE:
			return " <= ";
		case AND:
			return " && ";
		case OR:
			return " || ";
			
		default:
			return "";
		}
	}
}
