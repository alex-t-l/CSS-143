/**
 * A homemade Stack class that simulates the built in Stack java class, using Arrays instead.
 * <p>
 * Alex Lai
 * January 30, 2020
 */
public class Stack {
    private Object[] stack = new Object[10]; //the stack itself.
    private int things = 0; //how many things are in the stack.

    /**
     * Will pop the highest object on the stack.
     *
     * @return the latest index of the stack.
     */
    public Object pop() {
        if (things == 0)
            throw new RuntimeException("You can't push an empty stack.");
        things--;
        return stack[things];
    }

    /**
     * Stacks an object onto the pile of objects.
     *
     * @param o the object to be stacked.
     */
    public void push(Object o) {
        if (things + 1 == stack.length)
            expand();
        stack[things] = o;
        things++;
    }

    /**
     * Expand or "Resize" will double the size of the array if it runs out of space.
     */
    private void expand() {
        Object[] box = new Object[stack.length * 2]; //Double the size of Old Array.
        for (int i = 0; i < things; i++)
            box[i] = stack[i];

        stack = box;
    }

    /**
     * Returns the size of the stack.
     *
     * @return size of the stack
     */
    public int size() {
        return things;
    }

    /**
     * Overrided toString method.
     *
     * @return A string that contains the objects from the stack.
     */
    @Override
    public String toString() {
        String str = "Bottom  ";
        for (int i = 0; i < things; i++)
            str += stack[i] + "  ";

        return str + "Top";
    }

    /**
     * Checks if an stack is equal to another stack by going through every index.
     *
     * @param other
     * @return
     */
    public boolean equals(Object other) {
        if ((other == null) || !(other instanceof Stack)) //Checks if the other object is a Stack
            return false;

        Stack that = (Stack) other;
        if (this.size() != that.size())
            return false;

        for (int i = 0; i < things; i++) {
            if ((this.stack[i]).equals(that.stack[i]))
                continue;
            else
                return false;
        }
        return true;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return whether or not stack is empty.
     */
    public boolean isEmpty() {
        if ((things == 0))
            return true;
        else
            return false;
    }
}
