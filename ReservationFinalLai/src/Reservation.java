/**
 * Represents a request to the system to reserve an item for a specific time slot.
 * Alex Lai
 * March 9, 2020
 */
public abstract class Reservation implements Comparable {
    protected String customer = "";
    protected int time;
    protected String resourceID;

    public Reservation(String customerName, int timeslot) {
        customer = customerName;
        time = timeslot;
    }

    /**
     * Copy Constructor.
     *
     * @param r Reservation object.
     */
    public Reservation(Reservation r) {
        this.customer = r.getCustomer();
        this.time = r.getTime();
        this.resourceID = r.resourceID;
    }

    public abstract int getScore(ReservableItem res);

    /**
     * @return the Customer's name.
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @return the Customer's time slot.
     */
    public int getTime() {
        return time;
    }

    /**
     * @return resource ID.
     */
    public String getResourceID() {
        return resourceID;
    }

    /**
     * @return Customer, time slot and score in a string.
     */
    public String toString() {
        return "Reservation customer: " + getCustomer() + "timeSlot:" + getTime() + ", Resource ID: " + getResourceID();
    }

    /**
     * Sets the ID of the reservable item, IDs are read from files.
     *
     * @param id ID of reservable item.
     */
    public void setResourceId(String id) {
        resourceID = id;
    }

    /**
     * Compares customers names and returns a value of difference
     *
     * @param o Object
     * @return Value of difference between customer names, -1 if invalid object.
     */
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Reservation) || (o == null))
            return -1;
        Reservation that = (Reservation) o;
        return this.getCustomer().compareTo(that.getCustomer());
    }
}
