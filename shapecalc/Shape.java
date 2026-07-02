/**
 * This is the abstract class that allows for the building of all other shapes
 *
 * @author hjohnson22@georgefox.edu
 * @author mfullhart20@georgefox.edu
 */
public abstract class Shape
{
    // Hard set value for the value of Epsilon
    private static final double EPSILON = 1e-10;

    public abstract double calcArea();

    public abstract double calcPerimeter();

    public boolean equals(Shape otherShape)
    {
        return Math.abs(this.calcArea() - otherShape.calcArea()) < EPSILON;
    }

    @Override
    public String toString()
    {
        return String.format("%s with area=%.5f",
                this.getClass().getName(), this.calcArea());
    }
}
