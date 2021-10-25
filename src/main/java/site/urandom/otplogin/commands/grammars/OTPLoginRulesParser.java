// Generated from /Users/fanghr/Developer/OTPLogin/src/main/java/site/urandom/otplogin/commands/grammars/OTPLoginRules.g4 by ANTLR 4.9.1
package site.urandom.otplogin.commands.grammars;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OTPLoginRulesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, DIGIT=2, OTP=3, SETUP=4, LOGIN=5, VERIFY=6;
	public static final int
		RULE_setup = 0, RULE_login = 1, RULE_verify = 2, RULE_subcommand = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"setup", "login", "verify", "subcommand"
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

	@Override
	public String getGrammarFileName() { return "OTPLoginRules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OTPLoginRulesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SetupContext extends ParserRuleContext {
		public TerminalNode SETUP() { return getToken(OTPLoginRulesParser.SETUP, 0); }
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OTPLoginRulesListener ) ((OTPLoginRulesListener)listener).enterSetup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OTPLoginRulesListener ) ((OTPLoginRulesListener)listener).exitSetup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OTPLoginRulesVisitor ) return ((OTPLoginRulesVisitor<? extends T>)visitor).visitSetup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(SETUP);
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

	public static class LoginContext extends ParserRuleContext {
		public Token code;
		public TerminalNode LOGIN() { return getToken(OTPLoginRulesParser.LOGIN, 0); }
		public TerminalNode OTP() { return getToken(OTPLoginRulesParser.OTP, 0); }
		public LoginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_login; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OTPLoginRulesListener ) ((OTPLoginRulesListener)listener).enterLogin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OTPLoginRulesListener ) ((OTPLoginRulesListener)listener).exitLogin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OTPLoginRulesVisitor ) return ((OTPLoginRulesVisitor<? extends T>)visitor).visitLogin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoginContext login() throws RecognitionException {
		LoginContext _localctx = new LoginContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_login);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			match(LOGIN);
			setState(11);
			((LoginContext)_localctx).code = match(OTP);
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

	public static class VerifyContext extends ParserRuleContext {
		public Token code;
		public TerminalNode VERIFY() { return getToken(OTPLoginRulesParser.VERIFY, 0); }
		public TerminalNode OTP() { return getToken(OTPLoginRulesParser.OTP, 0); }
		public VerifyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verify; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OTPLoginRulesListener ) ((OTPLoginRulesListener)listener).enterVerify(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OTPLoginRulesListener ) ((OTPLoginRulesListener)listener).exitVerify(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OTPLoginRulesVisitor ) return ((OTPLoginRulesVisitor<? extends T>)visitor).visitVerify(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerifyContext verify() throws RecognitionException {
		VerifyContext _localctx = new VerifyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_verify);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			match(VERIFY);
			setState(14);
			((VerifyContext)_localctx).code = match(OTP);
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

	public static class SubcommandContext extends ParserRuleContext {
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public LoginContext login() {
			return getRuleContext(LoginContext.class,0);
		}
		public VerifyContext verify() {
			return getRuleContext(VerifyContext.class,0);
		}
		public SubcommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subcommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OTPLoginRulesListener ) ((OTPLoginRulesListener)listener).enterSubcommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OTPLoginRulesListener ) ((OTPLoginRulesListener)listener).exitSubcommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OTPLoginRulesVisitor ) return ((OTPLoginRulesVisitor<? extends T>)visitor).visitSubcommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubcommandContext subcommand() throws RecognitionException {
		SubcommandContext _localctx = new SubcommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_subcommand);
		try {
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SETUP:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				setup();
				}
				break;
			case LOGIN:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				login();
				}
				break;
			case VERIFY:
				enterOuterAlt(_localctx, 3);
				{
				setState(18);
				verify();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b\30\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\5\5\26"+
		"\n\5\3\5\2\2\6\2\4\6\b\2\2\2\25\2\n\3\2\2\2\4\f\3\2\2\2\6\17\3\2\2\2\b"+
		"\25\3\2\2\2\n\13\7\6\2\2\13\3\3\2\2\2\f\r\7\7\2\2\r\16\7\5\2\2\16\5\3"+
		"\2\2\2\17\20\7\b\2\2\20\21\7\5\2\2\21\7\3\2\2\2\22\26\5\2\2\2\23\26\5"+
		"\4\3\2\24\26\5\6\4\2\25\22\3\2\2\2\25\23\3\2\2\2\25\24\3\2\2\2\26\t\3"+
		"\2\2\2\3\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}