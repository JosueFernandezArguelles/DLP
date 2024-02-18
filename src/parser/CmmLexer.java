// Generated from C:/Users/josue/Desktop/dlp_parser/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, CHAR_CONSTANT=2, REAL_CONSTANT=3, INT_CONSTANT=4, ONE_LINE_COMMENT=5, 
		MULTIPLE_LINE_COMMENT=6, WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LETTER", "DIGIT", "FLOATING_POINT", "EXPONENT", "ID", "CHAR_CONSTANT", 
			"REAL_CONSTANT", "INT_CONSTANT", "ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "CHAR_CONSTANT", "REAL_CONSTANT", "INT_CONSTANT", "ONE_LINE_COMMENT", 
			"MULTIPLE_LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0007\u0092\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0004"+
		"\u0002\u001e\b\u0002\u000b\u0002\f\u0002\u001f\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002%\b\u0002\n\u0002\f\u0002(\t\u0002\u0003\u0002"+
		"*\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003/\b\u0003\u000b"+
		"\u0003\f\u00030\u0001\u0003\u0001\u0003\u0004\u00035\b\u0003\u000b\u0003"+
		"\f\u00036\u0003\u00039\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004=\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004B\b\u0004\n\u0004"+
		"\f\u0004E\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005X\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006\\\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006a\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0005\u0007e\b\u0007\n\u0007\f\u0007h\t\u0007\u0001\u0007"+
		"\u0003\u0007k\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bq\b\b\n\b"+
		"\f\bt\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bz\b\b\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0082\b\t\n\t\f\t\u0085\t\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0004\n\u008d\b\n\u000b\n\f"+
		"\n\u008e\u0001\n\u0001\n\u0002r\u0083\u0000\u000b\u0001\u0000\u0003\u0000"+
		"\u0005\u0000\u0007\u0000\t\u0001\u000b\u0002\r\u0003\u000f\u0004\u0011"+
		"\u0005\u0013\u0006\u0015\u0007\u0001\u0000\u0006\u0002\u0000AZaz\u0001"+
		"\u000009\u0002\u0000++--\u0001\u000019\u0001\u0001\r\r\u0003\u0000\t\n"+
		"\r\r  \u00a3\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000"+
		"\u0003\u0019\u0001\u0000\u0000\u0000\u0005)\u0001\u0000\u0000\u0000\u0007"+
		"8\u0001\u0000\u0000\u0000\t<\u0001\u0000\u0000\u0000\u000bW\u0001\u0000"+
		"\u0000\u0000\r`\u0001\u0000\u0000\u0000\u000fj\u0001\u0000\u0000\u0000"+
		"\u0011l\u0001\u0000\u0000\u0000\u0013}\u0001\u0000\u0000\u0000\u0015\u008c"+
		"\u0001\u0000\u0000\u0000\u0017\u0018\u0007\u0000\u0000\u0000\u0018\u0002"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0007\u0001\u0000\u0000\u001a\u0004"+
		"\u0001\u0000\u0000\u0000\u001b\u001d\u0005.\u0000\u0000\u001c\u001e\u0003"+
		"\u0003\u0001\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001"+
		"\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000"+
		"\u0000\u0000 *\u0001\u0000\u0000\u0000!\"\u0003\u000f\u0007\u0000\"&\u0005"+
		".\u0000\u0000#%\u0003\u0003\u0001\u0000$#\u0001\u0000\u0000\u0000%(\u0001"+
		"\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000"+
		"\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)\u001b\u0001\u0000"+
		"\u0000\u0000)!\u0001\u0000\u0000\u0000*\u0006\u0001\u0000\u0000\u0000"+
		"+,\u0005E\u0000\u0000,.\u0007\u0002\u0000\u0000-/\u0003\u000f\u0007\u0000"+
		".-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u000001\u0001\u0000\u0000\u000019\u0001\u0000\u0000\u000024\u0005e\u0000"+
		"\u000035\u0003\u000f\u0007\u000043\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000079\u0001"+
		"\u0000\u0000\u00008+\u0001\u0000\u0000\u000082\u0001\u0000\u0000\u0000"+
		"9\b\u0001\u0000\u0000\u0000:=\u0003\u0001\u0000\u0000;=\u0005_\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=C\u0001\u0000\u0000"+
		"\u0000>B\u0003\u0001\u0000\u0000?B\u0003\u0003\u0001\u0000@B\u0005_\u0000"+
		"\u0000A>\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000A@\u0001\u0000"+
		"\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000D\n\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"FG\u0005\'\u0000\u0000GH\t\u0000\u0000\u0000HX\u0005\'\u0000\u0000IJ\u0005"+
		"\'\u0000\u0000JK\u0005\\\u0000\u0000KL\u0005n\u0000\u0000LX\u0005\'\u0000"+
		"\u0000MN\u0005\'\u0000\u0000NO\u0005\\\u0000\u0000OP\u0005t\u0000\u0000"+
		"PX\u0005\'\u0000\u0000QR\u0005\'\u0000\u0000RS\u0005\\\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000TU\u0003\u000f\u0007\u0000UV\u0005\'\u0000\u0000VX\u0001"+
		"\u0000\u0000\u0000WF\u0001\u0000\u0000\u0000WI\u0001\u0000\u0000\u0000"+
		"WM\u0001\u0000\u0000\u0000WQ\u0001\u0000\u0000\u0000X\f\u0001\u0000\u0000"+
		"\u0000Y[\u0003\u0005\u0002\u0000Z\\\u0003\u0007\u0003\u0000[Z\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\a\u0001\u0000\u0000\u0000]^\u0003"+
		"\u000f\u0007\u0000^_\u0003\u0007\u0003\u0000_a\u0001\u0000\u0000\u0000"+
		"`Y\u0001\u0000\u0000\u0000`]\u0001\u0000\u0000\u0000a\u000e\u0001\u0000"+
		"\u0000\u0000bf\u0007\u0003\u0000\u0000ce\u0003\u0003\u0001\u0000dc\u0001"+
		"\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000gk\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000ik\u00050\u0000\u0000jb\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000"+
		"\u0000k\u0010\u0001\u0000\u0000\u0000lm\u0005/\u0000\u0000mn\u0005/\u0000"+
		"\u0000nr\u0001\u0000\u0000\u0000oq\t\u0000\u0000\u0000po\u0001\u0000\u0000"+
		"\u0000qt\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000sy\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000uz\u0005"+
		"\n\u0000\u0000vw\u0005\r\u0000\u0000wz\u0005\n\u0000\u0000xz\u0007\u0004"+
		"\u0000\u0000yu\u0001\u0000\u0000\u0000yv\u0001\u0000\u0000\u0000yx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0006\b\u0000\u0000|\u0012"+
		"\u0001\u0000\u0000\u0000}~\u0005/\u0000\u0000~\u007f\u0005*\u0000\u0000"+
		"\u007f\u0083\u0001\u0000\u0000\u0000\u0080\u0082\t\u0000\u0000\u0000\u0081"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084"+
		"\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005*\u0000\u0000\u0087\u0088\u0005/\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0006\t\u0000\u0000\u008a\u0014\u0001\u0000"+
		"\u0000\u0000\u008b\u008d\u0007\u0005\u0000\u0000\u008c\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0006\n\u0000\u0000\u0091\u0016\u0001\u0000\u0000"+
		"\u0000\u0013\u0000\u001f&)068<ACW[`fjry\u0083\u008e\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}