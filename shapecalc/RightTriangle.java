public class RightTriangle extends Shape
{
    //Values for a right triangle
    private double _base;
    private double _height;
    private double _hypotenuse;

    public RightTriangle(double base, double height)
    {
        _base = base;
        _height = height;
    }

    /**
     * Takes the length and returns the area
     * @return the area
     */
    @Override
    public double calcArea()
    {
        return (_base * _height)/2;
    }

    @Override public double calcPerimeter()
    {
        return Math.sqrt((Math.pow(_base, 2) + Math.pow(_height, 2))) + _base + _height;
    }

    /**
     * Gives back the base of the right triangle to the user
     * @return the length
     */
    public double getBase()
    {
        return _base;
    }

    /**
     * Set the base to the dimension given by the user
     * @param base dimension given by user
     */
    public void setBase(double base)
    {
        _base = base;
    }
    /**
     * Gives back the base of the right triangle to the user
     * @return the length
     */
    public double getHeight()
    {
        return _height;
    }

    /**
     * Set the height to the dimension given by the user
     * @param height dimension given by user
     */
    public void setHeight(double height)
    {
        _height = height;
    }
}