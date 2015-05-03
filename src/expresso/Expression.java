package expresso;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import expresso.parser.ExpressionListener;
import expresso.parser.ExpressionListenerExpressionCreator;

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
     * @param input expression to parse
     * @return expression AST for the input
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static Expression parse(ParseTree expressionTree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionListener listener = new ExpressionListenerExpressionCreator();
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
