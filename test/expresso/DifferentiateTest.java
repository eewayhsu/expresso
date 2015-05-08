package expresso;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class contains tests for the diffferentiate static method in the Expressions class.
 */
public class DifferentiateTest {
    
    /*
     * Test strategy for differentiate
     * 
     * TODO
     */
    
    @Test
    public void testDifferentiateConstant() {
        assertEquals(Expressions.differentiate("   5.3", "x"), "0.0");
    }
    
    @Test
    public void testDifferentiateVariable() {
        assertEquals(Expressions.differentiate("foo  ","foo"), "1.0");
    }
    
    @Test
    public void testDifferentiateAddition() {
        assertEquals(Expressions.differentiate("4.2 + foo", "foo"), "1.0");
    }
    
    //TODO: We need to write more specs
    @Test
    public void testDifferentiateIdentity() {
        assertEquals(Expressions.differentiate("x + foo", "foo"), "1.0");
    }
    
    
    @Test
    public void testDifferentiateMultiplication() {
        assertEquals(Expressions.differentiate("foo* foo","foo"), "2.0*foo");
    }
    
    @Test
    public void testDifferentiateAdditionMultiplicationUnsimplified() {
        assertEquals(Expressions.differentiate("4*(x*y + y*x)", "y"), "8.0*x");
    }
    
    @Test
    public void testDifferentiateAdditionMultiplication() {
        assertEquals(Expressions.differentiate("4 + (x*x*x)", "x"), "3.0*x*x");
    }
    
    @Test
    public void testDifferentiateComplicated() {
        assertEquals(Expressions.differentiate("4*(x*y + y*x + x*x*x)", "x"), "12.0*x*x+8.0*y");
    }
}
