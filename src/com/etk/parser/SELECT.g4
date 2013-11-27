grammar SELECT;

selectStmnt :
	'SELECT' querySpecification ;
querySpecification:
	(setQuantifier)? selectList tableExpression ;
setQuantifier :
	'DISTINCT'
	| 'ALL' ;

selectList:
	'*'
	| derivedColumn (',' derivedColumn)* ;

derivedColumn:
	columnName (asClause)? ;

asClause:
	'AS' columnName ;

tableExpression :
	 fromClause
	// (whereClause)?
    // (groupByClause)? (havingClause)?
    // (windowClause)?
    ;

fromClause :
	'FROM' tablePrimary (',' tablePrimary)*  ;

tablePrimary :
      tableName ('AS' tablePrimaryAs)? ;

tablePrimaryAs :
      tableName ( '(' derivedColumnList ')' )?   ;

derivedColumnList :
	columnName (',' columnName)* ;

whereClause :
	'WHERE' searchCondition;

searchCondition:
	booleanValueExpression ;

booleanValueExpression:
	booleanTerm
	| booleanValueExpression 'OR' booleanTerm ;


booleanTerm :
	booleanFactor
 	| booleanTerm 'AND' booleanFactor ;

booleanFactor :
    ('NOT')? booleanTest ;

booleanTest :
    booleanPrimary ('IS' ('NOT')? truthValue)? ;

truthValue :
	'TRUE'
	| 'FALSE'
	| 'UNKNOWN' ;

booleanPrimary :
	//predicate
	 booleanPredicand ;

booleanPredicand :
	parenthizedBooleanValueExpression
	;

parenthizedBooleanValueExpression :
    '(' booleanValueExpression ')' ;




columnName:  ID;
tableName: ID;
ID : ID_LETTER (ID_LETTER | DIGIT)* ;
fragment ID_LETTER : 'a'..'z'|'A'..'Z'|'_' ;
fragment DIGIT : '0'..'9' ;
WS : [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out


