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
 */
public class PolynomialTerm {
  private int constantTerm = 1;
  private Map<String, Integer> variables = new HashMap<String, Integer>();

  /**
   * An instance of PolynomialTerm is constructed with an instance of Expression
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
  public PolynomialTerm(int constantTerm, Map<String, Integer> variables) {
    this.constantTerm = constantTerm;
    this.variables = variables;
    checkRep();
  }

  /**
   * This method is called in the Expression constructor
   * Starts walking the tree rooted at node, and if any of the descendant nodes
   * rooted are literals, we record the literal in our internal rep
   */ 
  private void walkTree(Expression node) {
    // TODO, use switch instead?
    // switch node.getType() --> need to implement this method
    if (node instanceof MultiplicationExpression) {
      walkTree(node.getLeft());
      walkTree(node.getRight());
    } else if (node instanceof Variable) {
      String variable = node.getName();
      int power = variables.containsKey(variable) ? variables.get(variable) : 1;
      variables.put(variable, power);
    } else if (node instanceof Constant) {
      constantTerm = constantTerm * node.getValue();
    }
  }

  /**
   * This method combines a non-empy list of PolynomialTerms into a single
   * PolynomialTerm by adding their coefficients, for example, [2*x, 3*x] 
   * will be merged into 5*x by this method
   *
   * listOfPolys must contain PolynomialTerms that are equal (note that this is
   * a pretty weak precondition)
   */
  public static PolynomialTerm squish(PolynomialTerm[] listOfPolys) {
    int newConstantTerm = 1;
    PolynomialTerm firstTerm = listOfPolys[0];
    for (PolynomialTerm term : listOfPolys) {
      newConstantTerm += term.constantTerm;
    }
    return new PolynomialTerm(newConstantTerm, firstTerm.variables);
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
