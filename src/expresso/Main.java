package expresso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Console interface to the expression system.
 */
public class Main {

    private static final String COMMAND_PREFIX = "!";
    private static final String DERIVATIVE_PREFIX = "d/d";
    private static final String SIMPLIFY = "simplify";
    
    private static String currentExpression = "";
    
    /**
     * Read expression and command inputs from the console and output results.
     * Acceptable commands are "!simplify", which simplifies the current expression, and
     * "!d/d[variable]", which differentiates the current expression with respect to
     * [variable]. Each new valid input expression updates the current expression.
     * Each valid call to differentiate also updates the current expression to be the
     * differentiated expression.
     *  
     * An empty input terminates the program.
     * 
     * @param args
     *            unused
     * @throws IOException
     *             if there is an error reading the input
     */
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(
                System.in));

        while (true) {
            System.out.print("> ");
            final String input = in.readLine();

            if (input.isEmpty()) {
                return;
            }

            try {
                final String output;
                
                if (input.startsWith(COMMAND_PREFIX)) {
                    output = handleCommand(input.substring(COMMAND_PREFIX
                            .length()));
                } else {
                    output = handleExpression(input);
                    // updates current expression if input is valid
                    currentExpression = output;
                }
                System.out.println(output);
            } catch (RuntimeException re) {
                System.out.println(re.getClass().getName() + ": "
                        + re.getMessage());
            }
        }
    }

    /**
     * Returns parsed expression with parentheses indicating groupings of binary operations
     * from left to right.
     * TODO strengthen specification
     * 
     * @param input expression
     * @return parsed expression
     */
    private static String handleExpression(String input) {
        return Expression.parse(input).toString();
    }

    /**
     * Returns output after executing command on current expression
     * If substring is "d/d[variable]" the output is the result of differentiating the
     * expression with respect to [variable]. If substring is "simplify" the output is
     * the simplification of the current expression.
     * 
     * @param substring command to be executed
     * @return result of executing command
     */
    private static String handleCommand(String substring) {
        if (currentExpression.equals("")) {
            throw new RuntimeException("cannot execute command without an expression");
        }
        if (substring.contains(DERIVATIVE_PREFIX)) {
            String variable = substring.substring(DERIVATIVE_PREFIX.length());
            if (variable.length() == 0) {
                throw new RuntimeException("missing variable in derivative command");
            } else {
                currentExpression = Expressions.differentiate(currentExpression, variable);
                return currentExpression;
            }
        } else if (substring.equals(SIMPLIFY)) {
            return Expressions.simplify(currentExpression);
        } else {
            throw new RuntimeException("unknown command");
        }
    }
}
