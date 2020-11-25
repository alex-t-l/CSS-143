
/**
 * ObjectList class that impersonates an ArrayList. Holds object type.
 *
 * Alex Lai
 * January 20, 2020
 */

public class ObjectList
{
    private int numElements = 0; //How many elements being used in the array
    private Object[] data = new Object[99999]; //Has a high capacity for a length of up to 99999

    /**
     * Adds an object to the Array, and increments the number of elements.
     * @param nx The object passed in with name.add(OBJECT)
     */
    public void add(Object nx){
        data[numElements] = nx;
        numElements++;
    }

    /**
     * Goes through numElements of the array and concatenates it to a String, then returns it.
     * @return All the elements of the ObjectList
     */
    @Override
    public String toString(){
        String retVal = "";
        for(int i = 0; i < numElements; i++){
            retVal += data[i] + ", ";
        }
        return retVal;
    }

    /**
     * The integer size represents how many elements are in the array.
     * @return how many elements are in the array.
     */
    public int size(){
        return numElements;
    }

    /**
     * Returns the data of a requested index.
     * @param i index of a requested object.
     * @return the Object.
     */
    public Object get(int i){
        return data[i];
    }
}

