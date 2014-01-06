package com.etk.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SELECTParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__28=1, T__27=2, T__26=3, T__25=4, T__24=5, T__23=6, T__22=7, T__21=8, 
		T__20=9, T__19=10, T__18=11, T__17=12, T__16=13, T__15=14, T__14=15, T__13=16, 
		T__12=17, T__11=18, T__10=19, T__9=20, T__8=21, T__7=22, T__6=23, T__5=24, 
		T__4=25, T__3=26, T__2=27, T__1=28, T__0=29, ID=30, WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "'CROSS JOIN'", "'DISTINCT'", "'ALL'", "','", "'RIGHT'", 
		"'*'", "'WHERE'", "'('", "'AS'", "'FULL'", "'OR'", "'TRUE'", "'JOIN'", 
		"'UNION JOIN'", "'FALSE'", "'AND'", "'USING'", "'INNER'", "'NATURAL'", 
		"'.'", "')'", "'LEFT'", "'UNKNOWN'", "'ON'", "'IS'", "'OUTER'", "'FROM'", 
		"'NOT'", "'SELECT'", "ID", "WS"
	};
	public static final int
		RULE_selectStmnt = 0, RULE_querySpecification = 1, RULE_setQuantifier = 2, 
		RULE_selectList = 3, RULE_column = 4, RULE_columnInTable = 5, RULE_freeColumn = 6, 
		RULE_asClause = 7, RULE_tableExpression = 8, RULE_fromClause = 9, RULE_tablePrimary = 10, 
		RULE_tablePrimaryAs = 11, RULE_derivedColumnList = 12, RULE_whereClause = 13, 
		RULE_searchCondition = 14, RULE_booleanValueExpression = 15, RULE_booleanTerm = 16, 
		RULE_booleanFactor = 17, RULE_booleanTest = 18, RULE_truthValue = 19, 
		RULE_booleanPrimary = 20, RULE_booleanPredicand = 21, RULE_parenthesizedBoolValueExpr = 22, 
		RULE_resultExpression = 23, RULE_joinClause = 24, RULE_crossJoin = 25, 
		RULE_qualifiedJoin = 26, RULE_naturalJoin = 27, RULE_unionJoin = 28, RULE_joinType = 29, 
		RULE_outerJoinType = 30, RULE_joinSpec = 31, RULE_joinCondition = 32, 
		RULE_namedColumnsJoin = 33, RULE_columnNameList = 34, RULE_columnName = 35, 
		RULE_tableName = 36;
	public static final String[] ruleNames = {
		"selectStmnt", "querySpecification", "setQuantifier", "selectList", "column", 
		"columnInTable", "freeColumn", "asClause", "tableExpression", "fromClause", 
		"tablePrimary", "tablePrimaryAs", "derivedColumnList", "whereClause", 
		"searchCondition", "booleanValueExpression", "booleanTerm", "booleanFactor", 
		"booleanTest", "truthValue", "booleanPrimary", "booleanPredicand", "parenthesizedBoolValueExpr", 
		"resultExpression", "joinClause", "crossJoin", "qualifiedJoin", "naturalJoin", 
		"unionJoin", "joinType", "outerJoinType", "joinSpec", "joinCondition", 
		"namedColumnsJoin", "columnNameList", "columnName", "tableName"
	};

	@Override
	public String getGrammarFileName() { return "SELECT.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public SELECTParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SelectStmntContext extends ParserRuleContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public SelectStmntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStmnt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterSelectStmnt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitSelectStmnt(this);
		}
	}

	public final SelectStmntContext selectStmnt() throws RecognitionException {
		SelectStmntContext _localctx = new SelectStmntContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_selectStmnt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(29);
			setState(75); querySpecification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public ResultExpressionContext resultExpression() {
			return getRuleContext(ResultExpressionContext.class,0);
		}
		public SelectListContext selectList() {
			return getRuleContext(SelectListContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public TableExpressionContext tableExpression() {
			return getRuleContext(TableExpressionContext.class,0);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitQuerySpecification(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if (_la==2 || _la==3) {
				{
				setState(77); setQuantifier();
				}
			}

			setState(80); selectList();
			setState(81); tableExpression();
			setState(83);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 5) | (1L << 10) | (1L << 14) | (1L << 18) | (1L << 19) | (1L << 22))) != 0)) {
				{
				setState(82); resultExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetQuantifierContext extends ParserRuleContext {
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterSetQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitSetQuantifier(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if ( !(_la==2 || _la==3) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectListContext extends ParserRuleContext {
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public SelectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterSelectList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitSelectList(this);
		}
	}

	public final SelectListContext selectList() throws RecognitionException {
		SelectListContext _localctx = new SelectListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectList);
		int _la;
		try {
			setState(96);
			switch (_input.LA(1)) {
			case 6:
				enterOuterAlt(_localctx, 1);
				{
				setState(87); match(6);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(88); column();
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(89); match(4);
					setState(90); column();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnContext extends ParserRuleContext {
		public ColumnInTableContext columnInTable() {
			return getRuleContext(ColumnInTableContext.class,0);
		}
		public FreeColumnContext freeColumn() {
			return getRuleContext(FreeColumnContext.class,0);
		}
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitColumn(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_column);
		try {
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98); columnInTable();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99); freeColumn();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnInTableContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnInTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnInTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterColumnInTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitColumnInTable(this);
		}
	}

	public final ColumnInTableContext columnInTable() throws RecognitionException {
		ColumnInTableContext _localctx = new ColumnInTableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_columnInTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); tableName();
			setState(103); match(20);
			setState(104); columnName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FreeColumnContext extends ParserRuleContext {
		public AsClauseContext asClause() {
			return getRuleContext(AsClauseContext.class,0);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public FreeColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_freeColumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterFreeColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitFreeColumn(this);
		}
	}

	public final FreeColumnContext freeColumn() throws RecognitionException {
		FreeColumnContext _localctx = new FreeColumnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_freeColumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); columnName();
			setState(108);
			_la = _input.LA(1);
			if (_la==9) {
				{
				setState(107); asClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsClauseContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public AsClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterAsClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitAsClause(this);
		}
	}

	public final AsClauseContext asClause() throws RecognitionException {
		AsClauseContext _localctx = new AsClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_asClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(9);
			setState(111); columnName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableExpressionContext extends ParserRuleContext {
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterTableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitTableExpression(this);
		}
	}

	public final TableExpressionContext tableExpression() throws RecognitionException {
		TableExpressionContext _localctx = new TableExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); fromClause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClauseContext extends ParserRuleContext {
		public List<TablePrimaryContext> tablePrimary() {
			return getRuleContexts(TablePrimaryContext.class);
		}
		public TablePrimaryContext tablePrimary(int i) {
			return getRuleContext(TablePrimaryContext.class,i);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitFromClause(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(27);
			setState(116); tablePrimary();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(117); match(4);
				setState(118); tablePrimary();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePrimaryContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TablePrimaryAsContext tablePrimaryAs() {
			return getRuleContext(TablePrimaryAsContext.class,0);
		}
		public TablePrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterTablePrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitTablePrimary(this);
		}
	}

	public final TablePrimaryContext tablePrimary() throws RecognitionException {
		TablePrimaryContext _localctx = new TablePrimaryContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tablePrimary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); tableName();
			setState(127);
			_la = _input.LA(1);
			if (_la==9) {
				{
				setState(125); match(9);
				setState(126); tablePrimaryAs();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePrimaryAsContext extends ParserRuleContext {
		public DerivedColumnListContext derivedColumnList() {
			return getRuleContext(DerivedColumnListContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TablePrimaryAsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePrimaryAs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterTablePrimaryAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitTablePrimaryAs(this);
		}
	}

	public final TablePrimaryAsContext tablePrimaryAs() throws RecognitionException {
		TablePrimaryAsContext _localctx = new TablePrimaryAsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tablePrimaryAs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); tableName();
			setState(134);
			_la = _input.LA(1);
			if (_la==8) {
				{
				setState(130); match(8);
				setState(131); derivedColumnList();
				setState(132); match(21);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DerivedColumnListContext extends ParserRuleContext {
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public DerivedColumnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derivedColumnList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterDerivedColumnList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitDerivedColumnList(this);
		}
	}

	public final DerivedColumnListContext derivedColumnList() throws RecognitionException {
		DerivedColumnListContext _localctx = new DerivedColumnListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_derivedColumnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); columnName();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(137); match(4);
				setState(138); columnName();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public SearchConditionContext searchCondition() {
			return getRuleContext(SearchConditionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); match(7);
			setState(145); searchCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SearchConditionContext extends ParserRuleContext {
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public SearchConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterSearchCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitSearchCondition(this);
		}
	}

	public final SearchConditionContext searchCondition() throws RecognitionException {
		SearchConditionContext _localctx = new SearchConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_searchCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); booleanValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueExpressionContext extends ParserRuleContext {
		public int _p;
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public BooleanTermContext booleanTerm() {
			return getRuleContext(BooleanTermContext.class,0);
		}
		public BooleanValueExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BooleanValueExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_booleanValueExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterBooleanValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitBooleanValueExpression(this);
		}
	}

	public final BooleanValueExpressionContext booleanValueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanValueExpressionContext _localctx = new BooleanValueExpressionContext(_ctx, _parentState, _p);
		BooleanValueExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, RULE_booleanValueExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(150); booleanTerm(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanValueExpressionContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_booleanValueExpression);
					setState(152);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(153); match(11);
					setState(154); booleanTerm(0);
					}
					} 
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BooleanTermContext extends ParserRuleContext {
		public int _p;
		public BooleanFactorContext booleanFactor() {
			return getRuleContext(BooleanFactorContext.class,0);
		}
		public BooleanTermContext booleanTerm() {
			return getRuleContext(BooleanTermContext.class,0);
		}
		public BooleanTermContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BooleanTermContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_booleanTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterBooleanTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitBooleanTerm(this);
		}
	}

	public final BooleanTermContext booleanTerm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanTermContext _localctx = new BooleanTermContext(_ctx, _parentState, _p);
		BooleanTermContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, RULE_booleanTerm);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(161); booleanFactor();
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanTermContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_booleanTerm);
					setState(163);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(164); match(16);
					setState(165); booleanFactor();
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BooleanFactorContext extends ParserRuleContext {
		public BooleanTestContext booleanTest() {
			return getRuleContext(BooleanTestContext.class,0);
		}
		public BooleanFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterBooleanFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitBooleanFactor(this);
		}
	}

	public final BooleanFactorContext booleanFactor() throws RecognitionException {
		BooleanFactorContext _localctx = new BooleanFactorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_booleanFactor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(171); match(28);
				}
			}

			setState(174); booleanTest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanTestContext extends ParserRuleContext {
		public TruthValueContext truthValue() {
			return getRuleContext(TruthValueContext.class,0);
		}
		public BooleanPrimaryContext booleanPrimary() {
			return getRuleContext(BooleanPrimaryContext.class,0);
		}
		public BooleanTestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanTest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterBooleanTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitBooleanTest(this);
		}
	}

	public final BooleanTestContext booleanTest() throws RecognitionException {
		BooleanTestContext _localctx = new BooleanTestContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_booleanTest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); booleanPrimary();
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(177); match(25);
				setState(179);
				_la = _input.LA(1);
				if (_la==28) {
					{
					setState(178); match(28);
					}
				}

				setState(181); truthValue();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TruthValueContext extends ParserRuleContext {
		public TruthValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truthValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterTruthValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitTruthValue(this);
		}
	}

	public final TruthValueContext truthValue() throws RecognitionException {
		TruthValueContext _localctx = new TruthValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_truthValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 15) | (1L << 23))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanPrimaryContext extends ParserRuleContext {
		public BooleanPredicandContext booleanPredicand() {
			return getRuleContext(BooleanPredicandContext.class,0);
		}
		public BooleanPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterBooleanPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitBooleanPrimary(this);
		}
	}

	public final BooleanPrimaryContext booleanPrimary() throws RecognitionException {
		BooleanPrimaryContext _localctx = new BooleanPrimaryContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_booleanPrimary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); booleanPredicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanPredicandContext extends ParserRuleContext {
		public ParenthesizedBoolValueExprContext parenthesizedBoolValueExpr() {
			return getRuleContext(ParenthesizedBoolValueExprContext.class,0);
		}
		public BooleanPredicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanPredicand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterBooleanPredicand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitBooleanPredicand(this);
		}
	}

	public final BooleanPredicandContext booleanPredicand() throws RecognitionException {
		BooleanPredicandContext _localctx = new BooleanPredicandContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_booleanPredicand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); parenthesizedBoolValueExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParenthesizedBoolValueExprContext extends ParserRuleContext {
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public ParenthesizedBoolValueExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedBoolValueExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterParenthesizedBoolValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitParenthesizedBoolValueExpr(this);
		}
	}

	public final ParenthesizedBoolValueExprContext parenthesizedBoolValueExpr() throws RecognitionException {
		ParenthesizedBoolValueExprContext _localctx = new ParenthesizedBoolValueExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_parenthesizedBoolValueExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); match(8);
			setState(191); booleanValueExpression(0);
			setState(192); match(21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultExpressionContext extends ParserRuleContext {
		public JoinClauseContext joinClause() {
			return getRuleContext(JoinClauseContext.class,0);
		}
		public ResultExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterResultExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitResultExpression(this);
		}
	}

	public final ResultExpressionContext resultExpression() throws RecognitionException {
		ResultExpressionContext _localctx = new ResultExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_resultExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); joinClause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinClauseContext extends ParserRuleContext {
		public QualifiedJoinContext qualifiedJoin() {
			return getRuleContext(QualifiedJoinContext.class,0);
		}
		public CrossJoinContext crossJoin() {
			return getRuleContext(CrossJoinContext.class,0);
		}
		public UnionJoinContext unionJoin() {
			return getRuleContext(UnionJoinContext.class,0);
		}
		public NaturalJoinContext naturalJoin() {
			return getRuleContext(NaturalJoinContext.class,0);
		}
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterJoinClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitJoinClause(this);
		}
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_joinClause);
		try {
			setState(200);
			switch (_input.LA(1)) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196); crossJoin();
				}
				break;
			case 5:
			case 10:
			case 18:
			case 22:
				enterOuterAlt(_localctx, 2);
				{
				setState(197); qualifiedJoin();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 3);
				{
				setState(198); naturalJoin();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 4);
				{
				setState(199); unionJoin();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CrossJoinContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class, 0);
		}
		public CrossJoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crossJoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterCrossJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitCrossJoin(this);
		}
	}

	public final CrossJoinContext crossJoin() throws RecognitionException {
		CrossJoinContext _localctx = new CrossJoinContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_crossJoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(1);
			setState(203); tableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedJoinContext extends ParserRuleContext {
		public JoinSpecContext joinSpec() {
			return getRuleContext(JoinSpecContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class, 0);
		}
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public QualifiedJoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedJoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterQualifiedJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitQualifiedJoin(this);
		}
	}

	public final QualifiedJoinContext qualifiedJoin() throws RecognitionException {
		QualifiedJoinContext _localctx = new QualifiedJoinContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_qualifiedJoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); joinType();
			setState(206); match(13);
			setState(207); tableName();
			setState(208); joinSpec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NaturalJoinContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class, 0);
		}
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public NaturalJoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_naturalJoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterNaturalJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitNaturalJoin(this);
		}
	}

	public final NaturalJoinContext naturalJoin() throws RecognitionException {
		NaturalJoinContext _localctx = new NaturalJoinContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_naturalJoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); match(19);
			setState(211); joinType();
			setState(212); match(13);
			setState(213); tableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionJoinContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class, 0);
		}
		public UnionJoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionJoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterUnionJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitUnionJoin(this);
		}
	}

	public final UnionJoinContext unionJoin() throws RecognitionException {
		UnionJoinContext _localctx = new UnionJoinContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_unionJoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(14);
			setState(216); tableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinTypeContext extends ParserRuleContext {
		public OuterJoinTypeContext outerJoinType() {
			return getRuleContext(OuterJoinTypeContext.class,0);
		}
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitJoinType(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_joinType);
		int _la;
		try {
			setState(223);
			switch (_input.LA(1)) {
			case 18:
				enterOuterAlt(_localctx, 1);
				{
				setState(218); match(18);
				}
				break;
			case 5:
			case 10:
			case 22:
				enterOuterAlt(_localctx, 2);
				{
				setState(219); outerJoinType();
				setState(221);
				_la = _input.LA(1);
				if (_la==26) {
					{
					setState(220); match(26);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OuterJoinTypeContext extends ParserRuleContext {
		public OuterJoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outerJoinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterOuterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitOuterJoinType(this);
		}
	}

	public final OuterJoinTypeContext outerJoinType() throws RecognitionException {
		OuterJoinTypeContext _localctx = new OuterJoinTypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_outerJoinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 10) | (1L << 22))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinSpecContext extends ParserRuleContext {
		public NamedColumnsJoinContext namedColumnsJoin() {
			return getRuleContext(NamedColumnsJoinContext.class,0);
		}
		public JoinConditionContext joinCondition() {
			return getRuleContext(JoinConditionContext.class,0);
		}
		public JoinSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterJoinSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitJoinSpec(this);
		}
	}

	public final JoinSpecContext joinSpec() throws RecognitionException {
		JoinSpecContext _localctx = new JoinSpecContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_joinSpec);
		try {
			setState(229);
			switch (_input.LA(1)) {
			case 24:
				enterOuterAlt(_localctx, 1);
				{
				setState(227); joinCondition();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 2);
				{
				setState(228); namedColumnsJoin();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinConditionContext extends ParserRuleContext {
		public SearchConditionContext searchCondition() {
			return getRuleContext(SearchConditionContext.class,0);
		}
		public JoinConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterJoinCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitJoinCondition(this);
		}
	}

	public final JoinConditionContext joinCondition() throws RecognitionException {
		JoinConditionContext _localctx = new JoinConditionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_joinCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); match(24);
			setState(232); searchCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedColumnsJoinContext extends ParserRuleContext {
		public ColumnNameListContext columnNameList() {
			return getRuleContext(ColumnNameListContext.class,0);
		}
		public NamedColumnsJoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedColumnsJoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterNamedColumnsJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitNamedColumnsJoin(this);
		}
	}

	public final NamedColumnsJoinContext namedColumnsJoin() throws RecognitionException {
		NamedColumnsJoinContext _localctx = new NamedColumnsJoinContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_namedColumnsJoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(17);
			setState(235); match(8);
			setState(236); columnNameList();
			setState(237); match(21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnNameListContext extends ParserRuleContext {
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterColumnNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitColumnNameList(this);
		}
	}

	public final ColumnNameListContext columnNameList() throws RecognitionException {
		ColumnNameListContext _localctx = new ColumnNameListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_columnNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); columnName();
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(240); match(4);
				setState(241); columnName();
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SELECTParser.ID, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitColumnName(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SELECTParser.ID, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitTableName(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15: return booleanValueExpression_sempred((BooleanValueExpressionContext)_localctx, predIndex);

		case 16: return booleanTerm_sempred((BooleanTermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean booleanValueExpression_sempred(BooleanValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean booleanTerm_sempred(BooleanTermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3!\u00fe\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\3\5\3Q\n\3\3\3\3\3\3"+
		"\3\5\3V\n\3\3\4\3\4\3\5\3\5\3\5\3\5\7\5^\n\5\f\5\16\5a\13\5\5\5c\n\5\3"+
		"\6\3\6\5\6g\n\6\3\7\3\7\3\7\3\7\3\b\3\b\5\bo\n\b\3\t\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\7\13z\n\13\f\13\16\13}\13\13\3\f\3\f\3\f\5\f\u0082"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u0089\n\r\3\16\3\16\3\16\7\16\u008e\n\16"+
		"\f\16\16\16\u0091\13\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\7\21\u009e\n\21\f\21\16\21\u00a1\13\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\7\22\u00a9\n\22\f\22\16\22\u00ac\13\22\3\23\5\23\u00af\n\23\3"+
		"\23\3\23\3\24\3\24\3\24\5\24\u00b6\n\24\3\24\5\24\u00b9\n\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\5\32\u00cb\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\5\37\u00e0\n\37\5\37\u00e2\n"+
		"\37\3 \3 \3!\3!\5!\u00e8\n!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\7$\u00f5"+
		"\n$\f$\16$\u00f8\13$\3%\3%\3&\3&\3&\2\'\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2\5\3\2\4\5\5\2\16\16\21\21\31"+
		"\31\5\2\7\7\f\f\30\30\u00ee\2L\3\2\2\2\4P\3\2\2\2\6W\3\2\2\2\bb\3\2\2"+
		"\2\nf\3\2\2\2\fh\3\2\2\2\16l\3\2\2\2\20p\3\2\2\2\22s\3\2\2\2\24u\3\2\2"+
		"\2\26~\3\2\2\2\30\u0083\3\2\2\2\32\u008a\3\2\2\2\34\u0092\3\2\2\2\36\u0095"+
		"\3\2\2\2 \u0097\3\2\2\2\"\u00a2\3\2\2\2$\u00ae\3\2\2\2&\u00b2\3\2\2\2"+
		"(\u00ba\3\2\2\2*\u00bc\3\2\2\2,\u00be\3\2\2\2.\u00c0\3\2\2\2\60\u00c4"+
		"\3\2\2\2\62\u00ca\3\2\2\2\64\u00cc\3\2\2\2\66\u00cf\3\2\2\28\u00d4\3\2"+
		"\2\2:\u00d9\3\2\2\2<\u00e1\3\2\2\2>\u00e3\3\2\2\2@\u00e7\3\2\2\2B\u00e9"+
		"\3\2\2\2D\u00ec\3\2\2\2F\u00f1\3\2\2\2H\u00f9\3\2\2\2J\u00fb\3\2\2\2L"+
		"M\7\37\2\2MN\5\4\3\2N\3\3\2\2\2OQ\5\6\4\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2"+
		"\2RS\5\b\5\2SU\5\22\n\2TV\5\60\31\2UT\3\2\2\2UV\3\2\2\2V\5\3\2\2\2WX\t"+
		"\2\2\2X\7\3\2\2\2Yc\7\b\2\2Z_\5\n\6\2[\\\7\6\2\2\\^\5\n\6\2][\3\2\2\2"+
		"^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`c\3\2\2\2a_\3\2\2\2bY\3\2\2\2bZ\3\2\2\2"+
		"c\t\3\2\2\2dg\5\f\7\2eg\5\16\b\2fd\3\2\2\2fe\3\2\2\2g\13\3\2\2\2hi\5J"+
		"&\2ij\7\26\2\2jk\5H%\2k\r\3\2\2\2ln\5H%\2mo\5\20\t\2nm\3\2\2\2no\3\2\2"+
		"\2o\17\3\2\2\2pq\7\13\2\2qr\5H%\2r\21\3\2\2\2st\5\24\13\2t\23\3\2\2\2"+
		"uv\7\35\2\2v{\5\26\f\2wx\7\6\2\2xz\5\26\f\2yw\3\2\2\2z}\3\2\2\2{y\3\2"+
		"\2\2{|\3\2\2\2|\25\3\2\2\2}{\3\2\2\2~\u0081\5J&\2\177\u0080\7\13\2\2\u0080"+
		"\u0082\5\30\r\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\27\3\2\2\2"+
		"\u0083\u0088\5J&\2\u0084\u0085\7\n\2\2\u0085\u0086\5\32\16\2\u0086\u0087"+
		"\7\27\2\2\u0087\u0089\3\2\2\2\u0088\u0084\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\31\3\2\2\2\u008a\u008f\5H%\2\u008b\u008c\7\6\2\2\u008c\u008e\5"+
		"H%\2\u008d\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\33\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\t\2"+
		"\2\u0093\u0094\5\36\20\2\u0094\35\3\2\2\2\u0095\u0096\5 \21\2\u0096\37"+
		"\3\2\2\2\u0097\u0098\b\21\1\2\u0098\u0099\5\"\22\2\u0099\u009f\3\2\2\2"+
		"\u009a\u009b\6\21\2\3\u009b\u009c\7\r\2\2\u009c\u009e\5\"\22\2\u009d\u009a"+
		"\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"!\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\b\22\1\2\u00a3\u00a4\5$\23\2"+
		"\u00a4\u00aa\3\2\2\2\u00a5\u00a6\6\22\3\3\u00a6\u00a7\7\22\2\2\u00a7\u00a9"+
		"\5$\23\2\u00a8\u00a5\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab#\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00af\7\36\2\2"+
		"\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1"+
		"\5&\24\2\u00b1%\3\2\2\2\u00b2\u00b8\5*\26\2\u00b3\u00b5\7\33\2\2\u00b4"+
		"\u00b6\7\36\2\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3"+
		"\2\2\2\u00b7\u00b9\5(\25\2\u00b8\u00b3\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\'\3\2\2\2\u00ba\u00bb\t\3\2\2\u00bb)\3\2\2\2\u00bc\u00bd\5,\27\2\u00bd"+
		"+\3\2\2\2\u00be\u00bf\5.\30\2\u00bf-\3\2\2\2\u00c0\u00c1\7\n\2\2\u00c1"+
		"\u00c2\5 \21\2\u00c2\u00c3\7\27\2\2\u00c3/\3\2\2\2\u00c4\u00c5\5\62\32"+
		"\2\u00c5\61\3\2\2\2\u00c6\u00cb\5\64\33\2\u00c7\u00cb\5\66\34\2\u00c8"+
		"\u00cb\58\35\2\u00c9\u00cb\5:\36\2\u00ca\u00c6\3\2\2\2\u00ca\u00c7\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\63\3\2\2\2\u00cc\u00cd"+
		"\7\3\2\2\u00cd\u00ce\5J&\2\u00ce\65\3\2\2\2\u00cf\u00d0\5<\37\2\u00d0"+
		"\u00d1\7\17\2\2\u00d1\u00d2\5J&\2\u00d2\u00d3\5@!\2\u00d3\67\3\2\2\2\u00d4"+
		"\u00d5\7\25\2\2\u00d5\u00d6\5<\37\2\u00d6\u00d7\7\17\2\2\u00d7\u00d8\5"+
		"J&\2\u00d89\3\2\2\2\u00d9\u00da\7\20\2\2\u00da\u00db\5J&\2\u00db;\3\2"+
		"\2\2\u00dc\u00e2\7\24\2\2\u00dd\u00df\5> \2\u00de\u00e0\7\34\2\2\u00df"+
		"\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00dc\3\2"+
		"\2\2\u00e1\u00dd\3\2\2\2\u00e2=\3\2\2\2\u00e3\u00e4\t\4\2\2\u00e4?\3\2"+
		"\2\2\u00e5\u00e8\5B\"\2\u00e6\u00e8\5D#\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6"+
		"\3\2\2\2\u00e8A\3\2\2\2\u00e9\u00ea\7\32\2\2\u00ea\u00eb\5\36\20\2\u00eb"+
		"C\3\2\2\2\u00ec\u00ed\7\23\2\2\u00ed\u00ee\7\n\2\2\u00ee\u00ef\5F$\2\u00ef"+
		"\u00f0\7\27\2\2\u00f0E\3\2\2\2\u00f1\u00f6\5H%\2\u00f2\u00f3\7\6\2\2\u00f3"+
		"\u00f5\5H%\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2"+
		"\2\u00f6\u00f7\3\2\2\2\u00f7G\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa"+
		"\7 \2\2\u00faI\3\2\2\2\u00fb\u00fc\7 \2\2\u00fcK\3\2\2\2\26PU_bfn{\u0081"+
		"\u0088\u008f\u009f\u00aa\u00ae\u00b5\u00b8\u00ca\u00df\u00e1\u00e7\u00f6";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}