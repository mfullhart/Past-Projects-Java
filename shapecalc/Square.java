public class Square extends Shape
{
    // Values for a square
    private double _length;
    private double _area;
    private double _perimeter;

    public Square(double length)
    {
        _length = length;
    }

    /**
     * Takes the length and returns the area
     * @return the area
     */
    @Override
    public double calcArea()
    {
        return _length * _length;
    }

    /**
     * Takes the length and returns the perimeter
     * @return the perimeter
     */
    @Override
    public double calcPerimeter()
    {
        return 4 * _length;
    }

    /**
     * Takes the area and returns the length
     * @return the length
     */
    public double calcLengthFromArea()
    {
        return Math.sqrt(_area);
    }

    /**
     * Takes the perimeter and returns the length
     * @return the length
     */
    public double calcLengthFromPerimeter()
    {
        return _perimeter / 4;
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
     * Set the length to the dimension given by the user
     * @param length dimension given by user
     */
    public void setLength(double length)
    {
        _length = length;
    }

    /**
     * Gives back the length of the rectangle to the user
     * @return the length
     */
    public double getArea()
    {
        return _length;
    }

    /**
     * Gives back a string of the rectangle
     * @return the string
     */
    @Override
    public String toString()
    {
        return String.format("%s, length=%.5f, area=%.5f, perimeter=%.5f",
                super.toString(), _length, _area, _perimeter);
    }
}