/*
Tarun Vaidhyanathan
115510562
R02
 */
import java.util.Stack;
/**
 * The PackageStack class represents a stack of Package objects.
 */
public class PackageStack {
    /** The maximum capacity of the stack. */
    public final int CAPACITY = 7;
    /** The stack of Package objects. */
    Stack<Package> packageStack = new Stack<>();
    /**
     * Pushes a Package object onto the stack.
     *
     * @param x The Package object to be pushed onto the stack.
     */
    public void push(Package x){
        this.packageStack.push(x);
    }
    /**
     * Pops the top Package object from the stack.
     *
     * @return The Package object popped from the stack.
     */
    public Package pop(){
       Package temp = this.packageStack.peek();
       this.packageStack.pop();
       return temp;
    }
    /**
     * Retrieves the top Package object from the stack without removing it.
     *
     * @return The top Package object from the stack.
     */
    public Package peek(){
        return this.packageStack.peek();
    }
    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise.
     */
    public boolean isFull(){
        if (this.packageStack.size() == CAPACITY){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty(){
        return this.packageStack.isEmpty();
    }
    /**
     * Returns a string representation of the stack.
     *
     * @return A string representation of the stack.
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < this.packageStack.size(); i++){
            Package print = this.packageStack.get(i);
            str.append(print.toString());
        }
        return str.toString();
    }
}
