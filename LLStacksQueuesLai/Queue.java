
/**
 * Queue class that impersonates the Java queue except it uses Nodes- a.k.a a "Linked List Queue."
 *
 * Alex Lai
 * March 4, 2020
 */
public class Queue extends List
{
    /**
     * Default no-arg constructor.
     */
    public Queue()
    {
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
        enqueue(next);
    }

    /**
     * 
     * @param index the index to be removed.
     * @return the Object.
     * @throws LinkedListException
     */
    @Override 
    public Object remove(int index) throws LinkedListException{
        return dequeue();
    }

    /**
     * Adds an object to the back of the queue.
     * @throws LinkedListException
     */
    public void enqueue(Object obj) throws LinkedListException{
        super.insert(obj, super.size());
    }

    /**
     * Dequeues an object from the queue.
     * @return item dequeued.
     * @param LinkedListException
     */
    public Object dequeue() throws LinkedListException{
        return super.remove(0);
    }

    /**
     * Testing out our queue.
     * @param args
     * @throws LinkedListException
     */
    public static void main (String[] args) throws LinkedListException{
        Queue q = new Queue();
        //q.dequeue(); Throws a LinkedListException
        q.enqueue("oats");
        q.enqueue("eggs");
        q.enqueue("broccoli");
        System.out.println(q);
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println(q);
        q.enqueue("nuts");
        System.out.println(q);
        Queue same = new Queue();
        int size = q.size();
        for(int i = 0; i < size; i++)
        same.enqueue(q.dequeue());
        System.out.println("Same thing: " + same);
    }
}
