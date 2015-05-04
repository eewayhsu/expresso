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
     * If the child of the root_expression is a literal, push it into the stack;
     * this passes the literal into its ancestor Expression's constructor
     * The method is called when exiting a root_expression node. By design, the
     * ancestor Expression is either a MultiplicationExpression or an 
     * AdditionExpression.
     * If the child of the root_expression isn't a literal, then it is either a
     * MultiplicationExpression or AdditionExpression. We can skip in this case
     * because the listener pushes the ME or AE into the stack when it visits the
     * corresponding node.
     * A root expression can only have one child, by design.
     * 
     * @param ctx root_expression context
     */
    public void exitRootExpression(Root_expressionContext ctx) {
        
    }

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
     * If the child of the paren_expression is a literal, push it into the stack;
     * this passes the literal into its ancestor Expression's constructor
     * The method is called when exiting a paren_expression node. By design, the
     * ancestor Expression is either a MultiplicationExpression or an 
     * AdditionExpression.
     * If the child of the paren_expression isn't a literal, then it is either a
     * MultiplicationExpression or AdditionExpression. We can skip in this case
     * because the listener pushes the ME or AE into the stack when it visits the
     * corresponding node.
     * A paren expression can only have one child, by design.
     * 
     * @param ctx paren_expression context
     */
    public void exitParenExpression(Paren_expressionContext ctx) {
        
    }
    
    /**
     * Passes children into MultiplicationExpression when exiting mult_expression node.
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
