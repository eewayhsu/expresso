package expresso;

/**
 * This class contains tests for the main static method in the Main class.
 */
public class ConsoleTest {

    /*
     * Test strategy for Console Interface:
     *  To test the console interface, we will run two threads.
     *  One thread will be implementing main, allowing the continuous read of the inputStream.
     *  The other thread will write to the inputStream in main and read from the outputStream. 
     *  When reading from the outputStream, it will assert the correct responses are returned. 
     * 
     * The input options supported by main include...
     *  Valid expressions represented as a String
     *  ! represents the current stored expression
     *  !d/dvariable 
     *  !d/simplify
     *  Invalid
     * 
     * Partitions:
     *  - valid expression 
     *      with parentheses
     *      with multiplication
     *      with addition
     *      with combination
     *  - !, the current stored expression 
     *      with no current stored expression
     *      with valid current stored expression
     *  - !d/dvariable
     *      with variable not present in expression
     *      with variable present in expression
     *      invalid variable
     *          constant (numeric)
     *          not alpha character
     *  - !simplify
     *      already simplified
     *      unsimplified 
     *  - invalid
     *      ParseError: No stored current expression
     *      ParseError invalid expression
     *      ParseError Unknown command "?"
     *      ParseError: missing variable in derivative command
     *      ParseError: must differentiate with respect to a valid variable
     *           
     * Test cases:
     * 
     * 
     *  1. No current stored expression
     *      !: ParseError: No current stored expression 
     *      !simplify: ParseError: No current stored expression 
     *      !d/dx: ParseError: No current stored expression
     *      
     *  2. Valid addition not yet simplified
     *      x + x + x: x + x + x
     *      !: x + x + x
     *      !simplify: 3.0 * x
     *      !d/dx: 3.0
     *           
     *  3. Valid multiplication not yet simplified
     *      x * y * xy + x * x + (2.0 * x) * x:  x * y * xy + x * x + (2.0 * x) * x
     *      !simplify: 3.0 * x * x + x * y * xy
     *      !d/dxy: x * y
     * 
     *  4. Valid differentiate before simplify
     *      x + y + 2.44*x + y*y*x: x + y + 2.44*x + y*y*x
     *      !d/dx = y * y + 3.44
     *      !simplify: y * y + 3.44
     *      
     *  5. Differentiate by not present varaible
     *      
     *  6. .... Other valid combinations 
     *  
     *  7. Invalid expressions  
     *      x + y): ParseError: Invalid expression 
     *      !d/dx: ParseError: No stored current expression
     *      x + y: x + y
     *      !d/d: ParseError: Missing variable in derivative
     *      !d/d4: ParseError: Must differentiate with respect to a valid variable
     *      !poop: ParseError: Unknown command "poop"
     */
    
    
}
