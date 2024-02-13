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
		INT_CONSTANT=1, REAL_CONSTANT=2, ONE_LINE_COMMENT=3, MULTIPLE_LINE_COMMENT=4, 
		WS=5, ID=6, CHAR_CONSTANT=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LETTER", "DIGIT", "FLOATING_POINT", "EXPONENT", "INT_CONSTANT", "REAL_CONSTANT", 
			"ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT", "WS", "ID", "CHAR_CONSTANT"
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
			null, "INT_CONSTANT", "REAL_CONSTANT", "ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT", 
			"WS", "ID", "CHAR_CONSTANT"
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
		"\u0004\u0000\u0007\u0098\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0004"+
		"\u0002\u001e\b\u0002\u000b\u0002\f\u0002\u001f\u0001\u0002\u0001\u0002"+
		"\u0005\u0002$\b\u0002\n\u0002\f\u0002\'\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002+\b\u0002\n\u0002\f\u0002.\t\u0002\u0003\u00020\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u00035\b\u0003\u000b\u0003\f\u0003"+
		"6\u0001\u0003\u0001\u0003\u0004\u0003;\b\u0003\u000b\u0003\f\u0003<\u0003"+
		"\u0003?\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004C\b\u0004\n\u0004\f"+
		"\u0004F\t\u0004\u0001\u0004\u0003\u0004I\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0003\u0005M\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"R\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"X\b\u0006\n\u0006\f\u0006[\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006a\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007i\b\u0007\n\u0007\f\u0007"+
		"l\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0004\bt\b\b\u000b\b\f\bu\u0001\b\u0001\b\u0001\t\u0001\t\u0003"+
		"\t|\b\t\u0001\t\u0001\t\u0001\t\u0005\t\u0081\b\t\n\t\f\t\u0084\t\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0097"+
		"\b\n\u0002Yj\u0000\u000b\u0001\u0000\u0003\u0000\u0005\u0000\u0007\u0000"+
		"\t\u0001\u000b\u0002\r\u0003\u000f\u0004\u0011\u0005\u0013\u0006\u0015"+
		"\u0007\u0001\u0000\u0006\u0002\u0000AZaz\u0001\u000009\u0001\u000019\u0002"+
		"\u0000++--\u0001\u0001\r\r\u0003\u0000\t\n\r\r  \u00aa\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0003\u0019\u0001\u0000\u0000"+
		"\u0000\u0005/\u0001\u0000\u0000\u0000\u0007>\u0001\u0000\u0000\u0000\t"+
		"H\u0001\u0000\u0000\u0000\u000bQ\u0001\u0000\u0000\u0000\rS\u0001\u0000"+
		"\u0000\u0000\u000fd\u0001\u0000\u0000\u0000\u0011s\u0001\u0000\u0000\u0000"+
		"\u0013{\u0001\u0000\u0000\u0000\u0015\u0096\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0007\u0000\u0000\u0000\u0018\u0002\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0007\u0001\u0000\u0000\u001a\u0004\u0001\u0000\u0000\u0000\u001b"+
		"\u001d\u0005.\u0000\u0000\u001c\u001e\u0003\u0003\u0001\u0000\u001d\u001c"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 0\u0001\u0000"+
		"\u0000\u0000!%\u0007\u0002\u0000\u0000\"$\u0003\u0003\u0001\u0000#\"\u0001"+
		"\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000"+
		"%&\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000"+
		"\u0000(,\u0005.\u0000\u0000)+\u0003\u0003\u0001\u0000*)\u0001\u0000\u0000"+
		"\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/\u001b"+
		"\u0001\u0000\u0000\u0000/!\u0001\u0000\u0000\u00000\u0006\u0001\u0000"+
		"\u0000\u000012\u0005E\u0000\u000024\u0007\u0003\u0000\u000035\u0003\u0003"+
		"\u0001\u000043\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u000067\u0001\u0000\u0000\u00007?\u0001\u0000\u0000\u0000"+
		"8:\u0005e\u0000\u00009;\u0003\u0003\u0001\u0000:9\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000"+
		"\u0000=?\u0001\u0000\u0000\u0000>1\u0001\u0000\u0000\u0000>8\u0001\u0000"+
		"\u0000\u0000?\b\u0001\u0000\u0000\u0000@D\u0007\u0002\u0000\u0000AC\u0003"+
		"\u0003\u0001\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EI\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000GI\u00050\u0000\u0000H@\u0001\u0000\u0000"+
		"\u0000HG\u0001\u0000\u0000\u0000I\n\u0001\u0000\u0000\u0000JL\u0003\u0005"+
		"\u0002\u0000KM\u0003\u0007\u0003\u0000LK\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MR\u0001\u0000\u0000\u0000NO\u0003\t\u0004\u0000OP\u0003"+
		"\u0007\u0003\u0000PR\u0001\u0000\u0000\u0000QJ\u0001\u0000\u0000\u0000"+
		"QN\u0001\u0000\u0000\u0000R\f\u0001\u0000\u0000\u0000ST\u0005/\u0000\u0000"+
		"TU\u0005/\u0000\u0000UY\u0001\u0000\u0000\u0000VX\t\u0000\u0000\u0000"+
		"WV\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000Z`\u0001\u0000\u0000\u0000[Y\u0001\u0000"+
		"\u0000\u0000\\a\u0005\n\u0000\u0000]^\u0005\r\u0000\u0000^a\u0005\n\u0000"+
		"\u0000_a\u0007\u0004\u0000\u0000`\\\u0001\u0000\u0000\u0000`]\u0001\u0000"+
		"\u0000\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0006"+
		"\u0006\u0000\u0000c\u000e\u0001\u0000\u0000\u0000de\u0005/\u0000\u0000"+
		"ef\u0005*\u0000\u0000fj\u0001\u0000\u0000\u0000gi\t\u0000\u0000\u0000"+
		"hg\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000km\u0001\u0000\u0000\u0000lj\u0001\u0000"+
		"\u0000\u0000mn\u0005*\u0000\u0000no\u0005/\u0000\u0000op\u0001\u0000\u0000"+
		"\u0000pq\u0006\u0007\u0000\u0000q\u0010\u0001\u0000\u0000\u0000rt\u0007"+
		"\u0005\u0000\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0006\b\u0000\u0000x\u0012\u0001\u0000\u0000\u0000y|\u0003\u0001"+
		"\u0000\u0000z|\u0005_\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001\u0000"+
		"\u0000\u0000|\u0082\u0001\u0000\u0000\u0000}\u0081\u0003\u0001\u0000\u0000"+
		"~\u0081\u0003\u0003\u0001\u0000\u007f\u0081\u0005_\u0000\u0000\u0080}"+
		"\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0014\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"\'\u0000\u0000\u0086\u0087\t\u0000\u0000\u0000\u0087\u0097\u0005\'\u0000"+
		"\u0000\u0088\u0089\u0005\'\u0000\u0000\u0089\u008a\u0005\\\u0000\u0000"+
		"\u008a\u008b\u0005n\u0000\u0000\u008b\u0097\u0005\'\u0000\u0000\u008c"+
		"\u008d\u0005\'\u0000\u0000\u008d\u008e\u0005\\\u0000\u0000\u008e\u008f"+
		"\u0005t\u0000\u0000\u008f\u0097\u0005\'\u0000\u0000\u0090\u0091\u0005"+
		"\'\u0000\u0000\u0091\u0092\u0005\\\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0003\t\u0004\u0000\u0094\u0095\u0005\'\u0000"+
		"\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096\u0085\u0001\u0000\u0000"+
		"\u0000\u0096\u0088\u0001\u0000\u0000\u0000\u0096\u008c\u0001\u0000\u0000"+
		"\u0000\u0096\u0090\u0001\u0000\u0000\u0000\u0097\u0016\u0001\u0000\u0000"+
		"\u0000\u0014\u0000\u001f%,/6<>DHLQY`ju{\u0080\u0082\u0096\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}