//ExpressionTreeToken.java

/**
    A class to represent one item stored in an expression tree.
    This item could be an operator (valid ones are +,-,*,/), or
    it could be an operand such as 24 or x.
*/
public class ExpressionTreeToken {

    /** the item itself. */
    private String contents;

    /** 
        Construct a token with specified contents.
        @param theToken    the item to store
     */
    public ExpressionTreeToken(String theToken) {
        this.contents = theToken;
    }

    /**
        Report whether content of token is one of
        the four allowed operators "+", "-", "*", or "/".
        @return    true exactly when token is an operator.
    */
    public boolean isOperator() {
        return (this.contents.equals("+") 
            || this.contents.equals("-")
            || this.contents.equals("*")
            || this.contents.equals("/"));
    }

    /**
        Return the contents of this token.
        @return    the String contents
    */
    public String toString() {
        return this.contents;
    }

}