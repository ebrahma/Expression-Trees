/**
 * 
 * @author Emily Brahma
 * The stack implementation of generic object type
 * @param <T> - The generic object type for the stack
 */
public class Stack226Array<T> implements Stack226<T> {
    /**
     * Setting the default capacity.
     */
    private static final int DEFAULT_CAPACITY = 100;
    /**
     * The stack of type t objects.
     */
    private T[] stack;
    /**
     * The index of the next position to use.
     */
    private int top;
    
    /**
     * Initializes the stack array to default capacity.
     */
    public Stack226Array() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initializes the stack array to initialCapacity.
     * @param initialCapacity - the starting capacity
     */
    public Stack226Array(int initialCapacity) {
        this.stack = (T[]) new Object[initialCapacity];
        this.top = 0;
    }


    /**
     * Adds element T to the stack.
     * @param element - the element being added to the stack.
     */
    public void push(T element) {

        if (this.stack.length <= this.top) {
            //increase capacity
            this.expandCapacity();
        }
        this.stack[this.top] = element;
        this.top++;
    }
    /**
     * Expands the capacity of the stack.
     */
    private void expandCapacity() {

        //double the current capacity
        T[] temp = (T[]) new Object[this.stack.length * 2];

        //or could use System.arraycopy method
        for (int i = 0; i < this.stack.length; i++) {
            temp[i] = this.stack[i];
        }
        this.stack = temp;
    }
    
    /**
     * Removes and returns top element from stack.
     * @return - the top element of the stack
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new StackEmptyException("empty stack on pop");
        }
        this.top--;
        T result = this.stack[this.top];
        this.stack[this.top] = null;
        return result;
    }

    /**
     * Returns the top elements of the stack.
     * @return - the top element of the stack.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new StackEmptyException("empty stack on peek");
        }
        return this.stack[this.top - 1];
    }

    /**
     * Indicates if there is anything on stack.
     * @return - true if empty
     */
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    /**
     * Number of elements in the stack.
     * @return returns what is at the top.
     */
    public int size() {
        return this.top;        
    }

    /**
     * Returns a string with contents of stack.
     * @return - returns the string of contents.
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < this.top; i++) {
            result += this.stack[i] + " ";
        }
        return result;
    }

}