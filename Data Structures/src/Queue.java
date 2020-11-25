/**
 * A homemade Queue class that simulates the built in Queue java class, using Arrays instead.
 *
 * Alex Lai
 * January 29, 2020
 */
public class Queue {
    private Object[] queue = new Object[10]; //the queue itself.
    private int numElements = 0; //how many things are in the queue
    int back; //the back of the queue.

    /**
     * Enqueue adds an object to the back of the queue.
     *
     * @param o the object to be added to the back of the queue.
     */
    public void enqueue(Object o) {
        if (numElements + 1 == queue.length) //If the queue runs low on space, the array can expand itself double it's previous length;
            expand();
        queue[numElements] = o;
        numElements++;
        back = numElements - 1;

    }

    /**
     * Removes and returns the object in the front of the queue. Everything shifts left.
     *
     * @return the Object in front of the queue.
     */
    public Object dequeue() {
        Object retVal = queue[0];
        shift();
        back--;
        numElements--;
        return retVal;
    }

    /**
     * Returns the size of the queue.
     *
     * @return size of the queue
     */
    public int size() {
        return numElements;
    }

    /**
     * Shifts the array to the left.
     */
    private void shift() {
        for (int j = 0; j < back; j++)
            queue[j] = queue[j + 1];
    }

    /**
     * Expand or "Resize" will double the size of the queue if it runs out of space.
     */
    private void expand() {
        Object[] box = new Object[queue.length * 2]; //Double the size of Old Array.
        for (int i = 0; i < numElements; i++)
            box[i] = queue[i];

        queue = box;
    }

    /**
     * Checks if the Queue is empty.
     *
     * @return whether or not queue is empty.
     */
    public boolean isEmpty() {
        if ((numElements == 0))
            return true;
        else
            return false;
    }

    /**
     * Checks if an queue is equal to another queue by going through every index.
     *
     * @param other
     * @return
     */
    public boolean equals(Object other) {
        if ((other == null) || !(other instanceof Queue)) //Checks if the other object is an Queue
            return false;

        Queue that = (Queue) other;
        if (this.size() != that.size())
            return false;

        for (int i = 0; i < numElements; i++) {
            if ((this.queue[i]).equals(that.queue[i]))
                continue;
            else
                return false;
        }
        return true;
    }

    /**
     * Overrided toString method.
     *
     * @return A string that contains the objects from the queue.
     */
    @Override
    public String toString() {
        String str = "Front  ";
        for (int i = 0; i < numElements; i++)
            str += queue[i] + "  ";
        return str + " Back";
    }

}