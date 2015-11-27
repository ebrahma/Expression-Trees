import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Sets up the expression tree.
 * @author Emily Brahma
 *
 */
public class ExpressionTree extends BinaryTree226Linked<ExpressionTreeToken> 
    implements ExpressionTreeInterface {
    
    /**
        Create an empty expression tree.
    */
    public ExpressionTree() {
        super();
    }

    /**
        Create an expression tree containing a root node with
        specified left and right subtrees.
        @param element    the data item to store in the root node
        @param leftTree    the tree to serve as left subtree of root
        @param rightTree    the tree to serve as right subtree of root
    */
    public ExpressionTree(ExpressionTreeToken element, 
            BinaryTree226Linked<ExpressionTreeToken> leftTree, 
            BinaryTree226Linked<ExpressionTreeToken> rightTree) {
        super(element, leftTree, rightTree);
    
    }

    /**
        Create a expression tree containing a single node with
        empty left and right subtrees.
        @param tok    the data item to store in the node
    */
    public ExpressionTree(ExpressionTreeToken tok) {
        super(tok);
        
    }

    /**
        Return a String representing an Infix formatting of the user input.
        @return    the String representing the Infix formatting
    */
    public String getParenthesizedInfix() {
        
        return this.inOrder(this.root).trim();
    }

    /**
        Helper method that recursively executes an inorder traversal
        of the subtree rooted at the current node.
        @param current    the root node of the current subtree
        @return    the String representing the inorder traversal
    */
    private String inOrder(BinaryNode<ExpressionTreeToken> current) {
        if (current == null) {
            return "";
        }

        if (current.data.isOperator()) {
            return "(" + this.inOrder(current.left).trim() + " " + current.data 
                    + " " + this.inOrder(current.right).trim() + ")";
        }

        
        return  this.inOrder(current.left).trim() + " " + current.data + " "
                + this.inOrder(current.right).trim() + " ";
            
            
    }

    /**
        Return a String representing a preorder traversal of this tree.
        @return    the String representing the postorder traversal
    */
    public String preOrder() {
        return this.preOrder(this.root).trim();
    }

    /**
        Helper method that recursively executes a preorder traversal
        of the subtree rooted at the current node.
        @param current    the root node of the current subtree
        @return    the String representing the postorder traversal
    */
    private String preOrder(BinaryNode<ExpressionTreeToken> current) {
        if (current == null) {
            return "";
        }
        return current.data + " " + this.preOrder(current.left).trim() + " " 
            + this.preOrder(current.right).trim();
            
    }

    /**
        Return a String representing a Postfix, Prefix, 
        and Infix formatting of the user input.
        @return    the String representing the Postfix, 
        Prefix, and Infix formatting
    */
    public String toString() {
        //System.out.println("hello");
        //return root.toString();
        return "Postfix: " + super.postOrder() + "\nPrefex: " 
            + this.preOrder() + "\nInFix: " + this.getParenthesizedInfix();
        //return super.postOrder() + "\n next" + preOrder() + "\n" + inOrder();
        
    }


    /**
     * Creates an iterator for expression tree.
     * @return - returns an iterator.
     */
    public Iterator<ExpressionTreeToken> iterator() {
        ArrayList<ExpressionTreeToken> temp = 
                new ArrayList<ExpressionTreeToken>();

        String vals = this.preOrder();
        Scanner input = new Scanner(vals);
        while (input.hasNext()) {
            ExpressionTreeToken nextObject = 
                    new ExpressionTreeToken(input.next());
            temp.add(nextObject);
        }

        return temp.iterator();
    } 
}