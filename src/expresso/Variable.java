package expresso;

class Variable implements Expression {
    
    private String name;
    
    // Abstraction function
    //
    // Rep invariant
    //
    // Safety from rep exposure
    
    /**
     * Creates a variable with given name.
     * 
     * @param name  name of variable
     */
    Variable(String name) {
        this.name = name;
    }
    
    /**
     * Returns name of variable
     * 
     * @return name of variable
     */
    public String getName() {
        return name;
    }
    
    @Override
    public Expression simplify() {
        throw new RuntimeException("Unimplemented method");
    }

    @Override
    public Expression differentiate() {
        return new Constant(1);
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
