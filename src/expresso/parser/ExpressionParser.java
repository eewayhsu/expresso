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
		RULE_root = 0, RULE_warmup = 1, RULE_line = 2, RULE_file = 3, RULE_root_expression = 4, 
		RULE_expression = 5, RULE_paren_expression = 6, RULE_mult_expression = 7, 
		RULE_add_expression = 8;
	public static final String[] ruleNames = {
		"root", "warmup", "line", "file", "root_expression", "expression", "paren_expression", 
		"mult_expression", "add_expression"
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
			setState(20);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				warmup();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
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
			setState(23);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(22);
				line();
				}
			}

			setState(25);
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
			setState(27);
			match(LEFT_PAREN);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFT_PAREN) {
				{
				{
				setState(28);
				line();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(RIGHT_PAREN);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(35);
					line();
					}
					} 
				}
				setState(40);
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
			setState(42);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VARIABLE) | (1L << CONSTANT) | (1L << LEFT_PAREN))) != 0)) {
				{
				setState(41);
				expression();
				}
			}

			setState(44);
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

	public static class Root_expressionContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(ExpressionParser.VARIABLE, 0); }
		public TerminalNode CONSTANT() { return getToken(ExpressionParser.CONSTANT, 0); }
		public Paren_expressionContext paren_expression() {
			return getRuleContext(Paren_expressionContext.class,0);
		}
		public Root_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterRoot_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitRoot_expression(this);
		}
	}

	public final Root_expressionContext root_expression() throws RecognitionException {
		Root_expressionContext _localctx = new Root_expressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_root_expression);
		try {
			setState(49);
			switch (_input.LA(1)) {
			case VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(VARIABLE);
				}
				break;
			case CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(CONSTANT);
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				paren_expression();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Root_expressionContext root_expression() {
			return getRuleContext(Root_expressionContext.class,0);
		}
		public Mult_expressionContext mult_expression() {
			return getRuleContext(Mult_expressionContext.class,0);
		}
		public Add_expressionContext add_expression() {
			return getRuleContext(Add_expressionContext.class,0);
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
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(54);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				root_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				mult_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				add_expression();
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

	public static class Paren_expressionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(ExpressionParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(ExpressionParser.RIGHT_PAREN, 0); }
		public Paren_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paren_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterParen_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitParen_expression(this);
		}
	}

	public final Paren_expressionContext paren_expression() throws RecognitionException {
		Paren_expressionContext _localctx = new Paren_expressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_paren_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(LEFT_PAREN);
			setState(57);
			expression();
			setState(58);
			match(RIGHT_PAREN);
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

	public static class Mult_expressionContext extends ParserRuleContext {
		public List<Root_expressionContext> root_expression() {
			return getRuleContexts(Root_expressionContext.class);
		}
		public Root_expressionContext root_expression(int i) {
			return getRuleContext(Root_expressionContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(ExpressionParser.MULTIPLY, 0); }
		public Mult_expressionContext mult_expression() {
			return getRuleContext(Mult_expressionContext.class,0);
		}
		public Mult_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterMult_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitMult_expression(this);
		}
	}

	public final Mult_expressionContext mult_expression() throws RecognitionException {
		Mult_expressionContext _localctx = new Mult_expressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_mult_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			root_expression();
			setState(61);
			match(MULTIPLY);
			setState(64);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(62);
				root_expression();
				}
				break;
			case 2:
				{
				setState(63);
				mult_expression();
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

	public static class Add_expressionContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ExpressionParser.PLUS, 0); }
		public List<Root_expressionContext> root_expression() {
			return getRuleContexts(Root_expressionContext.class);
		}
		public Root_expressionContext root_expression(int i) {
			return getRuleContext(Root_expressionContext.class,i);
		}
		public List<Mult_expressionContext> mult_expression() {
			return getRuleContexts(Mult_expressionContext.class);
		}
		public Mult_expressionContext mult_expression(int i) {
			return getRuleContext(Mult_expressionContext.class,i);
		}
		public Add_expressionContext add_expression() {
			return getRuleContext(Add_expressionContext.class,0);
		}
		public Add_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAdd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAdd_expression(this);
		}
	}

	public final Add_expressionContext add_expression() throws RecognitionException {
		Add_expressionContext _localctx = new Add_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_add_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(66);
				root_expression();
				}
				break;
			case 2:
				{
				setState(67);
				mult_expression();
				}
				break;
			}
			setState(70);
			match(PLUS);
			setState(74);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(71);
				root_expression();
				}
				break;
			case 2:
				{
				setState(72);
				mult_expression();
				}
				break;
			case 3:
				{
				setState(73);
				add_expression();
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\tO\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\5\2"+
		"\27\n\2\3\3\5\3\32\n\3\3\3\3\3\3\4\3\4\7\4 \n\4\f\4\16\4#\13\4\3\4\3\4"+
		"\7\4\'\n\4\f\4\16\4*\13\4\3\5\5\5-\n\5\3\5\3\5\3\6\3\6\3\6\5\6\64\n\6"+
		"\3\7\3\7\3\7\5\79\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\tC\n\t\3\n\3\n"+
		"\5\nG\n\n\3\n\3\n\3\n\3\n\5\nM\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2"+
		"R\2\26\3\2\2\2\4\31\3\2\2\2\6\35\3\2\2\2\b,\3\2\2\2\n\63\3\2\2\2\f8\3"+
		"\2\2\2\16:\3\2\2\2\20>\3\2\2\2\22F\3\2\2\2\24\27\5\4\3\2\25\27\5\b\5\2"+
		"\26\24\3\2\2\2\26\25\3\2\2\2\27\3\3\2\2\2\30\32\5\6\4\2\31\30\3\2\2\2"+
		"\31\32\3\2\2\2\32\33\3\2\2\2\33\34\7\2\2\3\34\5\3\2\2\2\35!\7\7\2\2\36"+
		" \5\6\4\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!"+
		"\3\2\2\2$(\7\b\2\2%\'\5\6\4\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2"+
		")\7\3\2\2\2*(\3\2\2\2+-\5\f\7\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\2\2"+
		"\3/\t\3\2\2\2\60\64\7\5\2\2\61\64\7\6\2\2\62\64\5\16\b\2\63\60\3\2\2\2"+
		"\63\61\3\2\2\2\63\62\3\2\2\2\64\13\3\2\2\2\659\5\n\6\2\669\5\20\t\2\67"+
		"9\5\22\n\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29\r\3\2\2\2:;\7\7\2\2;<"+
		"\5\f\7\2<=\7\b\2\2=\17\3\2\2\2>?\5\n\6\2?B\7\4\2\2@C\5\n\6\2AC\5\20\t"+
		"\2B@\3\2\2\2BA\3\2\2\2C\21\3\2\2\2DG\5\n\6\2EG\5\20\t\2FD\3\2\2\2FE\3"+
		"\2\2\2GH\3\2\2\2HL\7\3\2\2IM\5\n\6\2JM\5\20\t\2KM\5\22\n\2LI\3\2\2\2L"+
		"J\3\2\2\2LK\3\2\2\2M\23\3\2\2\2\f\26\31!(,\638BFL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}