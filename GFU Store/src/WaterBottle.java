public class WaterBottle extends Product
{
    private int _capacity;

    public WaterBottle(String id, String desc, double price, int capacity)
    {
        super(id, desc, price);
        _capacity = capacity;
    }

    public int getCapacity()
    {
        return _capacity;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Capacity: " + _capacity + " oz";

    }
}
