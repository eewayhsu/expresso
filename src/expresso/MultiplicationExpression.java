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
    public Expression simplify() {
        checkRep();
        throw new RuntimeException("Unimplemented method");
    }

    @Override
    public Expression differentiate() {
        checkRep();
        throw new RuntimeException("Unimplemented method");
    }
    
    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("Unimplemented method");
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
        Expression leftExpansion = left.expand();
        Expression rightExpansion = right.expand();
        if (rightExpansion.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            return new AdditionExpression(new MultiplicationExpression(leftExpansion, ((AdditionExpression) rightExpansion).getLeft()),
                    new MultiplicationExpression(leftExpansion, ((AdditionExpression) rightExpansion).getRight()));
        } else if (leftExpansion.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            return new AdditionExpression(new MultiplicationExpression(rightExpansion, ((AdditionExpression) leftExpansion).getLeft()),
                    new MultiplicationExpression(rightExpansion, ((AdditionExpression) leftExpansion).getRight()));
        } else {
            return this;
        }
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.MULTIPLICATION_EXPRESSION;
    }
}
