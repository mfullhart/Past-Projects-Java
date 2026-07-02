public class Product implements Comparable<Product>
{
    private String _id;
    private String _desc;
    private double _price;

    public Product(String id, String desc, double price)
    {
        _id = id;
        _desc = desc;
        _price = price;
    }

    public String getID() {
        return _id;
    }

    public String getDescription() {
        return _desc;
    }

    public double getPrice() {
        return _price;
    }

    public int compareTo(Product other)
    {
        return Double.compare(this.getPrice(), other.getPrice());
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "_id" + _id +
                "_desc" + _desc +
                "_price" + _price +
                '}';
    }

}
