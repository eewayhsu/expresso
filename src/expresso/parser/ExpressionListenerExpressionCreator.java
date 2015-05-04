package expresso.parser;

import java.util.Stack;

import expresso.*;
import expresso.parser.ExpressionParser.*;

/**
 * This class represents a listener that extends {@link ExpressionBaseListener}
 * An instance of ExpressionListenerExpressionCreator is passed into a parse
 * tree's walker method, and the listener methods are fired everytime the walk
 * visits a node of a specific type. Only a subset of nodes have listener methods
 * attached. 
 * Upon concluding the walk, a tree of Expression nodes is created, and can be 
 * accessed by calling getExpression()
 */
public class ExpressionListenerExpressionCreator extends ExpressionBaseListener {
    
    private final Stack<Expression> stack = new Stack<Expression>();
    
    /**
     * Do nothing when exiting root node.
     */
    public void exitRoot(RootContext ctx) {
        assert stack.size() == 1;
    }
    
    /**
     * Do nothing when exiting file node.
     */
    public void exitFile(FileContext ctx) {
        assert stack.size() == 1;
    }
    
    /**
     * If the node is a literal, push it into the stack; this passes the literal
     * into its ancestor Expression's constructor. By design, the ancestor
     * Expression is either a MultiplicationExpression or an AdditionExpression.
     *
     * This method is fired whenever the walker exits a literal node
     *
     * @param ctx root_expression context
     */
    public void exitLiteral(LiteralContext ctx) {
        String token = ctx.getText();
        if (token.matches("[a-zA-Z]+")) {
            Expression variable = new Variable(token);
            stack.push(variable);
        } else {
            Expression constant = new Constant(Double.valueOf(token));
            stack.push(constant);
        }
    }
    
    /**
     * Passes children into MultiplicationExpression 
     * If the node is a mult_expression, push it into the stack; this passes it
     * into its ancestor Expression's constructor. By design, the ancestor
     * Expression is either a MultiplicationExpression or an AdditionExpression.
     * 
     * Children expressions can be MultiplicationExpressions, Variables, or Constants.
     * 
     * @param ctx mult_expression context
     */
    public void exitMultiplicationExpression(Mult_expressionContext ctx) {
        Expression rightExpression = stack.pop();
        Expression leftExpression = stack.pop();
        Expression multiplicationExpression = new MultiplicationExpression(leftExpression, rightExpression);
        stack.push(multiplicationExpression);
    }
    
    /**
     * Passes children into AdditionExpression when exiting add_expression node.
     * Children expressions can be MultiplicationExpressions, AdditionExpressions, Variables, or Constants.
     * 
     * @param ctx add_expression context
     */
    public void exitAdditionExpression(Add_expressionContext ctx) {
        Expression rightExpression = stack.pop();
        Expression leftExpression = stack.pop();
        Expression additionExpression = new AdditionExpression(leftExpression, rightExpression);
        stack.push(additionExpression);
    }
    
    /**
     * Returns Expression type represented by given ParseTree
     * 
     * @return expression
     */
    public Expression getExpression() {
        return stack.get(0);
    }
}
