/**
 * The Driver for the ArrayList, Queues, and Stack objects.
 *
 * Alex Lai
 * January 30, 2020
 */

public class ArrayBasedDataStructuresDriver {

    /**
     * Main method with all the tests.
     *
     * @param args
     */
    public static void main(String[] args) {
        stackTests();
        queueTests();
        arrayListTests();
    }

    /**
     * This method tests all the ArrayList methods: insert, remove, size, toString, isEmpty, getIndexOf, equals, and get.
     */
    private static void arrayListTests() {
        System.out.println("***** ARRAYLIST TESTS *****");
        ArrayList a = new ArrayList();

        a.insert('a', 0);
        a.insert('B', 0);
        a.insert('t', 1);
        System.out.println(a.toString());
        System.out.println("a.size: " + a.size());

        System.out.println(a.remove(0));

        System.out.println(a.toString());

        ArrayList blazers = new ArrayList();
        blazers.insert("Damian Lillard", 0);
        blazers.insert("CJ McCollum", 1);
        blazers.insert("Carmelo Anthony", 2);
        blazers.insert("Russell Westbrook", 0);
        System.out.println("Not a Blazer: " + blazers.remove(0));
        System.out.println(blazers.toString());
        blazers.insert("Trevor Ariza", 2);
        blazers.insert("Hassan Whiteside", 3);
        System.out.println("Index: " + blazers.getIndexOf("Damian Lillard"));
        System.out.println("Index of non existent object: " + blazers.getIndexOf("..."));
        System.out.println(blazers.toString());
        System.out.println("Point guard FOR THE BLAZERS... " + blazers.get(0));

        System.out.println(blazers.equals(a));

        while (a.isEmpty() == false) {
            System.out.println(a.remove(0));
        }
    }

    /**
     * Tests all Queue methods: enqueue, dequeue, size, toString, isEmpty, and equals
     */

    private static void queueTests() {
        System.out.println("***** QUEUE TESTS *****");
        Queue q = new Queue();

        q.enqueue('B');
        q.enqueue('a');
        q.enqueue('t');

        System.out.println(q.toString());
        System.out.println(q.size());

        Queue a = new Queue();

        a.enqueue('B');
        a.enqueue('a');
        a.enqueue('t');

        System.out.println(q.equals(a));

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }

    }

    /**
     * Tests all stack metods: push, pop, size, toString, isEmpty, & equals.
     */
    private static void stackTests() {
        System.out.println("***** STACK TESTS *****");
        Stack a = new Stack();
        a.push('B');
        a.push('a');
        a.push('t');
        System.out.println("Stack size: " + a.size());
        Stack b = new Stack();
        b.push('B');
        b.push('a');
        b.push('t');
        b.push('s');

        System.out.println(a.equals(b));
        System.out.println(a.toString());
        while (a.isEmpty() == false) {
            System.out.println(a.pop());
        }
    }
}
