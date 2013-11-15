package com.etk.parser;

// Generated from C:\Users\Georgy\IdeaProjects\SELECTParser\src\SELECT.g4 by ANTLR 4.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SELECTLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, COLUMNNAME=18, TABLENAME=19, ID=20, ID_LETTER=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'AS'", "'DISTINCT'", "'AND'", "'IS'", "'ALL'", "')'", "','", "'OR'", 
		"'*'", "'WHERE'", "'('", "'FROM'", "'TRUE'", "'UNKNOWN'", "'NOT'", "'SELECT'", 
		"'FALSE'", "COLUMNNAME", "TABLENAME", "ID", "ID_LETTER"
	};
	public static final String[] ruleNames = {
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"COLUMNNAME", "TABLENAME", "ID", "ID_LETTER", "DIGIT"
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\27\u008b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\25\7\25\u0082\n\25\f\25\16\25\u0085\13\25\3\26\5\26\u0088\n\26\3"+
		"\27\3\27\2\30\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13"+
		"\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25"+
		"\1)\26\1+\27\1-\2\1\3\2\4\7\2CC\\\\aacc||\3\2\62;\u008b\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3/\3\2\2\2\5\62\3\2\2\2\7;\3\2\2\2"+
		"\t?\3\2\2\2\13B\3\2\2\2\rF\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23M\3\2\2\2"+
		"\25O\3\2\2\2\27U\3\2\2\2\31W\3\2\2\2\33\\\3\2\2\2\35a\3\2\2\2\37i\3\2"+
		"\2\2!m\3\2\2\2#t\3\2\2\2%z\3\2\2\2\'|\3\2\2\2)~\3\2\2\2+\u0087\3\2\2\2"+
		"-\u0089\3\2\2\2/\60\7C\2\2\60\61\7U\2\2\61\4\3\2\2\2\62\63\7F\2\2\63\64"+
		"\7K\2\2\64\65\7U\2\2\65\66\7V\2\2\66\67\7K\2\2\678\7P\2\289\7E\2\29:\7"+
		"V\2\2:\6\3\2\2\2;<\7C\2\2<=\7P\2\2=>\7F\2\2>\b\3\2\2\2?@\7K\2\2@A\7U\2"+
		"\2A\n\3\2\2\2BC\7C\2\2CD\7N\2\2DE\7N\2\2E\f\3\2\2\2FG\7+\2\2G\16\3\2\2"+
		"\2HI\7.\2\2I\20\3\2\2\2JK\7Q\2\2KL\7T\2\2L\22\3\2\2\2MN\7,\2\2N\24\3\2"+
		"\2\2OP\7Y\2\2PQ\7J\2\2QR\7G\2\2RS\7T\2\2ST\7G\2\2T\26\3\2\2\2UV\7*\2\2"+
		"V\30\3\2\2\2WX\7H\2\2XY\7T\2\2YZ\7Q\2\2Z[\7O\2\2[\32\3\2\2\2\\]\7V\2\2"+
		"]^\7T\2\2^_\7W\2\2_`\7G\2\2`\34\3\2\2\2ab\7W\2\2bc\7P\2\2cd\7M\2\2de\7"+
		"P\2\2ef\7Q\2\2fg\7Y\2\2gh\7P\2\2h\36\3\2\2\2ij\7P\2\2jk\7Q\2\2kl\7V\2"+
		"\2l \3\2\2\2mn\7U\2\2no\7G\2\2op\7N\2\2pq\7G\2\2qr\7E\2\2rs\7V\2\2s\""+
		"\3\2\2\2tu\7H\2\2uv\7C\2\2vw\7N\2\2wx\7U\2\2xy\7G\2\2y$\3\2\2\2z{\5)\25"+
		"\2{&\3\2\2\2|}\5)\25\2}(\3\2\2\2~\u0083\5+\26\2\177\u0082\5+\26\2\u0080"+
		"\u0082\5-\27\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2"+
		"\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084*\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\u0088\t\2\2\2\u0087\u0086\3\2\2\2\u0088,\3\2\2\2\u0089"+
		"\u008a\t\3\2\2\u008a.\3\2\2\2\6\2\u0081\u0083\u0087";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}