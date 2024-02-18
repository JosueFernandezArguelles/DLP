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
		"\u0004\u0000\u0007\u008a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0004"+
		"\u0002\u001e\b\u0002\u000b\u0002\f\u0002\u001f\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002%\b\u0002\n\u0002\f\u0002(\t\u0002\u0003\u0002"+
		"*\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00031\b\u0003\u0001\u0004\u0001\u0004\u0003\u00045\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004:\b\u0004\n\u0004\f\u0004=\t"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005P\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006T\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006Y\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0005\u0007]\b\u0007\n\u0007\f\u0007`\t\u0007\u0001\u0007\u0003\u0007"+
		"c\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bi\b\b\n\b\f\bl\t\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\br\b\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\tz\b\t\n\t\f\t}\t\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0004\n\u0085\b\n\u000b\n\f\n\u0086\u0001\n\u0001\n"+
		"\u0002j{\u0000\u000b\u0001\u0000\u0003\u0000\u0005\u0000\u0007\u0000\t"+
		"\u0001\u000b\u0002\r\u0003\u000f\u0004\u0011\u0005\u0013\u0006\u0015\u0007"+
		"\u0001\u0000\u0006\u0002\u0000AZaz\u0001\u000009\u0002\u0000++--\u0001"+
		"\u000019\u0001\u0001\r\r\u0003\u0000\t\n\r\r  \u0099\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0003\u0019\u0001\u0000\u0000"+
		"\u0000\u0005)\u0001\u0000\u0000\u0000\u00070\u0001\u0000\u0000\u0000\t"+
		"4\u0001\u0000\u0000\u0000\u000bO\u0001\u0000\u0000\u0000\rX\u0001\u0000"+
		"\u0000\u0000\u000fb\u0001\u0000\u0000\u0000\u0011d\u0001\u0000\u0000\u0000"+
		"\u0013u\u0001\u0000\u0000\u0000\u0015\u0084\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0007\u0000\u0000\u0000\u0018\u0002\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0007\u0001\u0000\u0000\u001a\u0004\u0001\u0000\u0000\u0000\u001b"+
		"\u001d\u0005.\u0000\u0000\u001c\u001e\u0003\u0003\u0001\u0000\u001d\u001c"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 *\u0001\u0000"+
		"\u0000\u0000!\"\u0003\u000f\u0007\u0000\"&\u0005.\u0000\u0000#%\u0003"+
		"\u0003\u0001\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000"+
		"&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000"+
		"\u0000(&\u0001\u0000\u0000\u0000)\u001b\u0001\u0000\u0000\u0000)!\u0001"+
		"\u0000\u0000\u0000*\u0006\u0001\u0000\u0000\u0000+,\u0005E\u0000\u0000"+
		",-\u0007\u0002\u0000\u0000-1\u0003\u000f\u0007\u0000./\u0005e\u0000\u0000"+
		"/1\u0003\u000f\u0007\u00000+\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u00001\b\u0001\u0000\u0000\u000025\u0003\u0001\u0000\u000035\u0005_\u0000"+
		"\u000042\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u00005;\u0001\u0000"+
		"\u0000\u00006:\u0003\u0001\u0000\u00007:\u0003\u0003\u0001\u00008:\u0005"+
		"_\u0000\u000096\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u000098\u0001"+
		"\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<\n\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000>?\u0005\'\u0000\u0000?@\t\u0000\u0000\u0000@P\u0005\'\u0000\u0000"+
		"AB\u0005\'\u0000\u0000BC\u0005\\\u0000\u0000CD\u0005n\u0000\u0000DP\u0005"+
		"\'\u0000\u0000EF\u0005\'\u0000\u0000FG\u0005\\\u0000\u0000GH\u0005t\u0000"+
		"\u0000HP\u0005\'\u0000\u0000IJ\u0005\'\u0000\u0000JK\u0005\\\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LM\u0003\u000f\u0007\u0000MN\u0005\'\u0000\u0000"+
		"NP\u0001\u0000\u0000\u0000O>\u0001\u0000\u0000\u0000OA\u0001\u0000\u0000"+
		"\u0000OE\u0001\u0000\u0000\u0000OI\u0001\u0000\u0000\u0000P\f\u0001\u0000"+
		"\u0000\u0000QS\u0003\u0005\u0002\u0000RT\u0003\u0007\u0003\u0000SR\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TY\u0001\u0000\u0000\u0000"+
		"UV\u0003\u000f\u0007\u0000VW\u0003\u0007\u0003\u0000WY\u0001\u0000\u0000"+
		"\u0000XQ\u0001\u0000\u0000\u0000XU\u0001\u0000\u0000\u0000Y\u000e\u0001"+
		"\u0000\u0000\u0000Z^\u0007\u0003\u0000\u0000[]\u0003\u0003\u0001\u0000"+
		"\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_c\u0001\u0000\u0000\u0000`^\u0001\u0000"+
		"\u0000\u0000ac\u00050\u0000\u0000bZ\u0001\u0000\u0000\u0000ba\u0001\u0000"+
		"\u0000\u0000c\u0010\u0001\u0000\u0000\u0000de\u0005/\u0000\u0000ef\u0005"+
		"/\u0000\u0000fj\u0001\u0000\u0000\u0000gi\t\u0000\u0000\u0000hg\u0001"+
		"\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000kq\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000"+
		"\u0000mr\u0005\n\u0000\u0000no\u0005\r\u0000\u0000or\u0005\n\u0000\u0000"+
		"pr\u0007\u0004\u0000\u0000qm\u0001\u0000\u0000\u0000qn\u0001\u0000\u0000"+
		"\u0000qp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0006\b\u0000"+
		"\u0000t\u0012\u0001\u0000\u0000\u0000uv\u0005/\u0000\u0000vw\u0005*\u0000"+
		"\u0000w{\u0001\u0000\u0000\u0000xz\t\u0000\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000z}\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000{y\u0001\u0000"+
		"\u0000\u0000|~\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005*\u0000\u0000\u007f\u0080\u0005/\u0000\u0000\u0080\u0081\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0006\t\u0000\u0000\u0082\u0014\u0001\u0000\u0000"+
		"\u0000\u0083\u0085\u0007\u0005\u0000\u0000\u0084\u0083\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0006\n\u0000\u0000\u0089\u0016\u0001\u0000\u0000\u0000"+
		"\u0011\u0000\u001f&)049;OSX^bjq{\u0086\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}