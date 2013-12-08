package com.etk.parser;// Generated from C:\Users\Georgy\IdeaProjects\SELECTParser\src\SELECT.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SELECTParser}.
 */
public interface SELECTListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SELECTParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(@NotNull SELECTParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(@NotNull SELECTParser.WhereClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#columnNameList}.
	 * @param ctx the parse tree
	 */
	void enterColumnNameList(@NotNull SELECTParser.ColumnNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#columnNameList}.
	 * @param ctx the parse tree
	 */
	void exitColumnNameList(@NotNull SELECTParser.ColumnNameListContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#tableExpression}.
	 * @param ctx the parse tree
	 */
	void enterTableExpression(@NotNull SELECTParser.TableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#tableExpression}.
	 * @param ctx the parse tree
	 */
	void exitTableExpression(@NotNull SELECTParser.TableExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#truthValue}.
	 * @param ctx the parse tree
	 */
	void enterTruthValue(@NotNull SELECTParser.TruthValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#truthValue}.
	 * @param ctx the parse tree
	 */
	void exitTruthValue(@NotNull SELECTParser.TruthValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#namedColumnsJoin}.
	 * @param ctx the parse tree
	 */
	void enterNamedColumnsJoin(@NotNull SELECTParser.NamedColumnsJoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#namedColumnsJoin}.
	 * @param ctx the parse tree
	 */
	void exitNamedColumnsJoin(@NotNull SELECTParser.NamedColumnsJoinContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#joinCondition}.
	 * @param ctx the parse tree
	 */
	void enterJoinCondition(@NotNull SELECTParser.JoinConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#joinCondition}.
	 * @param ctx the parse tree
	 */
	void exitJoinCondition(@NotNull SELECTParser.JoinConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#selectList}.
	 * @param ctx the parse tree
	 */
	void enterSelectList(@NotNull SELECTParser.SelectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#selectList}.
	 * @param ctx the parse tree
	 */
	void exitSelectList(@NotNull SELECTParser.SelectListContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(@NotNull SELECTParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(@NotNull SELECTParser.QuerySpecificationContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#booleanTerm}.
	 * @param ctx the parse tree
	 */
	void enterBooleanTerm(@NotNull SELECTParser.BooleanTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#booleanTerm}.
	 * @param ctx the parse tree
	 */
	void exitBooleanTerm(@NotNull SELECTParser.BooleanTermContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#booleanPredicand}.
	 * @param ctx the parse tree
	 */
	void enterBooleanPredicand(@NotNull SELECTParser.BooleanPredicandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#booleanPredicand}.
	 * @param ctx the parse tree
	 */
	void exitBooleanPredicand(@NotNull SELECTParser.BooleanPredicandContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#unionJoin}.
	 * @param ctx the parse tree
	 */
	void enterUnionJoin(@NotNull SELECTParser.UnionJoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#unionJoin}.
	 * @param ctx the parse tree
	 */
	void exitUnionJoin(@NotNull SELECTParser.UnionJoinContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#booleanPrimary}.
	 * @param ctx the parse tree
	 */
	void enterBooleanPrimary(@NotNull SELECTParser.BooleanPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#booleanPrimary}.
	 * @param ctx the parse tree
	 */
	void exitBooleanPrimary(@NotNull SELECTParser.BooleanPrimaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#derivedColumnList}.
	 * @param ctx the parse tree
	 */
	void enterDerivedColumnList(@NotNull SELECTParser.DerivedColumnListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#derivedColumnList}.
	 * @param ctx the parse tree
	 */
	void exitDerivedColumnList(@NotNull SELECTParser.DerivedColumnListContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantifier(@NotNull SELECTParser.SetQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantifier(@NotNull SELECTParser.SetQuantifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(@NotNull SELECTParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(@NotNull SELECTParser.TableNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#searchCondition}.
	 * @param ctx the parse tree
	 */
	void enterSearchCondition(@NotNull SELECTParser.SearchConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#searchCondition}.
	 * @param ctx the parse tree
	 */
	void exitSearchCondition(@NotNull SELECTParser.SearchConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(@NotNull SELECTParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(@NotNull SELECTParser.ColumnNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#crossJoin}.
	 * @param ctx the parse tree
	 */
	void enterCrossJoin(@NotNull SELECTParser.CrossJoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#crossJoin}.
	 * @param ctx the parse tree
	 */
	void exitCrossJoin(@NotNull SELECTParser.CrossJoinContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#selectStmnt}.
	 * @param ctx the parse tree
	 */
	void enterSelectStmnt(@NotNull SELECTParser.SelectStmntContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#selectStmnt}.
	 * @param ctx the parse tree
	 */
	void exitSelectStmnt(@NotNull SELECTParser.SelectStmntContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#columnInTable}.
	 * @param ctx the parse tree
	 */
	void enterColumnInTable(@NotNull SELECTParser.ColumnInTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#columnInTable}.
	 * @param ctx the parse tree
	 */
	void exitColumnInTable(@NotNull SELECTParser.ColumnInTableContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#joinSpec}.
	 * @param ctx the parse tree
	 */
	void enterJoinSpec(@NotNull SELECTParser.JoinSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#joinSpec}.
	 * @param ctx the parse tree
	 */
	void exitJoinSpec(@NotNull SELECTParser.JoinSpecContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#booleanTest}.
	 * @param ctx the parse tree
	 */
	void enterBooleanTest(@NotNull SELECTParser.BooleanTestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#booleanTest}.
	 * @param ctx the parse tree
	 */
	void exitBooleanTest(@NotNull SELECTParser.BooleanTestContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#parenthesizedBoolValueExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedBoolValueExpr(@NotNull SELECTParser.ParenthesizedBoolValueExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#parenthesizedBoolValueExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedBoolValueExpr(@NotNull SELECTParser.ParenthesizedBoolValueExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#tablePrimary}.
	 * @param ctx the parse tree
	 */
	void enterTablePrimary(@NotNull SELECTParser.TablePrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#tablePrimary}.
	 * @param ctx the parse tree
	 */
	void exitTablePrimary(@NotNull SELECTParser.TablePrimaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#freeColumn}.
	 * @param ctx the parse tree
	 */
	void enterFreeColumn(@NotNull SELECTParser.FreeColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#freeColumn}.
	 * @param ctx the parse tree
	 */
	void exitFreeColumn(@NotNull SELECTParser.FreeColumnContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#booleanValueExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValueExpression(@NotNull SELECTParser.BooleanValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#booleanValueExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValueExpression(@NotNull SELECTParser.BooleanValueExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(@NotNull SELECTParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(@NotNull SELECTParser.JoinClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#resultExpression}.
	 * @param ctx the parse tree
	 */
	void enterResultExpression(@NotNull SELECTParser.ResultExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#resultExpression}.
	 * @param ctx the parse tree
	 */
	void exitResultExpression(@NotNull SELECTParser.ResultExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#tablePrimaryAs}.
	 * @param ctx the parse tree
	 */
	void enterTablePrimaryAs(@NotNull SELECTParser.TablePrimaryAsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#tablePrimaryAs}.
	 * @param ctx the parse tree
	 */
	void exitTablePrimaryAs(@NotNull SELECTParser.TablePrimaryAsContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#naturalJoin}.
	 * @param ctx the parse tree
	 */
	void enterNaturalJoin(@NotNull SELECTParser.NaturalJoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#naturalJoin}.
	 * @param ctx the parse tree
	 */
	void exitNaturalJoin(@NotNull SELECTParser.NaturalJoinContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(@NotNull SELECTParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(@NotNull SELECTParser.ColumnContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#qualifiedJoin}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedJoin(@NotNull SELECTParser.QualifiedJoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#qualifiedJoin}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedJoin(@NotNull SELECTParser.QualifiedJoinContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#asClause}.
	 * @param ctx the parse tree
	 */
	void enterAsClause(@NotNull SELECTParser.AsClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#asClause}.
	 * @param ctx the parse tree
	 */
	void exitAsClause(@NotNull SELECTParser.AsClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#booleanFactor}.
	 * @param ctx the parse tree
	 */
	void enterBooleanFactor(@NotNull SELECTParser.BooleanFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#booleanFactor}.
	 * @param ctx the parse tree
	 */
	void exitBooleanFactor(@NotNull SELECTParser.BooleanFactorContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(@NotNull SELECTParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(@NotNull SELECTParser.JoinTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#outerJoinType}.
	 * @param ctx the parse tree
	 */
	void enterOuterJoinType(@NotNull SELECTParser.OuterJoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#outerJoinType}.
	 * @param ctx the parse tree
	 */
	void exitOuterJoinType(@NotNull SELECTParser.OuterJoinTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link SELECTParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(@NotNull SELECTParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(@NotNull SELECTParser.FromClauseContext ctx);
}