
/**
 * ItemNotFound Exception
 *
 * Alex Lai
 * February 19 ,2020
 */
public class ItemNotFoundException extends Exception
{
    /**
     * No arg constructor for ItemNotFoundException
     */
    public ItemNotFoundException()
    {
       super();
    }
    
    /**
     * Constructor for ItemNotFoundException that will output the String
     */
    public ItemNotFoundException(String s){
        super(s);
}
}