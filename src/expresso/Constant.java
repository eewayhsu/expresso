package expresso;

/**
 * Constant is an immutable type representing a constant.
 */
public class Constant implements Expression {
    
    private final double value;
    
    /* Abstraction function
     *      value represents the constant value
     *      
     * Rep invariant
     *      value is a nonnegative double.
     *      
     * Safety from rep exposure
     *      name is immutable, so there is no risk of rep exposure.
     */

    /**
     * Creates a constant with given value
     * 
     * @param value value of constant
     */
    public Constant(double value) {
        this.value = value;
    }
    
    /**
     * Returns value of the constant
     * 
     * @return value of the constant
     */
    public double getValue() {
        return value;
    }

    @Override
    public Expression simplify() {
        checkRep();
        throw new RuntimeException("Unimplemented method");
    }

    @Override
    public Expression differentiate() {
        checkRep();
        return new Constant(0);
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
        assert value >= 0;
    }

    @Override
    public Expression expand() {
        return this;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.CONSTANT;
    }
}
