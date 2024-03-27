/*
Tarun Vaidhyanathan
115510562
R02
 */
/**
 * The FullStackException class represents an exception for when attempting
 * to add an element to a stack that is already full.
 */
public class FullStackException extends Exception{
    /**
     * Constructs a new FullStackException with the specified error message.
     *
     * @param error The error message describing the exception.
     */
    public FullStackException(String error){
        super(error);
    }
}
