// Generated from /Users/fanghr/Developer/OTPLogin/src/main/java/site/urandom/otplogin/commands/grammars/OTPLoginRules.g4 by ANTLR 4.9.1
package site.urandom.otplogin.commands.grammars;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OTPLoginRulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, DIGIT=2, OTP=3, SETUP=4, LOGIN=5, VERIFY=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "DIGIT", "BLOCK", "OTP", "SETUP", "LOGIN", "VERIFY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'setup'", "'login'", "'verify'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "DIGIT", "OTP", "SETUP", "LOGIN", "VERIFY"
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


	public OTPLoginRulesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "OTPLoginRules.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b9\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\2\2\t\3\3\5\4\7\2\t\5\13\6\r\7\17\b\3\2\5\5\2\13\f\17\17\"\"\3\2"+
		"\62;\5\2\62;C\\c|\28\2\3\3\2\2\2\2\5\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\3\22\3\2\2\2\5\30\3\2\2\2\7\32\3\2\2\2\t\37"+
		"\3\2\2\2\13&\3\2\2\2\r,\3\2\2\2\17\62\3\2\2\2\21\23\t\2\2\2\22\21\3\2"+
		"\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\26\3\2\2\2\26\27\b\2"+
		"\2\2\27\4\3\2\2\2\30\31\t\3\2\2\31\6\3\2\2\2\32\33\t\4\2\2\33\34\t\4\2"+
		"\2\34\35\t\4\2\2\35\36\t\4\2\2\36\b\3\2\2\2\37 \5\5\3\2 !\5\5\3\2!\"\5"+
		"\5\3\2\"#\5\5\3\2#$\5\5\3\2$%\5\5\3\2%\n\3\2\2\2&\'\7u\2\2\'(\7g\2\2("+
		")\7v\2\2)*\7w\2\2*+\7r\2\2+\f\3\2\2\2,-\7n\2\2-.\7q\2\2./\7i\2\2/\60\7"+
		"k\2\2\60\61\7p\2\2\61\16\3\2\2\2\62\63\7x\2\2\63\64\7g\2\2\64\65\7t\2"+
		"\2\65\66\7k\2\2\66\67\7h\2\2\678\7{\2\28\20\3\2\2\2\4\2\24\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}