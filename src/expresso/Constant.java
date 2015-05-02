package expresso;

class Constant implements Expression {
    
    private int value;
    
    // Abstraction function
    //
    // Rep invariant
    //
    // Safety from rep exposure

    /**
     * Creates a constant with given value
     * 
     * @param value value of constant
     */
    Constant(int value) {
        this.value = value;
    }
    
    /**
     * Returns value of the constant
     * 
     * @return value of the constant
     */
    public int getValue() {
        return value;
    }

    @Override
    public Expression simplify() {
        throw new RuntimeException("Unimplemented method");
    }

    @Override
    public Expression differentiate() {
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
        
    }
}
