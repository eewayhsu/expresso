package expresso;

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
    public static Expression parse(String input) {
        throw new RuntimeException("unimplemented");
    }
    
    // Instance methods
    public Expression simplify();
    public Expression differentiate();
}
