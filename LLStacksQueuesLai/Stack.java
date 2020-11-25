
/**
 * Stack class that impersonates the Java stack except it uses Nodes- a.k.a a "Linked List Stack."
 *
 * Alex Lai
 * March 4, 2020
 */
public class Stack extends List
{
    /**
     * Default no arg construtor.
     */
    public Stack (){
        super();
    }

    /**
     * Overrided insert method.
     * @param next the object.
     * @param index the index.
     * @throws LinkedListException
     */
    @Override
    public void insert(Object next, int index) throws LinkedListException{
        push(next);
    }

    /**
     * @param index the index to be removed.
     * @return the Object.
     * @throws LinkedListException
     */
    @Override 
    public Object remove(int index) throws LinkedListException{
        return pop();
    }

    /**
     * Add to the stack.
     * @param Object to be added to the stack.
     * @throws LinkedListException
     */
    public void push(Object obj) throws LinkedListException{
        super.insert(obj, 0);
    }

    /**
     * Remove the object on the top of the stack.
     * @return object on the top of the stack.
     * @throws LinkedListException 
     */
    public Object pop() throws LinkedListException{
        return super.remove(0);
    }

    /**
     * Test method for Linked List Stack.
     * @param args 
     * @throws LinkedListException
     */
    public static void main (String[] args) throws LinkedListException{
        Stack books = new Stack();
        //books.pop(); throws LinkedListException.
        books.push("Absolute Java");
        books.push("The Holy Bible");
        books.push("The Dictionary");
        System.out.println(books);
        System.out.println(books.size());
        books.pop();
        System.out.println("After popping once: "+books);
        Stack reversed = new Stack();
        books.push("The Dictionary");
        int size = books.size();
        while(!books.isEmpty())
            reversed.push(books.pop());
        System.out.println("Original List Reversed :" +reversed);
    }
}
