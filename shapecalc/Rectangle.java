public class Rectangle extends Shape
{
    // Values for the 2D rectangle
    private double _length;
    private double _width;

    public Rectangle(double length, double width)
    {
        if (length <= 0 || width <= 0)
        {
            throw new IllegalArgumentException();
        }
        _length = length;
        _width = width;
    }

    /**
     * Takes the length and width and returns the area
     * @return the area
     */
    @Override
    public double calcArea()
    {
        return _length * _width;
    }

    /**
     * Takes the length and width and returns the perimeter
     * @return the perimeter
     */
    @Override
    public double calcPerimeter()
    {
        return 2 * (_length + _width);
    }

    /**
     * Gives back the length of the rectangle to the user
     * @return the length
     */
    public double getLength()
    {
        return _length;
    }

    /**
     * Gives back the width fo the rectangle
     * @return the width
     */
    public double getWidth()
    {
        return _width;
    }

    /**
     * Set the length to the dimension given by the user
     * @param length dimension given by user
     */
    public void setLength(double length)
    {
        if (length <= 0)
        {
            throw new IllegalArgumentException();
        }
        _length = length;
    }

    /**
     * Set the width to the dimension given by the user
     * @param width dimension given by the user
     */
    public void setWidth(double width)
    {
        if (width <= 0)
        {
            throw new IllegalArgumentException();
        }
        _width = width;
    }

    /**
     * Gives back a string of the rectangle
     * @return the string
     */
    @Override
    public String toString()
    {
        return String.format("%s, length=%.5f, width=%.5f",
                super.toString(), _length, _width);
    }

}