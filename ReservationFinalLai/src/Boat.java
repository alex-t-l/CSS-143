import java.util.*;

/**
 * Represents a boat.
 * March 10, 2020
 * Alex Lai
 */
public class Boat extends ReservableItem{
    /**
     * Constructor
     * @param scanner goes through the file
     */
    public Boat(Scanner scanner){
        super.ID = scanner.nextLine();
        scanner.nextLine();
    }
}
