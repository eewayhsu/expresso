package expresso;

/**
 * Variable is an immutable type representing a variable.
 */
class Variable implements Expression {
    
    private final String name;
    
    /* Abstraction function
     *      name represents the name of the variable
     *      
     * Rep invariant
     *      name is a string of lowercase and/or upppercase alphabet letters.
     *      length of name is at least 1.
     *      
     * Safety from rep exposure
     *      name is immutable, so there is no risk of rep exposure.
     */
    
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
        checkRep();
        throw new RuntimeException("Unimplemented method");
    }

    @Override
    public Expression differentiate() {
        checkRep();
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
        name.matches("[a-zA-Z]+");
    }
}
