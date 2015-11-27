//ExpressionTreeInterface.java

/**
    An interface extending the Iterable interface that expresses one 
    additional required method for any class that implements it.  

    For the purposes of this assignment, the iterator for the expression 
    tree must return the contents of the tree in prefix notation, with 
    individual tokens separated by single spaces.  No parentheses
    should be added.
*/
public interface ExpressionTreeInterface extends Iterable<ExpressionTreeToken> {

    /**
        Return an infix representation of an expression tree, using 
        parentheses to indicate precedence.  

        See assignment description for examples of proper parenthesization.

        @return    the appropriate parenthesized infix expression
    */
    String getParenthesizedInfix();
}