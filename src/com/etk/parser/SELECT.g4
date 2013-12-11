grammar SELECT;

selectStmnt :
	'SELECT' querySpecification ;
querySpecification:
	(setQuantifier)? selectList tableExpression (resultExpression)? ;
setQuantifier :
	'DISTINCT'
	| 'ALL' ;

selectList:
	'*'
	| column (',' column)* ;

column:
    columnInTable
    | freeColumn;

columnInTable:
    tableName'.'columnName;
freeColumn:
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
	 booleanPredicand ;

booleanPredicand:
     parenthesizedBoolValueExpr
     ;

parenthesizedBoolValueExpr :
    '(' booleanValueExpression ')' ;

resultExpression:
    joinClause;

joinClause:
    crossJoin
    | qualifiedJoin
    | naturalJoin
    | unionJoin;

crossJoin:
    'CROSS JOIN' tableName  ;

qualifiedJoin:
    joinType 'JOIN' tableName joinSpec  ;

naturalJoin:
    'NATURAL' joinType 'JOIN' tableName ;

unionJoin:
    'UNION JOIN' tableName ;

joinType:
    'INNER'
    | outerJoinType ('OUTER')? ;

outerJoinType:
    'LEFT'
    | 'RIGHT'
    | 'FULL' ;

joinSpec:
    joinCondition
    | namedColumnsJoin ;

joinCondition:
    'ON' searchCondition ;

namedColumnsJoin:
    'USING' '(' columnNameList ')' ;

columnNameList:
    columnName (',' columnName)* ;











columnName:  ID;
tableName: ID;
ID : ID_LETTER (ID_LETTER | DIGIT)* ;
fragment ID_LETTER : 'a'..'z'|'A'..'Z'|'_' ;
fragment DIGIT : '0'..'9' ;
WS : [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out


