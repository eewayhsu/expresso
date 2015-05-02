package expresso;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.swing.JDialog;

import expresso.parser.*;

import org.antlr.v4.runtime.*;
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
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testEmptyString() {
        CharStream stream = new ANTLRInputStream("");
        parse(stream);
    }
    
    @Test
    public void testSinglePair() {
        CharStream stream = new ANTLRInputStream("()");
        parse(stream);
    }
    
    @Test
    public void testTwoPair() {
        CharStream stream = new ANTLRInputStream("()()");
        parse(stream);
    }
    
    @Test
    public void testThreeBalancedSequence() {
        CharStream stream = new ANTLRInputStream("()(((())))(())");
        parse(stream);
    }
    
    @Test
    public void testSingleUnbalanced() {
        CharStream stream = new ANTLRInputStream("(");
        parse(stream);
    }
    
    @Test
    public void testOneAndHalfUnbalanced() {
        CharStream stream = new ANTLRInputStream("(()");
        parse(stream);
    }

    private void parse(CharStream stream) {
        ExpressionLexer lexer = new ExpressionLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        ParseTree tree = parser.warmup();
        System.err.println(tree.toStringTree(parser));
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