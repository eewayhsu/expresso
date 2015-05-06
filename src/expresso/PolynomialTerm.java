package expresso;

import java.util.*;

import expresso.Expression.ExpressionType;

/**
 * PolynomialTerm is an immutable type representing a term in a polynomial
 * expresison.
 *
 * Two instances of PolynomialTerm are equal iff they contain the same variables
 * that are raised to the same power. For example:
 *
 *  1) x*y = y*x
 *  2) 2*x*y = y*x
 *  3) x*y*x != y*x
 */
public class PolynomialTerm {
  private double coefficient = 1.;
  private Map<String, Integer> variables = new HashMap<String, Integer>();

  /**
   * An instance of PolynomialTerm is constructed with an instance of Expression
   *
   * Expression must only contain ME descendants
   */
  public PolynomialTerm(Expression expression) {
    walkTree(expression);
    checkRep();
  }

  /**
   * PolynomialTerm can also be constructed explicitly with the Map and Constant
   * term
   */
  public PolynomialTerm(double coefficient, Map<String, Integer> variables) {
    this.coefficient = coefficient;
    this.variables = variables;
    checkRep();
  }
  
  
  /**
   * This method is called in the Expression constructor
   * Starts walking the tree rooted at node, and if any of the descendant nodes
   * rooted are literals, we record the literal in our internal rep
   *
   * Expression must only contain ME descendants
   */ 
  private void walkTree(Expression node) {
      switch (node.getType()) {
          case MULTIPLICATION_EXPRESSION:
              MultiplicationExpression multiplyNode = (MultiplicationExpression) node;
              walkTree(multiplyNode.getLeft());
              walkTree(multiplyNode.getRight());
              break;
          case VARIABLE:
              Variable variableNode = (Variable) node;
              String variable = variableNode.getName();
              int power = variables.containsKey(variable) ? variables.get(variable) + 1 : 1;
              variables.put(variable, power);
              break;
          case CONSTANT:
              Constant constantNode = (Constant) node;
              coefficient = coefficient * constantNode.getValue();
              break;
          default:
              throw new RuntimeException("Can't cast to PolynomialTerm");
    }
  }

  /**
   * This method combines a non-empty list of PolynomialTerms into a simplified list of
   * PolynomialTerms by adding their coefficients, for example, [2*x, 3*x, 4*x*x] 
   * will be merged into [5*x, 4*x*x] by this method.  The list is returned in lexical order.  
   *
   * @param listOfPolynomials is a list of PolynomialTerms we want simplified
   * @return a new list of polynomials where some have been combined, then sorted in lexical order.
   */
  public static List<PolynomialTerm> combine(ArrayList<PolynomialTerm> listOfPolynomials){
      
      Map<Integer, PolynomialTerm> newPolynomialMap = new HashMap<Integer, PolynomialTerm>();
      
      for (PolynomialTerm polynomial: listOfPolynomials){
          if (!newPolynomialMap.containsKey(polynomial.hashCode())){
              newPolynomialMap.put(polynomial.hashCode(), polynomial);
          } else {
              PolynomialTerm containedPolynomial = newPolynomialMap.get(polynomial.hashCode());
              PolynomialTerm combinedPolynomial = new PolynomialTerm(containedPolynomial.coefficient + polynomial.coefficient, polynomial.variables);
          }
      }
      
      
      List<PolynomialTerm> simplifiedPolynomialList = new ArrayList<PolynomialTerm>();
      simplifiedPolynomialList.addAll(newPolynomialMap.values());
      
      Collections.sort(simplifiedPolynomialList, new Comparator<PolynomialTerm>(){
          public int compare(PolynomialTerm firstPolynomial, PolynomialTerm secondPolynomial)
          {
              if (Collections.max(firstPolynomial.variables.values()) >= (Collections.max(secondPolynomial.variables.values())))
                  //This is to allow us to return the largest first
                  return -1;
              else 
                  return 1;
          }
      });
      
      return simplifiedPolynomialList;
  }
  
  @Override
  public int hashCode() {
    return variables.hashCode();
  }

  @Override
  public boolean equals(Object otherTerm) {
    if (otherTerm instanceof PolynomialTerm) {
      return variables.equals(((PolynomialTerm) otherTerm).variables);
    } else {
      return false;
    }
  }

  private void checkRep() {
    // TODO
  }
}
