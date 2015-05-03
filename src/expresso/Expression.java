package expresso;

import expresso.parser.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Expression represents a mathematical expression.
 */
public interface Expression {
    
    // Datatype definition
    //   Expression = Constant(value:double)
    //                  + Variable(value:String)
    //                  + MultiplicationExpression(left:Expression, right:Expression)
    //                  + AdditionExpression(left:Expression, right:Expression)
    
    /**
     * Parse an expression.  
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

        ExpressionListener listener = new ExpressionListenerExpressionCreator();
        walker.walk(listener, expressionTree);

        throw new RuntimeException("unimplemented");
    }
    
    // Instance methods
    /**
     * Returns simplified expression
     * 
     * @return simplified expression
     */
    public Expression simplify();
    
    /**
     * Returns differentiated expression
     * 
     * @return differentiated expression
     */
    public Expression differentiate();
}
