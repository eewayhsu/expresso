package expresso;

/**
 * MultiplicationExpression is an immutable type representing a multiplication
 * expression.
 */
public class MultiplicationExpression implements Expression {

    private final Expression left;
    private final Expression right;

    /*
     * Abstraction Function:
     * left -> the multiplicand (expression prior to '*') of a mathematical expression 
     * right -> the multiplier (expression post '*') of a mathematical expression
     * 
     * Rep Invariant: 
     * left and right not null
     * 
     * Safety from Rep Exposure:
     * left and right are both immutable data types.  
     * They are final and thus don't risk rep exposure. 
     */

    /**
     * Creates a multiplication expression with given left and right
     * expressions.
     * 
     * @param left left expression
     * @param right right expression
     */
    public MultiplicationExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        checkRep();
    }

    @Override
    public Expression getLeft() {
        return left;
    }

    @Override
    public Expression getRight() {
        return right;
    }

    /**
     * We ensure structural equality in Expression (meaning order is considered_
     * Equality is checked with observational equality using the getLeft and getRight observers
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MultiplicationExpression) {
            MultiplicationExpression expression = (MultiplicationExpression) obj;
            return expression.getLeft().equals(left)
                    && expression.getRight().equals(right);
        } else {
            return false;
        }
    }

    /**
     * We return the addition of coprimes multiplied 
     * by the hashcode of the left and right expressions
     */
    @Override
    public int hashCode() {
        return 5 * left.hashCode() + 79 * right.hashCode();
    }

    /**
     * We ensure the rep invariant is maintained
     */
    private void checkRep() {
        assert left != null;
        assert right != null;
    }

    
    /**
     * An expanded expression is the addition of expressions 
     * Here we create a mathematically equivalent AdditionExpression
     */
    @Override
    public Expression expand() {
        if (right.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            Expression newLeft = new MultiplicationExpression(left, right.getLeft());
            Expression newRight = new MultiplicationExpression(left, right.getRight());
            return new AdditionExpression(newLeft.expand(), newRight.expand());

        } else if (left.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            Expression newLeft = new MultiplicationExpression(right, left.getLeft());
            Expression newRight = new MultiplicationExpression(right, left.getRight());
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
