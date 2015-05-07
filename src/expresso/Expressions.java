package expresso;

import java.util.ArrayList;
import java.util.List;

import expresso.Expression.ExpressionType;

/**
 * String-based class of the expression system.
 */
public class Expressions {
    private static String ADDITIVE_IDENTITY = "0.0";
    private static String MULTIPLICATIVE_IDENTITY = "1.0";

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

        // Push differentiated terms into new list
        // We need this because two different PolynomialTerm's when differentiated might 
        // return the same term, e.g. d/dx(y+1)
        List<PolynomialTerm> differentiatedPolynomialList = new ArrayList<PolynomialTerm>();

        for (PolynomialTerm polynomial: simplifiedPolynomialList){
            differentiatedPolynomialList.add(polynomial.differentiate(variable));
        }
        
        return simplifyWithList(differentiatedPolynomialList);
    }
    
    /**
     * Simplify an expression.
     * This method wraps {@link simplifyWithList()}
     *
     * @throws IllegalArgumentException if the expression is invalid (TODO)
     */
    public static String simplify(String expression) {
        Expression parsedExpression = Expression.parse(expression);
        List<PolynomialTerm> listOfPolynomials = toPolynomial(parsedExpression);

        return simplifyWithList(listOfPolynomials);
    }

    /**
     * Simplify an expression.
     * @param listOfPolynomials the list of PolynomialTerm's to simplify
     * @return an expression equal to the input that is a sum of terms without parentheses,
     *         where for all variables var_i in the expression, for all exponents e_i, the
     *         term (var_1^e_1 x var_2^e_2 x ... x var_n^e_n) appears at most once; each
     *         term may be multiplied by a non-zero, non-identity constant factor; and read
     *         left-to-right, the largest exponent in each term is non-increasing
     * @throws IllegalArgumentException if the expression is invalid (TODO)
     */
    private static String simplifyWithList(List<PolynomialTerm> listOfPolynomials) {
        List<PolynomialTerm> simplifiedPolynomialList = PolynomialTerm.simplify(listOfPolynomials);
        String simplifiedString = simplifiedPolynomialList.get(0).toString();

        for (int i=1; i<simplifiedPolynomialList.size(); i++) {
            String stringPoly = simplifiedPolynomialList.get(i).toString();

            // Skip loop iteration if term is the additive identity
            if (stringPoly == ADDITIVE_IDENTITY) continue;

            simplifiedString += "+" + stringPoly;
        }

        return simplifiedString;
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
