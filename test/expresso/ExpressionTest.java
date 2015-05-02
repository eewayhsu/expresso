package expresso;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.swing.JDialog;

import expresso.parser.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/*
 * This class contains tests for the language of balanced parentheses.
 */
public class ExpressionTest {
    /*
     *  Test strategy for expression parser (parentheses only):
     *  
     *  Partitions:
     *  - balanced or unbalanced pairs
     *  - sequence of 0, 1, 2+ pairs
     * 
     *  Test cases:
     *  - empty string
     *  - () a single balanced pair
     *  - ()() two balanced pairs
     *  - ()(((())))(()) three balanced sequences
     *  - ( a single unbalanced pair
     *  - (() one and a half pairs
     */
    private static final Boolean DISPLAY_GRAPHICS = false;
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testEmptyString() {
        assert parse("");
    }
    
    @Test
    public void testSinglePair() {
        assert parse("()");
    }
    
    @Test
    public void testTwoPair() {
        assert parse("()()");
    }
    
    @Test
    public void testThreeBalancedSequence() {
        assert parse("()(((())))(())");
    }
    
    @Test
    public void testSingleUnbalanced() {
        assertFalse(parse("("));
    }
    
    @Test
    public void testOneAndHalfUnbalanced() {
        assertFalse(parse("(()"));
    }

    private Boolean parse(String string) {
        CharStream stream = new ANTLRInputStream(string);

        // Instatiate lexer
        ExpressionLexer lexer = new ExpressionLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ThrowingErrorListener());

        TokenStream tokens = new CommonTokenStream(lexer);

        // Instatiate parser
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ThrowingErrorListener());

        try {
          ParseTree tree = parser.root();
          if (DISPLAY_GRAPHICS) {
            System.out.println(tree.toStringTree(parser));
            Future<JDialog> future = ((RuleContext)tree).inspect(parser);
            Utils.waitForClose(future.get());
          }
        } catch (ParseCancellationException pce) {
          return false;
        } catch (Exception e) {
          e.printStackTrace();
        }
        return true;
    }

    public class ThrowingErrorListener extends BaseErrorListener {
       @Override
       public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
          throws ParseCancellationException {
             throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
          }
    }

}
