//Stack226.java

/**
    An interface for a generic Stack ADT.
    @param <T>    the item type stored in the Stack
*/
public interface Stack226<T> {

    /**
        Add new element to top of stack.
        @param element    the item to put onto top of stack
    */
    void push(T element);

    /**
        Remove element from top of stack.
        @return    the removed item
        @throws    StackEmptyException
    */
    T pop();

    /**
        Access element at top of stack, but
        do not remove it.
        @return    the accessed item
        @throws    StackEmptyException
    */
    T peek();

    /**
        Report the number of items currently in stack.
        @return    the number of items
    */
    int size();

    /**
        Determine if any item exists in stack.
        @return    true exactly when stack contains 
        at least one item
    */
    boolean isEmpty();

    /**
        Create and return a string representation of the
        stack.  Items are separated by single spaces, and
        the bottom element appears earliest in the String.
        @return    the string representation of the stack
    */
    String toString();

}