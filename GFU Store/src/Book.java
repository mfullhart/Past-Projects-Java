public class Book extends Product
{
    private String _author;
    private String _publisher;

    public Book(String id, String desc, double price, String author, String publisher)
    {
        super(id, desc, price);
        _author = author;
        _publisher = publisher;
    }

    public String getAuthor()
    {
        return _author;
    }

    public String get_publisher()
    {
        return _publisher;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Author: " + _author + ", Publisher: " + _publisher;
    }

}
