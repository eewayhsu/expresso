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
        // Using the Master theorem, this procedure is exponential
        Expression rightExpand = right.expand();
        Expression leftExpand = left.expand();

        if (rightExpand.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            Expression newLeft = new MultiplicationExpression(leftExpand, rightExpand.getLeft());
            Expression newRight = new MultiplicationExpression(leftExpand, rightExpand.getRight());
            return new AdditionExpression(newLeft.expand(), newRight.expand());

        } else if (leftExpand.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            Expression newLeft = new MultiplicationExpression(rightExpand, leftExpand.getLeft());
            Expression newRight = new MultiplicationExpression(rightExpand, leftExpand.getRight());
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
