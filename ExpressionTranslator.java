import java.util.Scanner;
/**
 * 
 * @author Emily Brahma
 * ExpressionTranslator converts input into three different
 * formats.
 *
 */
public class ExpressionTranslator {
    /**
     * Error tracks if input is a valid input.
     */
    static boolean error = false;
    
    /**
     * The expression tree object for this class.
     */
    private ExpressionTree et;

    
    /**
     * Take expression and converts it to three different formats.
     * @param expression - the user input.
     */
    public ExpressionTranslator(String expression) {
    
        int variableCount = 0;
        int operatorCount = 0;
        this.et = null;
        error = false;
    

        Scanner reader = new Scanner(expression);
        Stack226Array<ExpressionTree> integerList  = 
                new Stack226Array<ExpressionTree>();

        while (reader.hasNext()) {

            String nextInput = reader.next();
        
            ExpressionTree temp;
            ExpressionTreeToken tok = new ExpressionTreeToken(nextInput);

            if (tok.isOperator() && integerList.size() > 1) {
                BinaryTree226Linked<ExpressionTreeToken> t1 = integerList.pop();
                BinaryTree226Linked<ExpressionTreeToken> t2 = integerList.pop();
                operatorCount++;
                temp = new ExpressionTree(tok, t2, t1);
            } else if (tok.isOperator() && integerList.size() < 2) {
                operatorCount++;
                temp = new ExpressionTree(tok);
            } else {
                variableCount++;
                temp = new ExpressionTree(tok);
            }

            integerList.push(temp);

        }

        this.et = integerList.pop();

        if (!(variableCount == (operatorCount + 1))) {
            error = true;
            if (variableCount > operatorCount + 1) {
                System.out.println("Invalid Postfix Expression: "
                        + "Too few operators.");
            } else {
                System.out.println("Invalid Postfix Expression: "
                         + "Too few operands.");
            }

        }

    }

    /**
     * Returns the contents of the expression tree ET.
     * @return - the contents of expression tree
     */
    public String toString() {
        return this.et.toString();
    }

    /**
     * Asks the user to type input repeatedly until they hit no.
     * @param args - string arguments.
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String in = "";

        do {
            System.out.println("Please enter an expression with spaces "
                    + "between each token: ");
            String input = kb.nextLine();
            ExpressionTranslator translator = new ExpressionTranslator(input);
            if (error) {
                System.out.print("");
                //Do nothing.
            } else {
                System.out.println(translator);
            }
            System.out.println("Enter another expression [Y/N]?");
            in = kb.nextLine();

        }

    while (in.equals("y") || in.equals("Y"));
        System.out.println("Goodbye.");
    
    }

}