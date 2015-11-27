//StackEmptyException.java

/**
    Exception class to represent a Stack instance which contains
    no items.  The exception is unchecked.
*/
public class StackEmptyException extends RuntimeException {

    /**
         Constructor with no arguments which uses default message.
    */
    public StackEmptyException() {
        super("***Exception: stack is empty***");
    }

    /**
         Constructor whose argument is a custom message.
        @param message    the custom message String
    */
    public StackEmptyException(String message) {
        super(message);  //calls RuntimeException's constructor
    }

}