package expresso;

import expresso.Expression.ExpressionType;

/**
 * MultiplicationExpression is an immutable type representing a multiplication expression.
 */
public class MultiplicationExpression implements Expression {
    
    private final Expression left;
    private final Expression right;
    
    /* Abstraction function
     *      left -> the multiplicand (expression prior to '*') of a mathematical expression 
     *      right -> the multiplier (expression post '*') of a mathematical expression
     *      
     * Rep invariant
     *      left and right not null
     *      
     * Safety from rep exposure
     *      left and right are both immutable, so there is no risk of rep exposure.
     */
    
    /**
     * Creates a multiplication expression with given left and right expressions.
     * 
     * @param left  left expression
     * @param right right expression
     */
    public MultiplicationExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        checkRep();
    }
    
    /**
     * Returns left expression
     * 
     * @return left expression
     */
    public Expression getLeft() {
        return left;
    }
    
    /**
     * Returns right expression
     * 
     * @return right expression
     */
    public Expression getRight() {
        return right;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MultiplicationExpression) {
          MultiplicationExpression expression = (MultiplicationExpression) obj;
          return expression.getLeft().equals(left) & expression.getRight().equals(right);
        } else {
          return false;
        }
    }
    
    @Override
    public int hashCode() {
        return 37;
    }
    
    private void checkRep() {
        assert left != null;
        assert right != null;
    }

    @Override
    public Expression expand() {
        if (right.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            Expression newLeft = new MultiplicationExpression(left, ((AdditionExpression) right).getLeft());
            Expression newRight = new MultiplicationExpression(left, ((AdditionExpression) right).getRight());
            return new AdditionExpression(newLeft.expand(), newRight.expand());

        } else if (left.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            Expression newLeft = new MultiplicationExpression(right, ((AdditionExpression) left).getLeft());
            Expression newRight = new MultiplicationExpression(right, ((AdditionExpression) left).getRight());
            return new AdditionExpression(newLeft.expand(), newRight.expand());

        } else {
            return this;
        }
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.MULTIPLICATION_EXPRESSION;
    }
    
    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        if (left.getType().equals(ExpressionType.ADDITION_EXPRESSION) |
                left.getType().equals(ExpressionType.MULTIPLICATION_EXPRESSION)) {
            output.append("(");
            output.append(left.toString());
            output.append(")");
        } else {
            output.append(left.toString());
        }
        output.append("*");
        if (right.getType().equals(ExpressionType.ADDITION_EXPRESSION) |
                right.getType().equals(ExpressionType.MULTIPLICATION_EXPRESSION)) {
            output.append("(");
            output.append(right.toString());
            output.append(")");
        } else {
            output.append(right.toString());
        }
        return output.toString();
    }
}
