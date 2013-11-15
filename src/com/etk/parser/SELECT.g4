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
	COLUMNNAME (asClause)? ;

asClause:
	'AS' COLUMNNAME ;

tableExpression :
	 fromClause
	// (whereClause)?
    // (groupByClause)? (havingClause)?
    // (windowClause)?
    ;

fromClause :
	'FROM' tableReferenceList ;

tableReferenceList :
	tableReference (','tableReference)* ;

tableReference :
    tablePrimary ;


tablePrimary :
      TABLENAME (('AS')? TABLENAME
      ( '(' derivedColumnList ')' )? )?;

derivedColumnList :
	COLUMNNAME (( ',' COLUMNNAME)+)? ;

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




COLUMNNAME:  ID ;
TABLENAME: ID ;
ID : ID_LETTER(ID_LETTER | DIGIT)*;
ID_LETTER : [a_zA_Z] | '_' ;
fragment DIGIT : [0-9] ;

