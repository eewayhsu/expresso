package expresso;

import java.util.*;

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
 * 
 */
public class PolynomialTerm {
  private int constantTerm = 1;
  private Map<String, Integer> variables = new HashMap<String, Integer>();

  /**
   * An instance of PolynomialTerm is constructed with an instance of
   * Expression that has only ME descendants
   */
  public PolynomialTerm(Expression expression) {
    assert walkTree(expression);
    checkRep();
  }

  /**
   * PolynomialTerm can also be constructed explicitly with the Map and Constant
   * term
   */
  public PolynomialTerm(int constantTerm, Map<String, Integer> variables) {
    this.constantTerm = constantTerm;
    this.variables = variables;
    checkRep();
  }

  /**
   * This method is called on the Expression constructor
   * This method also returns whether all nodes of the expression are ME's
   */ 
  private boolean walkTree(Expression node) {
    // TODO, use switch instead?
    // switch node.getType() --> need to implement this method
    if (node instanceof MultiplicationExpression) {
      return walkTree(node.getLeft()) && walkTree(node.getRight());
    } else if (node instanceof MultiplyExpression) {
      return false;
    } else if (node instanceof Variable) {
      String variable = node.getName();
      int power = variables.get(variable) ? variables.get(variable) : 1;
      variables.put(variable, power);
      return true;
    } else if (node instanceof Constant) {
      constantTerm = constantTerm * node.getValue();
      return true;
    }
  }

  /**
   * This method combines a list of PolynomialTerms into one by adding their
   * coefficients, for example, [2*x, 3*x] will be merged into 5*x
   * Asserts that all the terms in the list are equal (note that this is a pretty
   * weak precondition)
   */
  public static PolynomialTerm squish(PolynomialTerm[] listOfPolys) {
    int newConstantTerm = 1;
    PolynomialTerm firstTerm = listOfPolys[0];
    for (PolynomialTerm term : listOfPolys) {
      assert term.equals(firstTerm);
      newConstantTerm += term.constantTerm;
    }
    return new PolynomialTerm(newConstantTerm, firstTerm.variables);
  }

  @Override
  public int hashCode() {
    return variables.hashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof PolynomialTerm) {
      return variables.equals(((PolynomialTerm) other).variables);
    } else {
      return false;
    }
  }

  private void checkRep() {
    // TODO
  }
}
