package expresso;

/**
 * Variable is an immutable type representing a variable.
 */
public class Variable implements Expression {

    private final String name;

    /*
     * Abstraction Function:
     * name represents the name of the variable
     * 
     * Rep Invariant:
     * name is a string of lowercase and/or upppercase alphabet letters. 
     * length of name is at least 1.
     * 
     * Safety from Rep Exposure:
     * name is immutable, so there is no risk of rep exposure.
     */

    /**
     * Creates a variable with given name.
     * 
     * @param name name of variable
     */
    public Variable(String name) {
        this.name = name;
        checkRep();
    }

    /**
     * Returns name of variable
     * 
     * @return name of variable
     */
    public String getName() {
        // TODO, sanitize
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Variable) {
            Variable variable = (Variable) obj;
            return variable.getName().equals(name);
        } else {
            return false;
        }    
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    private void checkRep() {
        name.matches("[a-zA-Z]+");
    }

    @Override
    public Expression expand() {
        return this;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.VARIABLE;
    }

    @Override
    public Expression getLeft() {
        return this;
    }

    @Override
    public Expression getRight() {
        return this;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
