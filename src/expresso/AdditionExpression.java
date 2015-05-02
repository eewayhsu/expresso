package expresso;

class AdditionExpression implements Expression {
    
    private Expression left;
    private Expression right;
    
    // Abstraction function
    //
    // Rep invariant
    //
    // Safety from rep exposure
    
    /**
     * Creates an addition expression with given left and right expressions.
     * 
     * @param left  left expression
     * @param right right expression
     */
    AdditionExpression(Expression left, Expression right) {
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
        throw new RuntimeException("Unimplemented method");
    }

    @Override
    public Expression differentiate() {
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
        
    }
}
