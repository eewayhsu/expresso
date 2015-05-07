package expresso;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class contains tests for the Expressions class.
 */
public class ExpressionsTest {
    
    /*
     * Test strategy for simplify
     * 
     * Partitions:
     *  - constant only
     *  - variable only
     *  - addition expression only
     *  - multiplication expression only
     *  
     *  - addition and multiplication expressions (not simplified)
     *  - addition and multiplication expressions (simplified)
     *  
     *  - not structurally equal, but algebraically equal polynomial terms
     *  - structurally equal polynomial terms
     *  
     *  - variables with different degrees
     *  - variables with same degrees
     *  
     *  - extra white spaces
     * 
     * Test cases:
     *  - 5.3
     *  - foo
     *  - 4.2 + foo
     *  - foo*foo
     *  - 4*(x*y + y*x)
     *  - 4 + (x*x*x)
     *  - 4*(x*y + y*x + x*x*x)
     */
    
    @Test
    public void testSimplifyConstant() {
        assertEquals(Expressions.simplify("   5.3"), "5.3");
    }
    
    @Test
    public void testSimplifyVariable() {
        assertEquals(Expressions.simplify("foo  "), "foo");
    }
    
    @Test
    public void testSimplifyAddition() {
        assertEquals(Expressions.simplify("4.2 + foo"), "foo+4.2");
    }
    
    @Test
    public void testSimplifyIdentity() {
        assertEquals(Expressions.simplify("0 + foo"), "foo");
    }
    
    
    @Test
    public void testSimplifyMultiplication() {
        assertEquals(Expressions.simplify("foo* foo"), "foo*foo");
    }
    
    @Test
    public void testSimplifyAdditionMultiplicationUnsimplified() {
        assertEquals(Expressions.simplify("4*(x*y + y*x)"), "8.0*x*y");
    }
    
    @Test
    public void testSimplifyAdditionMultiplication() {
        assertEquals(Expressions.simplify("4 + (x*x*x)"), "x*x*x+4.0");
    }
    
    @Test
    public void testSimplifyComplicated() {
        assertEquals(Expressions.simplify("4*(x*y + y*x + x*x*x)"), "4.0*x*x*x+8.0*x*y");
    }
}
