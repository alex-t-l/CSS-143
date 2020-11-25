
/**
 * The List class that uses nodes. 
 * With this class, you can insert/remove objects to a list. 
 * This class impersonates Java's LinkedList.
 *
 * Alex Lai
 * March 2, 2020
 */
public class List
{
    private Node head = null; //Start of the LinkedList. An empty list.
    /**
     * Insert a Node to our LinkedList at a specified index.
     * @param next Object to be added
     * @param index Where to add the object.
     * @throws LinkedListException if inserted at an invalid index.
     */
    public void insert(Object next, int index) throws LinkedListException{

        if(index != 0 && isEmpty()) //Empty list.
            throw new LinkedListException("Invalid index/empty list.");
        else if(head == null){ //If the list is empty, add the data as the head and make null the pointer.
            head = new Node (next, head);
            return;
        }
        else if(index > 1 && size() == 1) //An invalid index...
            throw new LinkedListException("List only has one index. Add to the first index.");
        else if(index == 0 && size() == 1){ //If index is 0 and size is 1... 
            Node otherHead = head; //The current head will now be the next object pointer.
            head = new Node (next, otherHead); //The head will now be the new object.
            return;
        }
        else if(index == 1 && size() == 1){
            head.next = new Node (next, null);
            return;
        }

        else if(index > size())
            throw new LinkedListException("Invalid index: " + index + ", max index is: " + (size()-1));

        else if(index == 0){
            Node otherHead = head;
            head = new Node (next, otherHead);
            return;
        }
        else{
            Node updatedNode = moveNode(index);
            Node movedNode = updatedNode.next;
            updatedNode.next = new Node (next, movedNode);
        }
    }

    /**
     * Removes a node at a specified index.
     * @param index of a Node to be removed.
     * @throws LinkedListException if the index specified is invalid.
     */
    public Object remove(int index) throws LinkedListException{
        Object obj;
        if(isEmpty())
            throw new LinkedListException("Can't remove from an empty list.");
        else if(index > 0 && size() == 1) //index is greater than 0, size of 1.... invalid.
            throw new LinkedListException("Invalid index.");
        else if(index == 0 && size() == 1){ //If index is 0 and size is 1...
            obj = head.data; 
            head = null; //Remove head.
            return obj; //Return data.
        }
        else if(index == 0){
            obj = head.data;
            head = head.next; //head.next is now head.
            return obj;

        }
        else{
            if(index > size())
                throw new LinkedListException("Invalid index: " + index + ", max index is: " + (size()-1));
            Node updatedNode = moveNode(index); //Will move the node to before the given index
            Node n = updatedNode.next; //Pointing to the removed index
            updatedNode.next = n.next; //The removed value is now the pointer of the node left to the removed value
            n.next = null; //Remove node links
            return n; // return data of deleted node.
        }
    }

    /**
     * @return size of LinkedList.
     */
    public int size(){
        if (head == null) //If the list is empty, size is zero.
            return 0;

        int counter = 1;
        Node current = head;
        while(current.next != null){ //Will count until it's before null which symbolizes the end of the list.
            current = current.next;
            counter++;
        }
        return counter;
    }

    /**
     * @return LinkedList in String format.
     */
    @Override
    public String toString(){
        String list = "";
        Node node = head;
        for(int i = 0; i < size(); i++){
            list += node.data + ", ";
            node = node.next;
        }
        return list;
    }

    /**
     * @return whether or not the LinkedList is empty.
     */
    public boolean isEmpty(){
        if(size() == 0)
            return true;
        else 
            return false;
    }

    /**
     * @return index of object, returns -1 if not found.
     */
    public int indexOf(Object target){
        Node node = head;
        for(int i = 0; i< size(); i++){
            if(head.data == null)
                return -1;
            if(node.data.equals(target))
                return i;
            else if (node.next == null) //If this happens, then we've reached the end of the list.
                return -1; 
            else
                node = node.next;
        }
        return -1;
    }

    /**
     * Add to the end of the list.
     * @param obj Object to be added.
     * @throws LinkedListException try/catch is here to get rid of errors.
     */
    public void append(Object obj) throws LinkedListException{
        insert(obj, size());
        return;
    }

    /**
     * A loop that moves to the node BEFORE the specified index
     * @param Index of Node.
     * @return Nod before index i
     */
    private Node moveNode(int i){
        Node n = head;
        for(int j = 1; j < i; j++)
            n = n.next;
        return n;
    }

    /**
     * Node class.
     */
    private class Node{
        public Object data; //Our data object.
        public Node next; //The next node.

        /**
         * Our Node's constructor.
         * @param obj our data object.
         * @param next Next node.
         */
        private Node(Object obj, Node next){
            data = obj;
            this.next = next;
        }

    }

    /**
     * @param args
     */
    public static void main (String[] args) throws LinkedListException{
        List empty = new List();
        List one = new List();
        List multiple = new List();

        one.append("hi");
        multiple.append(10);
        multiple.append (20);
        multiple.append (30);

        System.out.println(multiple.size());

        System.out.println("Empty:"+empty);
        System.out.println("One:"+one);
        System.out.println("Multiple:"+ multiple);  

        one.remove(0);
        multiple.remove(1);
        System.out.println("One (upon remove):"+one);
        System.out.println("Multiple (upon remove):"+ multiple);

        one.append(600);
        multiple.append(400);
        System.out.println("One (on append):"+one);
        System.out.println("Multiple(on append):"+ multiple);

        //empty.remove(0); //Can't remove from an empty list.
        //multiple.remove(999);  //max size is 2, throws LL error.

        System.out.println(multiple.indexOf(400));
        System.out.println(empty.isEmpty());
    }
}
