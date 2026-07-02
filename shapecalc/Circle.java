import java.lang.Math;

public class Circle extends Shape
{
    // Values for a circle
    private double _radius;
    private double _diameter;
    private double _area;
    private double _perimeter;

    /**
     * construct a circle and validate radius
     * @param radius to create circle from
     */
    public Circle(double radius)
    {
        if (radius <= 0)
        {
            throw new IllegalArgumentException();
        }
        _radius = radius;
    }

    /**
     * Takes the radius and returns the area
     * @return the area
     */
    @Override
    public double calcArea()
    {
        return Math.PI * (Math.pow(_radius, 2));
    }

    // Calculate area from diameter
    // Calculate area from circumference??

    /**
     * Takes the radius and returns the perimeter
     * @return the perimeter
     */
    @Override
    public double calcPerimeter()
    {
        return 2 * Math.PI * _radius;
    }

    // Calculate perimeter from diameter
    // Calculate perimeter from area

    /**
     * Takes the area and returns the radius
     * @return the radius
     */
    public double calcRadius()
    {
        return Math.sqrt(_area / Math.PI);
    }

    // Calculate radius from diameter
    // Calculate radius from perimeter

    /**
     * Gives back the radius of the circle to the user
     * @return the radius
     */
    public double getRadius()
    {
        return _radius;
    }

    /**
     * Gives back the diameter of the circle to the user
     * @return the width
     */
    public double getDiameter()
    {
        return _diameter;
    }

    /**
     * Gives back the area of the circle to the user
     * @return the area
     */
    public double getArea()
    {
        return _area;
    }

    /**
     * Gives back the perimeter of the circle to the user
     * @return the perimeter
     */
    public double getPerimeter()
    {
        return _perimeter;
    }

    /**
     * Set the length to the dimension given by the user
     * @param radius dimension given by user
     */
    public void setRadius(double radius)
    {
        if (radius <= 0)
        {
            throw new IllegalArgumentException();
        }
        _radius = radius;
    }

    /**
     * Set the width to the dimension given by the user
     * @param diameter dimension given by the user
     */
    public void setDiameter(double diameter)
    {
        _diameter = diameter;
    }

    /**
     * Set the area to the dimension given by the user
     * @param area dimension given by the user
     */
    public void setArea(double area)
    {
        _area = area;
    }

    /**
     * Set the perimeter to the dimension given by the user
     * @param perimeter dimension given by the user
     */
    public void setPerimeter(double perimeter)
    {
        _perimeter = perimeter;
    }

    /**
     * Gives back a string of the circle values
     * @return a string of the circle values
     */
    @Override
    public String toString()
    {
        return String.format("%s, radius=%.5f, diameter=%.5f, area=%.5f, perimeter=%.5f",
                super.toString(), _radius, _diameter, _area, _perimeter);
    }
}