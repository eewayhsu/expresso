package expresso;

/**
 * AdditionExpression is an immutable type implementing expression representing an addition expression.
 */
public class AdditionExpression implements Expression {

    private final Expression left;
    private final Expression right;

    /*
     * Abstraction Function: 
     * left -> the augend (expression prior to '+') of a mathematical expression 
     * right -> the addend (expression post '+') of a mathematical expression
     * 
     * Representation Invariant:
     * left and right not null
     * 
     * Safety from Rep Exposure:
     * left and right are both immutable data types.  
     * They are final and thus don't risk rep exposure. 
     */

    /**
     * Creates an addition expression with given left and right expressions.
     * 
     * @param left the left expression of the addExpression
     * @param right the right expression of the addExpression
     */
    public AdditionExpression(Expression left, Expression right) {
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

    /**
     * We ensure structural equality in Expression (meaning order is considered_
     * Equality is checked with observational equality using the getLeft and getRight observers
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AdditionExpression) {
            AdditionExpression expression = (AdditionExpression) obj;
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
     * which is an additionExpression
     */
    @Override
    public Expression expand() {
        return this;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.ADDITION_EXPRESSION;
    }
}
