package expresso;

import java.util.*;

import expresso.Expression.ExpressionType;

/**
 * PolynomialTerm is an immutable type representing a term in a polynomial
 * expression.
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
    MultipliedByZero();
    checkRep();
  }

  /**
   * PolynomialTerm can also be constructed explicitly with the Map and Constant
   * term
   */
  public PolynomialTerm(double coefficient, Map<String, Integer> variables) {
    this.coefficient = coefficient;
    this.variables = new HashMap<String, Integer>(variables);
    MultipliedByZero();
    checkRep();
  }
  
  /**
   * Turns a PolynomialTerm multiplied by zero into zero. 
   * This flushes the variables, keeping the hashcode constant 
   *
   * @param none
   * @return none
   */
  private void MultipliedByZero(){
      if (coefficient == 0) variables.clear();
  }

  /**
   * Returns a PolynomialTerm that is a differentiated form of the current term
   *
   * @param String variable     The partial derivative
   * @return A new PolynomialTerm that is differentiated with respect to variable
   */
  public PolynomialTerm differentiate(String variable) {
    double newCoefficient = coefficient;
    Map<String, Integer> newVariables = new HashMap<String, Integer>(variables);
    if (newVariables.containsKey(variable)) {
      int power = newVariables.get(variable);
      if (power > 1) {
        newVariables.put(variable, power-1);
        newCoefficient = newCoefficient * power;
      } else {
          newVariables.remove(variable);
      }
    } else {
      newCoefficient = 0;
    }
    return new PolynomialTerm(newCoefficient, newVariables);
  }

  /**
   * This method is called in the Expression constructor. It is a recursive
   * procedure. The method starts by walking the tree rooted at node, and if any
   * of the descendant nodes rooted are literals, records the literal in our 
   * internal rep
   *
   * Expression must only contain ME descendants
   *
   * @param Expression node     The root node of the subtree
   * @return none
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
   * This method simplifies a non-empty list of PolynomialTerms into a simplified list of
   * PolynomialTerms by adding their coefficients, for example, [2*x, 3*x, 4*x*x] 
   * will be merged into [5*x, 4*x*x] by this method.  The list is returned in lexical order.  
   *
   * @param listOfPolynomials is a list of PolynomialTerms we want simplified
   * @return a new list of polynomials where some have been combined, then sorted in lexical order.
   */
  public static List<PolynomialTerm> simplify(List<PolynomialTerm> listOfPolynomials){
      
      Map<Integer, PolynomialTerm> newPolynomialMap = new HashMap<Integer, PolynomialTerm>();
      
      for (PolynomialTerm polynomial: listOfPolynomials){
          
          int key = polynomial.hashCode();
          
          if (!newPolynomialMap.containsKey(key)){
              newPolynomialMap.put(key, polynomial);
          } else {
              PolynomialTerm containedPolynomial = newPolynomialMap.get(key);
              PolynomialTerm combinedPolynomial = new PolynomialTerm(containedPolynomial.coefficient + polynomial.coefficient, polynomial.variables);
              newPolynomialMap.put(key, combinedPolynomial);
          }
      }
      
      List<PolynomialTerm> simplifiedPolynomialList = new ArrayList<PolynomialTerm>();
      simplifiedPolynomialList.addAll(newPolynomialMap.values());
      
      Collections.sort(simplifiedPolynomialList, new Comparator<PolynomialTerm>(){
          public int compare(PolynomialTerm firstPolynomial, PolynomialTerm secondPolynomial)
          {
              //TODO: this is a specific order while the spec might allow any order?  
              //Should we just strengthen our spec for combined?
              
              if (firstPolynomial.variables.values().isEmpty()){ return 1; }
              if (secondPolynomial.variables.values().isEmpty()){ return -1; } 
              
              //This is to allow us to return the largest first
              if (Collections.max(firstPolynomial.variables.values()) >= (Collections.max(secondPolynomial.variables.values()))){
                  return -1;
              } else { 
                  return 1; 
              }
          }
      });
      
      return simplifiedPolynomialList;
  }
  
  /**
   * This method returns a String representation of our polynomial. 
   * If the coefficient of a non-trivial polynomial term is 1, then the representation
   * does not include the coefficient, i.e. 1*x*y will be represented as x*y
   *
   * @param none
   * @return the String representation of the PolynomialTerm
   */ 
  @Override
  public String toString() {
    String returnString = (coefficient == 1) ? "" : String.valueOf(coefficient);
    String multiplyByZero = "0.0";
    String operation = "";
    
    //Takes care of * 0
    if (coefficient == 0) return multiplyByZero;
    
    //Takes care of identity
    if (variables.isEmpty()) return String.valueOf(coefficient);
    
    //Adds variables into the string
    Iterator it = variables.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      for (int i = 0; i < (int) pair.getValue(); i++) {
          if (coefficient != 1) operation = "*";

          returnString += operation + pair.getKey();
       }
    } 
    return returnString;
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
    if (coefficient == 0) 
      assert variables.isEmpty();
  }
}
