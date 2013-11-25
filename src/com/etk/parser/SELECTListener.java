package com.etk.parser;

// Generated from C:\Users\Georgy\IdeaProjects\SELECTParser\src\SELECT.g4 by ANTLR 4.1
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
	 * Enter a parse tree produced by {@link SELECTParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void enterTableReference(@NotNull SELECTParser.TableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void exitTableReference(@NotNull SELECTParser.TableReferenceContext ctx);

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
	 * Enter a parse tree produced by {@link SELECTParser#derivedColumn}.
	 * @param ctx the parse tree
	 */
	void enterDerivedColumn(@NotNull SELECTParser.DerivedColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#derivedColumn}.
	 * @param ctx the parse tree
	 */
	void exitDerivedColumn(@NotNull SELECTParser.DerivedColumnContext ctx);

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
	 * Enter a parse tree produced by {@link SELECTParser#tableReferenceList}.
	 * @param ctx the parse tree
	 */
	void enterTableReferenceList(@NotNull SELECTParser.TableReferenceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#tableReferenceList}.
	 * @param ctx the parse tree
	 */
	void exitTableReferenceList(@NotNull SELECTParser.TableReferenceListContext ctx);

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
	 * Enter a parse tree produced by {@link SELECTParser#parenthizedBooleanValueExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthizedBooleanValueExpression(@NotNull SELECTParser.ParenthizedBooleanValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SELECTParser#parenthizedBooleanValueExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthizedBooleanValueExpression(@NotNull SELECTParser.ParenthizedBooleanValueExpressionContext ctx);

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