package expresso;

import java.util.ArrayList;
import java.util.List;

/**
 * String-based class of the expression system.
 */
public class Expressions {
    
    /**
     * Differentiate an expression with respect to a variable.
     * @param expression the expression to differentiate
     * @param variable the variable to differentiate by
     * @return expression's derivative with respect to variable; will be a valid expression
     * @throws IllegalArgumentException if the expression or variable is invalid
     */
    public static String differentiate(String expression, String variable) {
        
        Expression parsedExpression = Expression.parse(expression);
        
        //We could also return a list of not simplfied differentiate here.  
        List<PolynomialTerm> listOfPolynomials = Expression.toPolynomial(parsedExpression);
        List<PolynomialTerm> simplifiedPolynomialList = PolynomialTerm.simplify(listOfPolynomials);
        
        String differentiatedExpression = "";
        
        for (PolynomialTerm polynomial: simplifiedPolynomialList){
            differentiatedExpression += polynomial.differentiate(variable).toString() + " + ";
        }
        
        //TODO: implement toString that returns a string such as "3*x"
        //This removes the last plus sign (cant be done nicer) by replacing last 
        //or not adding that last one in the first place. 
        return differentiatedExpression.substring(0, -3);
        
    }
    
    /**
     * Simplify an expression.
     * @param expression the expression to simplify
     * @return an expression equal to the input that is a sum of terms without parentheses,
     *         where for all variables var_i in the expression, for all exponents e_i, the
     *         term (var_1^e_1 x var_2^e_2 x ... x var_n^e_n) appears at most once; each
     *         term may be multiplied by a non-zero, non-identity constant factor; and read
     *         left-to-right, the largest exponent in each term is non-increasing
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static String simplify(String expression) {
        
        Expression parsedExpression = Expression.parse(expression);
        
        List<PolynomialTerm> listOfPolynomials = Expression.toPolynomial(parsedExpression);
        List<PolynomialTerm> simplifiedPolynomialList = PolynomialTerm.simplify(listOfPolynomials);
    
        String simplifiedExpression = "";
        
        for (PolynomialTerm polynomial: simplifiedPolynomialList){
            simplifiedExpression += polynomial + " + ";
        }
    
        //TODO: implement toString that returns a string such as "3*x"
        //This removes the last plus sign (cant be done nicer) by replacing last 
        //or not adding that last one in the first place. 
        return simplifiedExpression.substring(0, -3);        
    }
    
}
