// Generated from Expression.g4 by ANTLR 4.5

package expresso.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MULTIPLY=2, VARIABLE=3, CONSTANT=4, LEFT_PAREN=5, RIGHT_PAREN=6, 
		WHITESPACE=7;
	public static final int
		RULE_root = 0, RULE_warmup = 1, RULE_line = 2, RULE_file = 3, RULE_expression = 4, 
		RULE_bead = 5, RULE_chain = 6, RULE_operation = 7;
	public static final String[] ruleNames = {
		"root", "warmup", "line", "file", "expression", "bead", "chain", "operation"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'*'", null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PLUS", "MULTIPLY", "VARIABLE", "CONSTANT", "LEFT_PAREN", "RIGHT_PAREN", 
		"WHITESPACE"
	};
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
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    // This method makes the lexer or parser stop running if it encounters
	    // invalid input and throw a RuntimeException.
	    public void reportErrorsAsExceptions() {
	        removeErrorListeners();
	        addErrorListener(new ExceptionThrowingErrorListener());
	    }
	    
	    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
	        @Override
	        public void syntaxError(Recognizer<?, ?> recognizer,
	                Object offendingSymbol, int line, int charPositionInLine,
	                String msg, RecognitionException e) {
	            throw new RuntimeException(msg);
	        }
	    }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public WarmupContext warmup() {
			return getRuleContext(WarmupContext.class,0);
		}
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			setState(18);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				warmup();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				file();
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

	public static class WarmupContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public WarmupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_warmup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterWarmup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitWarmup(this);
		}
	}

	public final WarmupContext warmup() throws RecognitionException {
		WarmupContext _localctx = new WarmupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_warmup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(20);
				line();
				}
			}

			setState(23);
			match(EOF);
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

	public static class LineContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(ExpressionParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(ExpressionParser.RIGHT_PAREN, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_line);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(LEFT_PAREN);
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFT_PAREN) {
				{
				{
				setState(26);
				line();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(RIGHT_PAREN);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(33);
					line();
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VARIABLE) | (1L << CONSTANT) | (1L << LEFT_PAREN))) != 0)) {
				{
				setState(39);
				expression();
				}
			}

			setState(42);
			match(EOF);
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

	public static class ExpressionContext extends ParserRuleContext {
		public BeadContext bead() {
			return getRuleContext(BeadContext.class,0);
		}
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		try {
			setState(46);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				bead();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				chain();
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

	public static class BeadContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(ExpressionParser.VARIABLE, 0); }
		public TerminalNode CONSTANT() { return getToken(ExpressionParser.CONSTANT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(ExpressionParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(ExpressionParser.RIGHT_PAREN, 0); }
		public BeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterBead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitBead(this);
		}
	}

	public final BeadContext bead() throws RecognitionException {
		BeadContext _localctx = new BeadContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bead);
		try {
			setState(54);
			switch (_input.LA(1)) {
			case VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(VARIABLE);
				}
				break;
			case CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(CONSTANT);
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				match(LEFT_PAREN);
				setState(51);
				expression();
				setState(52);
				match(RIGHT_PAREN);
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

	public static class ChainContext extends ParserRuleContext {
		public List<BeadContext> bead() {
			return getRuleContexts(BeadContext.class);
		}
		public BeadContext bead(int i) {
			return getRuleContext(BeadContext.class,i);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public ChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitChain(this);
		}
	}

	public final ChainContext chain() throws RecognitionException {
		ChainContext _localctx = new ChainContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_chain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(56);
					bead();
					setState(57);
					operation();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(61); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(63);
			bead();
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

	public static class OperationContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ExpressionParser.PLUS, 0); }
		public TerminalNode MULTIPLY() { return getToken(ExpressionParser.MULTIPLY, 0); }
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitOperation(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MULTIPLY) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\tF\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\5\2\25\n\2"+
		"\3\3\5\3\30\n\3\3\3\3\3\3\4\3\4\7\4\36\n\4\f\4\16\4!\13\4\3\4\3\4\7\4"+
		"%\n\4\f\4\16\4(\13\4\3\5\5\5+\n\5\3\5\3\5\3\6\3\6\5\6\61\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\79\n\7\3\b\3\b\3\b\6\b>\n\b\r\b\16\b?\3\b\3\b\3\t\3\t"+
		"\3\t\2\2\n\2\4\6\b\n\f\16\20\2\3\3\2\3\4F\2\24\3\2\2\2\4\27\3\2\2\2\6"+
		"\33\3\2\2\2\b*\3\2\2\2\n\60\3\2\2\2\f8\3\2\2\2\16=\3\2\2\2\20C\3\2\2\2"+
		"\22\25\5\4\3\2\23\25\5\b\5\2\24\22\3\2\2\2\24\23\3\2\2\2\25\3\3\2\2\2"+
		"\26\30\5\6\4\2\27\26\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2\31\32\7\2\2\3"+
		"\32\5\3\2\2\2\33\37\7\7\2\2\34\36\5\6\4\2\35\34\3\2\2\2\36!\3\2\2\2\37"+
		"\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"&\7\b\2\2#%\5\6\4\2$#"+
		"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\7\3\2\2\2(&\3\2\2\2)+\5\n\6"+
		"\2*)\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\2\2\3-\t\3\2\2\2.\61\5\f\7\2/\61"+
		"\5\16\b\2\60.\3\2\2\2\60/\3\2\2\2\61\13\3\2\2\2\629\7\5\2\2\639\7\6\2"+
		"\2\64\65\7\7\2\2\65\66\5\n\6\2\66\67\7\b\2\2\679\3\2\2\28\62\3\2\2\28"+
		"\63\3\2\2\28\64\3\2\2\29\r\3\2\2\2:;\5\f\7\2;<\5\20\t\2<>\3\2\2\2=:\3"+
		"\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\5\f\7\2B\17\3\2\2\2C"+
		"D\t\2\2\2D\21\3\2\2\2\n\24\27\37&*\608?";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}