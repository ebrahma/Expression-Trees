//BinaryTree226Linked.java

/**
    A linked implementation for a Binary Tree ADT.
    @param <T>    the item type stored in the binary tree. 
*/
public class BinaryTree226Linked<T>  {
 
    /** A reference to the root of the tree. */
    protected BinaryNode<T> root;

    /** The count of the number of items in the tree. */
    protected int size;

    /**
        Create an empty binary tree.
    */
    public BinaryTree226Linked() {
        this.root = null;
        this.size = 0;
    }

    /**
        Create a binary tree containing a single node with
        empty left and right subtrees.
        @param element    the data item to store in the node
    */
    public BinaryTree226Linked(T element) {
        this.root = new BinaryNode<T>(element);
        this.size = 1;
    }


    /**
        Create a binary tree containing a root node with
        specified left and right subtrees.
        @param element    the data item to store in the root node
        @param leftTree    the tree to serve as left subtree of root
        @param rightTree    the tree to serve as right subtree of root
    */
    public BinaryTree226Linked(T element, 
                    BinaryTree226Linked<T> leftTree,
                    BinaryTree226Linked<T> rightTree) {

        //create new root node
        this.root = new BinaryNode<T>(element);

        //set root node's left and right references appropriately
        if (leftTree == null) {  //check to avoid NullPointerException
            this.root.left = null;
        } else {
            this.root.left = leftTree.root;
        }
        if (rightTree == null) { //check to avoid NullPointerException
            this.root.right = null;
        } else { 
            this.root.right = rightTree.root;
        }

        //calculate size of newly created tree based on subtree sizes
        this.size = leftTree.size + rightTree.size + 1;
    }


    /**
        Report the number of items currently in this tree.
        @return    the number of items
    */
    public int size() {
        return this.size;
    }

    /**
        Determine if any item exists in tree.
        @return    true exactly when tree contains 
        at least one item
    */
    public boolean isEmpty() {
        return this.size == 0; 
    }


    /**
        Return a String representing a postorder traversal of this tree.
        @return    the String representing the postorder traversal
    */
    public String toString() {
        return this.postOrder();
    }


    /**
        Return a String representing a postorder traversal of this tree.
        @return    the String representing the postorder traversal
    */
    public String postOrder() {
        return this.postOrder(this.root).trim();
    }

    /**
        Helper method that recursively executes a postorder traversal
        of the subtree rooted at the current node.
        @param current    the root node of the current subtree
        @return    the String representing the postorder traversal
    */
    private String postOrder(BinaryNode<T> current) {
        if (current == null) {
            return "";
        }
        return this.postOrder(current.left).trim() + " " 
            + this.postOrder(current.right).trim() + " " 
            + current.data;
    }

    /**
        Return the root node of this tree.
        @return    a reference to the tree's root node
    */
    protected BinaryNode<T> getRoot() {
        return this.root;
    }



/**
    A node in a binary tree.
    @param <T>    the item type stored in the binary tree. 
*/
    protected class BinaryNode<T> {
        
        /** the item stored in this node. */
        public T data;

        /** a reference to this node's left child node. */
        public BinaryNode<T> left;

        /** a reference to this node's right child node. */
        public BinaryNode<T> right;

        /**
            Create a new node with null children references.
            @param element    the data item to store in this node
        */
        public BinaryNode(T element) {
            this(element, null, null);
        }

        /**
            Create a new node with specified children references.
            @param element    the data item to store in this node
            @param theLeft     the left child node
            @param theRight     the right child node
        */
        public BinaryNode(T element, 
                      BinaryNode<T> theLeft, 
                      BinaryNode<T> theRight) {
            this.data = element;
            this.left = theLeft;
            this.right = theRight;
        }

    } //end inner class BinaryNode<T>

} //end outer class BinaryTree226Linked<T>