/**
 * Class for flash drive
 */
public class FlashDrive extends Product
{
    // Declare variables
    private int _capacity;

    /**
    * Pull variables from product
     */
    public FlashDrive(String id, String desc, double price, int capacity)
    {
        super(id, desc, price);
        _capacity = capacity;
    }

    /**
     * Return capacity
     */
    public int getCapacity()
    {
        return _capacity;
    }

    /**
     * Print results of flash drive
     */
    public String toString()
    {
        return super.toString() + "Capacity: " + _capacity + " GB";
    }
}
