package expresso.parser;

import java.util.Stack;

import org.antlr.v4.runtime.tree.TerminalNode;

import expresso.Expression;
import expresso.parser.ExpressionParser.*;

/**
 * This class creates an Expression tree while it's walking over the parse tree.
 */
public class ExpressionListenerExpressionCreator extends ExpressionBaseListener {
    
    private Stack<Expression> stack = new Stack<Expression>();
    
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
     * Pass children of root_expression into parent Expression when exiting root_expression node.
     * Parent Expression is either a MultiplicationExpression or AdditionExpression.
     * Children of root_expression can be MultiplicationExpressions, AdditionExpressions, Variables, or Constants.
     * Only has one child.
     * 
     * @param ctx root_expression context
     */
    public void exitRootExpression(Root_expressionContext ctx) {
        
    }
    
    /**
     * Do nothing when exiting expression node.
     */
    public void exitExpression(ExpressionContext ctx) {
        
    }
    
    /**
     * Do nothing when exiting paren_expression node.
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
        
    }
    
    /**
     * Passes children into AdditionExpression when exiting add_expression node.
     * Children expressions can be MultiplicationExpressions, AdditionExpressions, Variables, or Constants.
     * 
     * @param ctx add_expression context
     */
    public void exitAdditionExpression(Add_expressionContext ctx) {
        
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
