package expresso;

import expresso.parser.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.swing.JDialog;

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
    
    /*
     * Test strategy for expression parser:
     * 
     * Partitions:
     * - valid, invalid input
     * - 0, 1, 2+ addition operations
     * - 0, 1, 2+ multiplication operations
     * - 0, 1, 2+ variables (length 1, 1+)
     * - 0, 1, 2+ constants (integer, float)
     * - sequence of parentheses
     * - nested parentheses
     * - unbalanced parentheses
     * - missing operation
     * - missing variable/constant
     * - no whitespaces
     * - begin, middle, end whitespaces
     * 
     * Test cases:
     * - 3 + 2.4
     * - 3 * x + 2.4
     * - 3 * (x + 2.4)
     * - ((3 + 4) * x * x)
     * - foo + bar+baz
     * - (2*x    )+    (    y*x    )
     * - 4 + 3 * x + 2 * x * x + 1 * x * x * (((x)))
     * - 3 *
     * - ( 3
     * - 3 x
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
    public void testExpressionAddConstants() {
        parse("3 + 2.4");
    }
    
    @Test
    public void testExpressionAddMultiplyConstantVariable() {
        parse("3 * x + 2.4");
    }
    
    @Test
    public void testExpressionParentheses() {
        parse("3 * (x + 2.4)");
    }
    
    @Test
    public void testExpressionNestedParentheses() {
        parse("((3 + 4) * x * x)");
    }
    
    @Test
    public void testExpressionVariablesOnly() {
        parse("foo + bar+baz");
    }
    
    @Test
    public void testExpressionMultiply() {
        parse("(3+5*6)*4*3");
    }
    
    @Test
    public void testExpressionMultiplyPlus() {
        parse("(3+5*6)*4*3+3");
    }
    
    
    @Test
    public void testExpressionWithTwo() {
        parse("1+2+3");
    }
    
    @Test
    public void testExpressionWithDoubles() {
        parse("1.0+2+3");
    }
    
    @Test
    public void testVariableExpression() {
        parse("abc");
    }

        
    public void testExpressionSequenceParentheses() {
        parse("(2*x    )+    (    y*x    )");
    }
    
    @Test
    public void testComplicatedExpression() {
        Expression.parse("4 + 3 * x + 2 * x * x + 1 * x * x * (((x)))");
    }
    
    @Test(expected=RuntimeException.class)
    public void testExpressionMissingConstant() {
        parse("3 *");
    }
    
    @Test(expected=RuntimeException.class)
    public void testExpressionUnbalancedParentheses() {
        parse("( 3");
    }
    
    @Test(expected=RuntimeException.class)
    public void testExpressionMissingOperation() {
        parse("3 x");
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
