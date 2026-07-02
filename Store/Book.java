/**
 * Class for book
 */
public class Book extends Product
{
    private String _author;
    private String _publisher;

    /**
     * Pull variables from product
     */
    public Book(String id, String desc, double price, String author, String publisher)
    {
        super(id, desc, price);
        _author = author;
        _publisher = publisher;
    }

    /**
     * Return author
     */
    public String getAuthor()
    {
        return _author;
    }

    /**
     * Return publisher
     */
    public String getPublisher()
    {
        return _publisher;
    }

    /**
     * Print results of book
     */
    public String toString()
    {
        return super.toString() + "Author: " + _author + ", Publisher: " + _publisher;
    }
}