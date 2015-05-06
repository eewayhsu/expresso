package expresso;

import java.util.ArrayList;
import java.util.List;

import expresso.parser.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Expression represents a mathematical expression.  This is a immutable recursive abstract datatype. 
 */
public interface Expression {
    
    // Datatype definition
    //   Expression = Constant(value:double)
    //                  + Variable(value:String)
    //                  + MultiplicationExpression(left:Expression, right:Expression)
    //                  + AdditionExpression(left:Expression, right:Expression)
    
    public enum ExpressionType {
        VARIABLE, CONSTANT, ADDITION_EXPRESSION, MULTIPLICATION_EXPRESSION;
    }
    
    /**
     * Parse an expression.  
     * @param String input              Expression to parse
     * @return Expression expression    AST for the input
     * @throws IllegalArgumentException If the expression is invalid
     */
    public static Expression parse(String input) {
        CharStream stream = new ANTLRInputStream(input);

        // Instantiate lexer
        ExpressionLexer lexer = new ExpressionLexer(stream);
        lexer.reportErrorsAsExceptions();

        TokenStream tokens = new CommonTokenStream(lexer);

        // Instantiate parser
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.reportErrorsAsExceptions();

        ParseTree expressionTree = parser.root();
        ParseTreeWalker walker = new ParseTreeWalker();

        ExpressionListenerExpressionCreator listener = new ExpressionListenerExpressionCreator();
        walker.walk(listener, expressionTree);
        
        return listener.getExpression();

    }
    
    // Instance methods
    /**
     * Returns simplified expression
     * 
     * @return simplified expression
     */
    public Expression simplify();
    
    /**
     * Returns differentiated expression
     * 
     * @return differentiated expression
     */
    public Expression differentiate(String variable);
    
    /**
     * Returns an algebraically equivalent expression that consists of a sum of products.
     * Expands by distributing terms first from left to right, then from right to left.
     * 
     * @return an algebraically equivalent expression that consists of a sum of products
     */
    public Expression expand();
    
    /**
     * Returns a polynomial that is algebraically equivalent.
     * TODO: strengthen specification later
     * 
     * @return a polynomial that is algebraically equivalent
     */
    public static List<PolynomialTerm> toPolynomial(Expression expression) {
        Expression expansion = expression.expand();
        return extractPolynomialTerms(expansion);
    }
    
    /**
     * Walks through each node of the expression and extracts polynomial terms into an array.
     * 
     * @param expansion fully-expanded expression whose polynomial terms are to be extracted
     * @return array of polynomial terms contained in the expression
     */
    static List<PolynomialTerm> extractPolynomialTerms(Expression expansion) {
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

    /**
     * Returns corresponding ExpressionType
     * 
     * @return corresponding ExpressionType
     */
    public ExpressionType getType();
}
