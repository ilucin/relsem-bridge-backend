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
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, ID=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'AS'", "'DISTINCT'", "'AND'", "'IS'", "'ALL'", "')'", "','", "'OR'", 
		"'*'", "'WHERE'", "'('", "'FROM'", "'TRUE'", "'UNKNOWN'", "'NOT'", "'SELECT'", 
		"'FALSE'", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"ID", "ID_LETTER", "DIGIT", "WS"
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
		case 20: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\25\u008b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23|\n\23\f\23\16\23"+
		"\177\13\23\3\24\3\24\3\25\3\25\3\26\6\26\u0086\n\26\r\26\16\26\u0087\3"+
		"\26\3\26\2\27\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13"+
		"\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\2"+
		"\1)\2\1+\25\2\3\2\4\5\2C\\aac|\5\2\13\f\17\17\"\"\u008b\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2+\3\2\2\2\3-\3\2\2\2\5\60\3\2\2\2\79\3\2\2\2\t=\3\2\2\2\13@\3\2\2\2"+
		"\rD\3\2\2\2\17F\3\2\2\2\21H\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27S\3\2\2"+
		"\2\31U\3\2\2\2\33Z\3\2\2\2\35_\3\2\2\2\37g\3\2\2\2!k\3\2\2\2#r\3\2\2\2"+
		"%x\3\2\2\2\'\u0080\3\2\2\2)\u0082\3\2\2\2+\u0085\3\2\2\2-.\7C\2\2./\7"+
		"U\2\2/\4\3\2\2\2\60\61\7F\2\2\61\62\7K\2\2\62\63\7U\2\2\63\64\7V\2\2\64"+
		"\65\7K\2\2\65\66\7P\2\2\66\67\7E\2\2\678\7V\2\28\6\3\2\2\29:\7C\2\2:;"+
		"\7P\2\2;<\7F\2\2<\b\3\2\2\2=>\7K\2\2>?\7U\2\2?\n\3\2\2\2@A\7C\2\2AB\7"+
		"N\2\2BC\7N\2\2C\f\3\2\2\2DE\7+\2\2E\16\3\2\2\2FG\7.\2\2G\20\3\2\2\2HI"+
		"\7Q\2\2IJ\7T\2\2J\22\3\2\2\2KL\7,\2\2L\24\3\2\2\2MN\7Y\2\2NO\7J\2\2OP"+
		"\7G\2\2PQ\7T\2\2QR\7G\2\2R\26\3\2\2\2ST\7*\2\2T\30\3\2\2\2UV\7H\2\2VW"+
		"\7T\2\2WX\7Q\2\2XY\7O\2\2Y\32\3\2\2\2Z[\7V\2\2[\\\7T\2\2\\]\7W\2\2]^\7"+
		"G\2\2^\34\3\2\2\2_`\7W\2\2`a\7P\2\2ab\7M\2\2bc\7P\2\2cd\7Q\2\2de\7Y\2"+
		"\2ef\7P\2\2f\36\3\2\2\2gh\7P\2\2hi\7Q\2\2ij\7V\2\2j \3\2\2\2kl\7U\2\2"+
		"lm\7G\2\2mn\7N\2\2no\7G\2\2op\7E\2\2pq\7V\2\2q\"\3\2\2\2rs\7H\2\2st\7"+
		"C\2\2tu\7N\2\2uv\7U\2\2vw\7G\2\2w$\3\2\2\2x}\5\'\24\2y|\5\'\24\2z|\5)"+
		"\25\2{y\3\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~&\3\2\2\2\177"+
		"}\3\2\2\2\u0080\u0081\t\2\2\2\u0081(\3\2\2\2\u0082\u0083\4\62;\2\u0083"+
		"*\3\2\2\2\u0084\u0086\t\3\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2"+
		"\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a"+
		"\b\26\2\2\u008a,\3\2\2\2\6\2{}\u0087";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}