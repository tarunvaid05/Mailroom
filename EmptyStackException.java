/*
Tarun Vaidhyanathan
115510562
R02
 */
/**
 * The EmptyStackException class represents an exception for when attempting
 * to access or remove an element from an empty stack.
 */
public class EmptyStackException extends Exception {
    /**
     * Constructs a new EmptyStackException with the specified error message.
     *
     * @param error The error message describing the exception.
     */
    public EmptyStackException(String error) {
        super(error);
    }
}
