package com.etk.parser;// Generated from C:\Users\Georgy\IdeaProjects\SELECTParser\src\SELECT.g4 by ANTLR 4.1

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
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, ID=18, WS=19;
	public static final String[] tokenNames = {
		"<INVALID>", "'AS'", "'DISTINCT'", "'AND'", "'IS'", "'ALL'", "')'", "','", 
		"'OR'", "'*'", "'WHERE'", "'('", "'FROM'", "'TRUE'", "'UNKNOWN'", "'NOT'", 
		"'SELECT'", "'FALSE'", "ID", "WS"
	};
	public static final int
		RULE_selectStmnt = 0, RULE_querySpecification = 1, RULE_setQuantifier = 2, 
		RULE_selectList = 3, RULE_derivedColumn = 4, RULE_asClause = 5, RULE_tableExpression = 6, 
		RULE_fromClause = 7, RULE_tablePrimary = 8, RULE_tablePrimaryAs = 9, RULE_derivedColumnList = 10, 
		RULE_whereClause = 11, RULE_searchCondition = 12, RULE_booleanValueExpression = 13, 
		RULE_booleanTerm = 14, RULE_booleanFactor = 15, RULE_booleanTest = 16, 
		RULE_truthValue = 17, RULE_booleanPrimary = 18, RULE_booleanPredicand = 19, 
		RULE_parenthizedBooleanValueExpression = 20, RULE_columnName = 21, RULE_tableName = 22;
	public static final String[] ruleNames = {
		"selectStmnt", "querySpecification", "setQuantifier", "selectList", "derivedColumn", 
		"asClause", "tableExpression", "fromClause", "tablePrimary", "tablePrimaryAs", 
		"derivedColumnList", "whereClause", "searchCondition", "booleanValueExpression", 
		"booleanTerm", "booleanFactor", "booleanTest", "truthValue", "booleanPrimary", 
		"booleanPredicand", "parenthizedBooleanValueExpression", "columnName", 
		"tableName"
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
			setState(46); match(16);
			setState(47); querySpecification();
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
			setState(50);
			_la = _input.LA(1);
			if (_la==2 || _la==5) {
				{
				setState(49); setQuantifier();
				}
			}

			setState(52); selectList();
			setState(53); tableExpression();
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
			setState(55);
			_la = _input.LA(1);
			if ( !(_la==2 || _la==5) ) {
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
		public DerivedColumnContext derivedColumn(int i) {
			return getRuleContext(DerivedColumnContext.class,i);
		}
		public List<DerivedColumnContext> derivedColumn() {
			return getRuleContexts(DerivedColumnContext.class);
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
			setState(66);
			switch (_input.LA(1)) {
			case 9:
				enterOuterAlt(_localctx, 1);
				{
				setState(57); match(9);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(58); derivedColumn();
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==7) {
					{
					{
					setState(59); match(7);
					setState(60); derivedColumn();
					}
					}
					setState(65);
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

	public static class DerivedColumnContext extends ParserRuleContext {
		public AsClauseContext asClause() {
			return getRuleContext(AsClauseContext.class,0);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DerivedColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derivedColumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterDerivedColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitDerivedColumn(this);
		}
	}

	public final DerivedColumnContext derivedColumn() throws RecognitionException {
		DerivedColumnContext _localctx = new DerivedColumnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_derivedColumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); columnName();
			setState(70);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(69); asClause();
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
		enterRule(_localctx, 10, RULE_asClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(1);
			setState(73); columnName();
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
		enterRule(_localctx, 12, RULE_tableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); fromClause();
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
		enterRule(_localctx, 14, RULE_fromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); match(12);
			setState(78); tablePrimary();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==7) {
				{
				{
				setState(79); match(7);
				setState(80); tablePrimary();
				}
				}
				setState(85);
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
		enterRule(_localctx, 16, RULE_tablePrimary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); tableName();
			setState(89);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(87); match(1);
				setState(88); tablePrimaryAs();
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
		enterRule(_localctx, 18, RULE_tablePrimaryAs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); tableName();
			setState(96);
			_la = _input.LA(1);
			if (_la==11) {
				{
				setState(92); match(11);
				setState(93); derivedColumnList();
				setState(94); match(6);
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
		enterRule(_localctx, 20, RULE_derivedColumnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); columnName();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==7) {
				{
				{
				setState(99); match(7);
				setState(100); columnName();
				}
				}
				setState(105);
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
		enterRule(_localctx, 22, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(10);
			setState(107); searchCondition();
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
		enterRule(_localctx, 24, RULE_searchCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); booleanValueExpression(0);
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
		int _startState = 26;
		enterRecursionRule(_localctx, RULE_booleanValueExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(112); booleanTerm(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanValueExpressionContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_booleanValueExpression);
					setState(114);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(115); match(8);
					setState(116); booleanTerm(0);
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		int _startState = 28;
		enterRecursionRule(_localctx, RULE_booleanTerm);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(123); booleanFactor();
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanTermContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_booleanTerm);
					setState(125);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(126); match(3);
					setState(127); booleanFactor();
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 30, RULE_booleanFactor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if (_la==15) {
				{
				setState(133); match(15);
				}
			}

			setState(136); booleanTest();
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
		enterRule(_localctx, 32, RULE_booleanTest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); booleanPrimary();
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(139); match(4);
				setState(141);
				_la = _input.LA(1);
				if (_la==15) {
					{
					setState(140); match(15);
					}
				}

				setState(143); truthValue();
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
		enterRule(_localctx, 34, RULE_truthValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 14) | (1L << 17))) != 0)) ) {
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
		enterRule(_localctx, 36, RULE_booleanPrimary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); booleanPredicand();
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
		public ParenthizedBooleanValueExpressionContext parenthizedBooleanValueExpression() {
			return getRuleContext(ParenthizedBooleanValueExpressionContext.class,0);
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
		enterRule(_localctx, 38, RULE_booleanPredicand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); parenthizedBooleanValueExpression();
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

	public static class ParenthizedBooleanValueExpressionContext extends ParserRuleContext {
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public ParenthizedBooleanValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthizedBooleanValueExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).enterParenthizedBooleanValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SELECTListener ) ((SELECTListener)listener).exitParenthizedBooleanValueExpression(this);
		}
	}

	public final ParenthizedBooleanValueExpressionContext parenthizedBooleanValueExpression() throws RecognitionException {
		ParenthizedBooleanValueExpressionContext _localctx = new ParenthizedBooleanValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parenthizedBooleanValueExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); match(11);
			setState(153); booleanValueExpression(0);
			setState(154); match(6);
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
		enterRule(_localctx, 42, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(ID);
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
		enterRule(_localctx, 44, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); match(ID);
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
		case 13: return booleanValueExpression_sempred((BooleanValueExpressionContext)_localctx, predIndex);

		case 14: return booleanTerm_sempred((BooleanTermContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\25\u00a3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\3\5\3\65\n\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\7\5@\n\5\f\5\16"+
		"\5C\13\5\5\5E\n\5\3\6\3\6\5\6I\n\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\7\tT\n\t\f\t\16\tW\13\t\3\n\3\n\3\n\5\n\\\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\5\13c\n\13\3\f\3\f\3\f\7\fh\n\f\f\f\16\fk\13\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\7\17x\n\17\f\17\16\17{\13\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u0083\n\20\f\20\16\20\u0086\13\20\3\21\5\21"+
		"\u0089\n\21\3\21\3\21\3\22\3\22\3\22\5\22\u0090\n\22\3\22\5\22\u0093\n"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\30\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\4\4\2"+
		"\4\4\7\7\4\2\17\20\23\23\u0098\2\60\3\2\2\2\4\64\3\2\2\2\69\3\2\2\2\b"+
		"D\3\2\2\2\nF\3\2\2\2\fJ\3\2\2\2\16M\3\2\2\2\20O\3\2\2\2\22X\3\2\2\2\24"+
		"]\3\2\2\2\26d\3\2\2\2\30l\3\2\2\2\32o\3\2\2\2\34q\3\2\2\2\36|\3\2\2\2"+
		" \u0088\3\2\2\2\"\u008c\3\2\2\2$\u0094\3\2\2\2&\u0096\3\2\2\2(\u0098\3"+
		"\2\2\2*\u009a\3\2\2\2,\u009e\3\2\2\2.\u00a0\3\2\2\2\60\61\7\22\2\2\61"+
		"\62\5\4\3\2\62\3\3\2\2\2\63\65\5\6\4\2\64\63\3\2\2\2\64\65\3\2\2\2\65"+
		"\66\3\2\2\2\66\67\5\b\5\2\678\5\16\b\28\5\3\2\2\29:\t\2\2\2:\7\3\2\2\2"+
		";E\7\13\2\2<A\5\n\6\2=>\7\t\2\2>@\5\n\6\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2"+
		"\2AB\3\2\2\2BE\3\2\2\2CA\3\2\2\2D;\3\2\2\2D<\3\2\2\2E\t\3\2\2\2FH\5,\27"+
		"\2GI\5\f\7\2HG\3\2\2\2HI\3\2\2\2I\13\3\2\2\2JK\7\3\2\2KL\5,\27\2L\r\3"+
		"\2\2\2MN\5\20\t\2N\17\3\2\2\2OP\7\16\2\2PU\5\22\n\2QR\7\t\2\2RT\5\22\n"+
		"\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\21\3\2\2\2WU\3\2\2\2X[\5."+
		"\30\2YZ\7\3\2\2Z\\\5\24\13\2[Y\3\2\2\2[\\\3\2\2\2\\\23\3\2\2\2]b\5.\30"+
		"\2^_\7\r\2\2_`\5\26\f\2`a\7\b\2\2ac\3\2\2\2b^\3\2\2\2bc\3\2\2\2c\25\3"+
		"\2\2\2di\5,\27\2ef\7\t\2\2fh\5,\27\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3"+
		"\2\2\2j\27\3\2\2\2ki\3\2\2\2lm\7\f\2\2mn\5\32\16\2n\31\3\2\2\2op\5\34"+
		"\17\2p\33\3\2\2\2qr\b\17\1\2rs\5\36\20\2sy\3\2\2\2tu\6\17\2\3uv\7\n\2"+
		"\2vx\5\36\20\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\35\3\2\2\2{y\3"+
		"\2\2\2|}\b\20\1\2}~\5 \21\2~\u0084\3\2\2\2\177\u0080\6\20\3\3\u0080\u0081"+
		"\7\5\2\2\u0081\u0083\5 \21\2\u0082\177\3\2\2\2\u0083\u0086\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\37\3\2\2\2\u0086\u0084\3\2\2"+
		"\2\u0087\u0089\7\21\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\5\"\22\2\u008b!\3\2\2\2\u008c\u0092\5&\24\2"+
		"\u008d\u008f\7\6\2\2\u008e\u0090\7\21\2\2\u008f\u008e\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\5$\23\2\u0092\u008d\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093#\3\2\2\2\u0094\u0095\t\3\2\2\u0095%\3\2\2\2\u0096"+
		"\u0097\5(\25\2\u0097\'\3\2\2\2\u0098\u0099\5*\26\2\u0099)\3\2\2\2\u009a"+
		"\u009b\7\r\2\2\u009b\u009c\5\34\17\2\u009c\u009d\7\b\2\2\u009d+\3\2\2"+
		"\2\u009e\u009f\7\24\2\2\u009f-\3\2\2\2\u00a0\u00a1\7\24\2\2\u00a1/\3\2"+
		"\2\2\17\64ADHU[biy\u0084\u0088\u008f\u0092";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}