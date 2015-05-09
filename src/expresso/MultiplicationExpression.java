package expresso;

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
        // Using the Master theorem, this procedure is exponential
        Expression rightExpand = right.expand();
        Expression leftExpand = left.expand();

        if (rightExpand.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            Expression newLeft = new MultiplicationExpression(leftExpand, ((AdditionExpression) rightExpand).getLeft());
            Expression newRight = new MultiplicationExpression(leftExpand, ((AdditionExpression) rightExpand).getRight());
            return new AdditionExpression(newLeft.expand(), newRight.expand());

        } else if (leftExpand.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            Expression newLeft = new MultiplicationExpression(rightExpand, ((AdditionExpression) leftExpand).getLeft());
            Expression newRight = new MultiplicationExpression(rightExpand, ((AdditionExpression) leftExpand).getRight());
            return new AdditionExpression(newLeft.expand(), newRight.expand());

        } else {
            return this;
        }
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.MULTIPLICATION_EXPRESSION;
    }
}
