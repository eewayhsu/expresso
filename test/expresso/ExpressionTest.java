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
    private static final boolean DISPLAY_GRAPHICS = true;
    
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
    
    @Test(expected=RuntimeException.class)
    public void testSingleUnbalanced() {
        parse("(");
    }
    
    @Test(expected=RuntimeException.class)
    public void testOneAndHalfUnbalanced() {
        parse("(()");
    }
    
    @Test
    public void testExpression() {
        parse("(3+5*6)+4*3");
    }
    
    @Test
    public void testExpressionWithTwo() {
        parse("1+2+3");
    }
    
    @Test
    public void testVariableExpression() {
        parse("abc");
    }

    private void parse(String string) {
        CharStream stream = new ANTLRInputStream(string);

        // Instantiate lexer
        ExpressionLexer lexer = new ExpressionLexer(stream);
        lexer.reportErrorsAsExceptions();

        TokenStream tokens = new CommonTokenStream(lexer);

        // Instantiate parser
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.reportErrorsAsExceptions();

        ParseTree tree = parser.root();

        if (DISPLAY_GRAPHICS) {
          try {
            System.out.println(tree.toStringTree(parser));
            Future<JDialog> future = ((RuleContext)tree).inspect(parser);
            Utils.waitForClose(future.get());
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
    }
}
