package com.etk.parser;// Generated from C:\Users\Georgy\IdeaProjects\SELECTParser\src\SELECT.g4 by ANTLR 4.1

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SELECTLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__28=1, T__27=2, T__26=3, T__25=4, T__24=5, T__23=6, T__22=7, T__21=8, 
		T__20=9, T__19=10, T__18=11, T__17=12, T__16=13, T__15=14, T__14=15, T__13=16, 
		T__12=17, T__11=18, T__10=19, T__9=20, T__8=21, T__7=22, T__6=23, T__5=24, 
		T__4=25, T__3=26, T__2=27, T__1=28, T__0=29, ID=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'CROSS JOIN'", "'DISTINCT'", "'ALL'", "','", "'RIGHT'", "'*'", "'WHERE'", 
		"'('", "'AS'", "'FULL'", "'OR'", "'TRUE'", "'JOIN'", "'UNION JOIN'", "'FALSE'", 
		"'AND'", "'USING'", "'INNER'", "'NATURAL'", "'.'", "')'", "'LEFT'", "'UNKNOWN'", 
		"'ON'", "'IS'", "'OUTER'", "'FROM'", "'NOT'", "'SELECT'", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__28", "T__27", "T__26", "T__25", "T__24", "T__23", "T__22", "T__21", 
		"T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", 
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "ID", "ID_LETTER", "DIGIT", "WS"
	};


	public SELECTLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SELECT.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 32: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2!\u00ed\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\7\37\u00de\n\37\f\37\16\37\u00e1\13\37\3 \3 \3!\3"+
		"!\3\"\6\"\u00e8\n\"\r\"\16\"\u00e9\3\"\3\"\2#\3\3\1\5\4\1\7\5\1\t\6\1"+
		"\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20"+
		"\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63"+
		"\33\1\65\34\1\67\35\19\36\1;\37\1= \1?\2\1A\2\1C!\2\3\2\4\5\2C\\aac|\5"+
		"\2\13\f\17\17\"\"\u00ed\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5P\3\2\2"+
		"\2\7Y\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\re\3\2\2\2\17g\3\2\2\2\21m\3\2\2"+
		"\2\23o\3\2\2\2\25r\3\2\2\2\27w\3\2\2\2\31z\3\2\2\2\33\177\3\2\2\2\35\u0084"+
		"\3\2\2\2\37\u008f\3\2\2\2!\u0095\3\2\2\2#\u0099\3\2\2\2%\u009f\3\2\2\2"+
		"\'\u00a5\3\2\2\2)\u00ad\3\2\2\2+\u00af\3\2\2\2-\u00b1\3\2\2\2/\u00b6\3"+
		"\2\2\2\61\u00be\3\2\2\2\63\u00c1\3\2\2\2\65\u00c4\3\2\2\2\67\u00ca\3\2"+
		"\2\29\u00cf\3\2\2\2;\u00d3\3\2\2\2=\u00da\3\2\2\2?\u00e2\3\2\2\2A\u00e4"+
		"\3\2\2\2C\u00e7\3\2\2\2EF\7E\2\2FG\7T\2\2GH\7Q\2\2HI\7U\2\2IJ\7U\2\2J"+
		"K\7\"\2\2KL\7L\2\2LM\7Q\2\2MN\7K\2\2NO\7P\2\2O\4\3\2\2\2PQ\7F\2\2QR\7"+
		"K\2\2RS\7U\2\2ST\7V\2\2TU\7K\2\2UV\7P\2\2VW\7E\2\2WX\7V\2\2X\6\3\2\2\2"+
		"YZ\7C\2\2Z[\7N\2\2[\\\7N\2\2\\\b\3\2\2\2]^\7.\2\2^\n\3\2\2\2_`\7T\2\2"+
		"`a\7K\2\2ab\7I\2\2bc\7J\2\2cd\7V\2\2d\f\3\2\2\2ef\7,\2\2f\16\3\2\2\2g"+
		"h\7Y\2\2hi\7J\2\2ij\7G\2\2jk\7T\2\2kl\7G\2\2l\20\3\2\2\2mn\7*\2\2n\22"+
		"\3\2\2\2op\7C\2\2pq\7U\2\2q\24\3\2\2\2rs\7H\2\2st\7W\2\2tu\7N\2\2uv\7"+
		"N\2\2v\26\3\2\2\2wx\7Q\2\2xy\7T\2\2y\30\3\2\2\2z{\7V\2\2{|\7T\2\2|}\7"+
		"W\2\2}~\7G\2\2~\32\3\2\2\2\177\u0080\7L\2\2\u0080\u0081\7Q\2\2\u0081\u0082"+
		"\7K\2\2\u0082\u0083\7P\2\2\u0083\34\3\2\2\2\u0084\u0085\7W\2\2\u0085\u0086"+
		"\7P\2\2\u0086\u0087\7K\2\2\u0087\u0088\7Q\2\2\u0088\u0089\7P\2\2\u0089"+
		"\u008a\7\"\2\2\u008a\u008b\7L\2\2\u008b\u008c\7Q\2\2\u008c\u008d\7K\2"+
		"\2\u008d\u008e\7P\2\2\u008e\36\3\2\2\2\u008f\u0090\7H\2\2\u0090\u0091"+
		"\7C\2\2\u0091\u0092\7N\2\2\u0092\u0093\7U\2\2\u0093\u0094\7G\2\2\u0094"+
		" \3\2\2\2\u0095\u0096\7C\2\2\u0096\u0097\7P\2\2\u0097\u0098\7F\2\2\u0098"+
		"\"\3\2\2\2\u0099\u009a\7W\2\2\u009a\u009b\7U\2\2\u009b\u009c\7K\2\2\u009c"+
		"\u009d\7P\2\2\u009d\u009e\7I\2\2\u009e$\3\2\2\2\u009f\u00a0\7K\2\2\u00a0"+
		"\u00a1\7P\2\2\u00a1\u00a2\7P\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4\7T\2\2"+
		"\u00a4&\3\2\2\2\u00a5\u00a6\7P\2\2\u00a6\u00a7\7C\2\2\u00a7\u00a8\7V\2"+
		"\2\u00a8\u00a9\7W\2\2\u00a9\u00aa\7T\2\2\u00aa\u00ab\7C\2\2\u00ab\u00ac"+
		"\7N\2\2\u00ac(\3\2\2\2\u00ad\u00ae\7\60\2\2\u00ae*\3\2\2\2\u00af\u00b0"+
		"\7+\2\2\u00b0,\3\2\2\2\u00b1\u00b2\7N\2\2\u00b2\u00b3\7G\2\2\u00b3\u00b4"+
		"\7H\2\2\u00b4\u00b5\7V\2\2\u00b5.\3\2\2\2\u00b6\u00b7\7W\2\2\u00b7\u00b8"+
		"\7P\2\2\u00b8\u00b9\7M\2\2\u00b9\u00ba\7P\2\2\u00ba\u00bb\7Q\2\2\u00bb"+
		"\u00bc\7Y\2\2\u00bc\u00bd\7P\2\2\u00bd\60\3\2\2\2\u00be\u00bf\7Q\2\2\u00bf"+
		"\u00c0\7P\2\2\u00c0\62\3\2\2\2\u00c1\u00c2\7K\2\2\u00c2\u00c3\7U\2\2\u00c3"+
		"\64\3\2\2\2\u00c4\u00c5\7Q\2\2\u00c5\u00c6\7W\2\2\u00c6\u00c7\7V\2\2\u00c7"+
		"\u00c8\7G\2\2\u00c8\u00c9\7T\2\2\u00c9\66\3\2\2\2\u00ca\u00cb\7H\2\2\u00cb"+
		"\u00cc\7T\2\2\u00cc\u00cd\7Q\2\2\u00cd\u00ce\7O\2\2\u00ce8\3\2\2\2\u00cf"+
		"\u00d0\7P\2\2\u00d0\u00d1\7Q\2\2\u00d1\u00d2\7V\2\2\u00d2:\3\2\2\2\u00d3"+
		"\u00d4\7U\2\2\u00d4\u00d5\7G\2\2\u00d5\u00d6\7N\2\2\u00d6\u00d7\7G\2\2"+
		"\u00d7\u00d8\7E\2\2\u00d8\u00d9\7V\2\2\u00d9<\3\2\2\2\u00da\u00df\5? "+
		"\2\u00db\u00de\5? \2\u00dc\u00de\5A!\2\u00dd\u00db\3\2\2\2\u00dd\u00dc"+
		"\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		">\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\t\2\2\2\u00e3@\3\2\2\2\u00e4"+
		"\u00e5\4\62;\2\u00e5B\3\2\2\2\u00e6\u00e8\t\3\2\2\u00e7\u00e6\3\2\2\2"+
		"\u00e8\u00e9\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\u00ec\b\"\2\2\u00ecD\3\2\2\2\6\2\u00dd\u00df\u00e9";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}