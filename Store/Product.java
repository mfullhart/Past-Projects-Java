/**
 * Class for products
 */
public abstract class Product implements Comparable<Product>
{
    // Declare variables
    private String _id;
    private String _desc;
    private double _price;

    /**
     * Create variables
     */
    public Product(String id, String desc, double price)
    {
        _id = id;
        _desc = desc;
        _price = price;
    }

    /**
     * Return id
     */
    public String getID()
    {
        return _id;
    }

    /**
     * Return description
     */
    public String getDescription()
    {
        return _desc;
    }

    /**
     * Return price
     */
    public double getPrice()
    {
        return _price;
    }

    /**
     * Compare prices
     */
    public int compareTo(Product other)
    {
        return Double.compare(this.getPrice(), other.getPrice());
    }

    /**
     * Print results of product
     */
    public String toString()
    {
        return "Product " +
                "ID: " + _id +
                ", Description: " + _desc +
                ", Price: " + _price;
    }

}
