package expresso;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains tests for the PolynomialTerm class
 */
public class PolynomialTermTest {
    private static PolynomialTerm AdditiveIdentity;
    private static PolynomialTerm MultiplicativeIdentity;
    private static Map<String, Integer> variables = new HashMap<String, Integer>();

    /**
     * Creates the identities for comparison in future tests
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        AdditiveIdentity = new PolynomialTerm(0, variables);
        MultiplicativeIdentity = new PolynomialTerm(1, variables);
    }

    /**
     * Refreshes vars in variables
     */
    @Before
    public void setUpBeforeEach() {
        variables = new HashMap<String, Integer>();
    }

    /**
     * Test that two polynomials with different vars are different
     */
    @Test
    public void testEqualityVarsNegative() {
        variables.put("x", 1);
        PolynomialTerm firstTerm = new PolynomialTerm(1, variables);
        variables.put("x", 2);
        PolynomialTerm secondTerm = new PolynomialTerm(1, variables);
        assertFalse(firstTerm.equals(secondTerm));
    }

    /**
     * Test that two polynomials with different non-zero coefficients are equal 
     */
    @Test
    public void testEqualityVarsCoefficientsPositive() {
        variables.put("x", 1);
        PolynomialTerm firstTerm = new PolynomialTerm(1, variables);
        PolynomialTerm secondTerm = new PolynomialTerm(2, variables);
        assertEquals(firstTerm, secondTerm);
    }

    /**
     * Test that 0*x^3 is equal to 0
     */
    @Test
    public void testAdditiveIdentityEquality() {
        variables.put("x", 1);
        PolynomialTerm newPolynomialTerm = new PolynomialTerm(0, variables);
        assertEquals(AdditiveIdentity, newPolynomialTerm);
    }

    /**
     * Test that additive identity's string rep is 0.0
     */
    @Test
    public void testAdditiveIdentityStringRep() {
        assertEquals(AdditiveIdentity.toString(), "0.0");
    }

    /**
     * Test that multiplicative identity's string rep is 0.0
     */
    @Test
    public void testMultiplicativeIdentityStringRep() {
        assertEquals(MultiplicativeIdentity.toString(), "1.0");
    }

    /**
     * Test the string rep of polynomial term with coefficient 1
     */
    @Test
    public void testCoefficientOneStringRep() {
        variables.put("x", 1);
        PolynomialTerm newPolynomialTerm = new PolynomialTerm(1, variables);
        assertEquals(newPolynomialTerm.toString(), "x");
    }
    
}
