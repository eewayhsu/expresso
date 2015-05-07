package expresso;

import java.util.ArrayList;
import java.util.List;

import expresso.Expression.ExpressionType;

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
        List<PolynomialTerm> listOfPolynomials = toPolynomial(parsedExpression);
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
        
        List<PolynomialTerm> listOfPolynomials = toPolynomial(parsedExpression);
        List<PolynomialTerm> simplifiedPolynomialList = PolynomialTerm.simplify(listOfPolynomials);
    
        String simplifiedExpression = "";
        
        for (PolynomialTerm polynomial: simplifiedPolynomialList){
            System.out.println(polynomial.toString());
            simplifiedExpression += polynomial + " + ";
        }
    
        //TODO: implement toString that returns a string such as "3*x"
        //This removes the last plus sign (cant be done nicer) by replacing last 
        //or not adding that last one in the first place. 
        return simplifiedExpression.substring(0, -3);        
    }
    
    /**
     * Returns a polynomial that is algebraically equivalent.
     * TODO: strengthen specification later
     * 
     * @return a polynomial that is algebraically equivalent
     */
    private static List<PolynomialTerm> toPolynomial(Expression expression) {
        Expression expansion = expression.expand();
        return extractPolynomialTerms(expansion);
    }
    
    /**
     * Walks through each node of the expression and extracts polynomial terms into an array.
     * 
     * @param expansion fully-expanded expression whose polynomial terms are to be extracted
     * @return array of polynomial terms contained in the expression
     */
    private static List<PolynomialTerm> extractPolynomialTerms(Expression expansion) {
        List<PolynomialTerm> listOfPolyTerms = new ArrayList<>();
        
        if (expansion.getType().equals(ExpressionType.ADDITION_EXPRESSION)) {
            
            List<Expression> children = new ArrayList<>();
            children.add(((AdditionExpression) expansion).getLeft());
            children.add(((AdditionExpression) expansion).getRight());

            for (Expression expression : children) {
                listOfPolyTerms.addAll(extractPolynomialTerms(expression));
            }
            
        } else {
            listOfPolyTerms.add(new PolynomialTerm(expansion));
        }
        return listOfPolyTerms;
    }

}
