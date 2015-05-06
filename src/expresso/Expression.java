package expresso;

import java.util.ArrayList;
import java.util.List;

import expresso.parser.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Expression represents a mathematical expression.  This is a immutable recursive abstract datatype. 
 */
public interface Expression {
    
    // Datatype definition
    //   Expression = Constant(value:double)
    //                  + Variable(value:String)
    //                  + MultiplicationExpression(left:Expression, right:Expression)
    //                  + AdditionExpression(left:Expression, right:Expression)
    
    public enum ExpressionType {
        VARIABLE, CONSTANT, ADDITION_EXPRESSION, MULTIPLICATION_EXPRESSION;
    }
    
    /**
     * Parse an expression.  
     * TODO: actually throw illegal argument exception
     *
     * @param String input              Expression to parse
     * @return Expression expression    AST for the input
     * @throws IllegalArgumentException If the expression is invalid
     */
    public static Expression parse(String input) {
        CharStream stream = new ANTLRInputStream(input);

        // Instantiate lexer
        ExpressionLexer lexer = new ExpressionLexer(stream);
        lexer.reportErrorsAsExceptions();

        TokenStream tokens = new CommonTokenStream(lexer);

        // Instantiate parser
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.reportErrorsAsExceptions();

        ParseTree expressionTree = parser.root();
        ParseTreeWalker walker = new ParseTreeWalker();

        ExpressionListenerExpressionCreator listener = new ExpressionListenerExpressionCreator();
        walker.walk(listener, expressionTree);
        
        return listener.getExpression();

    }
    
    // Instance methods
    
    /**
     * Returns an algebraically equivalent expression that consists of a sum of products.
     * Expands by distributing terms first from left to right, then from right to left.
     * 
     * @return an algebraically equivalent expression that consists of a sum of products
     */
    public Expression expand();
    
    /**
     * Returns corresponding ExpressionType
     * 
     * @return corresponding ExpressionType
     */
    public ExpressionType getType();
}
