package expresso;

/**
 * AdditionExpression is an immutable type representing an addition expression.
 */
public class AdditionExpression implements Expression {
    
    private final Expression left;
    private final Expression right;
    
    /* Abstraction function
     *      left -> the augend (expression prior to '+') of a mathematical expression 
     *      right -> the addend (expression post '+') of a mathematical expression
     *      
     * Rep invariant
     *      left and right not null
     *      
     * Safety from rep exposure
     *      left and right are both immutable, so there is no risk of rep exposure.
     */
    
    /**
     * Creates an addition expression with given left and right expressions.
     * 
     * @param left  left expression
     * @param right right expression
     */
    public AdditionExpression(Expression left, Expression right) {
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
        if (obj instanceof AdditionExpression) {
          AdditionExpression expression = (AdditionExpression) obj;
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
        return this;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.ADDITION_EXPRESSION;
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
        output.append(" + ");
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
