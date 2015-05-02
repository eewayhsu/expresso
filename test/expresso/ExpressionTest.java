package expresso;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.swing.JDialog;

import expresso.parser.*;

import org.antlr.v4.runtime.*;
import org.antlr.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

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
        parse("");
    }
    
    @Test
    public void testSinglePair() {
        parse("()");
    }
    
    @Test
    public void testTwoPair() {
        parse("()()");
    }
    
    @Test
    public void testThreeBalancedSequence() {
        parse("()(((())))(())");
    }
    
    @Test(expected=RecognitionException.class)
    public void testSingleUnbalanced() {
        parse("(");
    }
    
    @Test(expected=RecognitionException.class)
    public void testOneAndHalfUnbalanced() {
        parse("(()");
    }

    private void parse(String string) throws RecognitionException {
        CharStream stream = new ANTLRInputStream(string);
        ExpressionLexer lexer = new ExpressionLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        ParseTree tree = parser.warmup();
        System.err.println(tree.toStringTree(parser));
        if (DISPLAY_GRAPHICS) {
          try {
              Future<JDialog> future = ((RuleContext)tree).inspect(parser);
              Utils.waitForClose(future.get());
          } catch (InterruptedException e) {
              e.printStackTrace();
          } catch (ExecutionException e) {
              e.printStackTrace();
          }
        }
    }
}
