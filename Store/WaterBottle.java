/**
 * Class for water bottle
 */
public class WaterBottle extends Product
{
    // Declare variables
    private int _capacity;

    /**
     * Pull variables from product
     */
    public WaterBottle(String id, String desc, double price, int capacity)
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
     * Print results of watter bottle
     */
    public String toString()
    {
        return super.toString() + "Capacity: " + _capacity + " oz";

    }
}
