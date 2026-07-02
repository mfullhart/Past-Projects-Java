import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JunitTests
{

    @Test
    public void testCircleAreaAndPerimeter()
    {
        Circle circle = new Circle(5.0);
        assertEquals(Math.PI * 25, circle.calcArea(), 1e-10, "Circle area calculation is incorrect.");
        assertEquals(2 * Math.PI * 5, circle.calcPerimeter(), 1e-10, "Circle perimeter calculation is incorrect.");
    }

    @Test
    public void testRectangleAreaAndPerimeter()
    {
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        assertEquals(24.0, rectangle.calcArea(), 1e-10, "Rectangle area calculation is incorrect.");
        assertEquals(20.0, rectangle.calcPerimeter(), 1e-10, "Rectangle perimeter calculation is incorrect.");
    }

    @Test
    public void testRightTriangleAreaAndPerimeter()
    {
        RightTriangle triangle = new RightTriangle(3.0, 4.0);
        assertEquals(6.0, triangle.calcArea(), 1e-10, "Right triangle area calculation is incorrect.");
        assertEquals(12.0, triangle.calcPerimeter(), 1e-10, "Right triangle perimeter calculation is incorrect.");
    }

    @Test
    public void testSquareAreaAndPerimeter()
    {
        Square square = new Square(4.0);
        assertEquals(16.0, square.calcArea(), 1e-10, "Square area calculation is incorrect.");
        assertEquals(16.0, square.calcPerimeter(), 1e-10, "Square perimeter calculation is incorrect.");
    }

    @Test
    public void testShapeEquality()
    {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(Math.sqrt(25 / Math.PI));
        assertTrue(circle1.equals(circle2), "Circle equality check failed.");

        Rectangle rectangle1 = new Rectangle(4.0, 6.0);
        Rectangle rectangle2 = new Rectangle(3.0, 8.0);
        assertFalse(rectangle1.equals(rectangle2), "Rectangle equality check failed.");
    }

    @Test
    public void testToString()
    {
        Circle circle = new Circle(5.0);
        assertTrue(circle.toString().contains("Circle with area=78.53982"), "Circle toString format is incorrect.");

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        assertTrue(rectangle.toString().contains("Rectangle with area=24.00000"), "Rectangle toString format is incorrect.");
    }

    // Circle Tests
    @Test
    public void testCircleAreaZeroRadius()
    {
        Circle circle = new Circle(0.0);
        assertEquals(0.0, circle.calcArea(), 1e-10, "Circle area should be zero for radius 0.");
    }

    @Test
    public void testCirclePerimeterZeroRadius()
    {
        Circle circle = new Circle(0.0);
        assertEquals(0.0, circle.calcPerimeter(), 1e-10, "Circle perimeter should be zero for radius 0.");
    }

    @Test
    public void testCircleSetRadius()
    {
        Circle circle = new Circle(5.0);
        circle.setRadius(10.0);
        assertEquals(Math.PI * 100, circle.calcArea(), 1e-10, "Circle area not updated correctly after setting radius.");
    }

    @Test
    public void testCircleToStringFormat()
    {
        Circle circle = new Circle(3.0);
        assertTrue(circle.toString().contains("Circle with area=28.27433"), "Circle toString format is incorrect.");
    }

    @Test
    public void testNegativeRadiusForCircle()
    {
        Circle circle = new Circle(-3.0);
        assertThrows(IllegalArgumentException.class, circle::calcArea, "Negative radius should throw an exception.");
    }

    @Test
    public void testCircleNegativeRadius()
    {
        assertThrows(IllegalArgumentException.class, () -> new Circle(-5.0), "Negative radius should throw an exception.");
    }

    @Test
    public void testCircleAreaVerySmallRadius()
    {
        Circle circle = new Circle(1e-12);
        assertEquals(Math.PI * Math.pow(1e-12, 2), circle.calcArea(), 1e-20, "Circle area incorrect for very small radius.");
    }

    @Test
    public void testCircleSetInvalidRadius()
    {
        Circle circle = new Circle(5.0);
        assertThrows(IllegalArgumentException.class, () -> circle.setRadius(-3.0), "Setting negative radius should throw an exception.");
    }

    @Test
    public void testCirclePrecisionLossLargeRadius()
    {
        Circle circle = new Circle(1e9);
        assertEquals(Math.PI * Math.pow(1e9, 2), circle.calcArea(), 1e3, "Circle area calculation may lose precision for large radius.");
    }

    @Test
    public void testCircleEqualsDifferentRadius()
    {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(6.0);
        assertFalse(circle1.equals(circle2), "Circles with different radii should not be equal.");
    }

    // Rectangle Tests
    @Test
    public void testRectangleAreaZeroLength()
    {
        Rectangle rectangle = new Rectangle(0.0, 5.0);
        assertEquals(0.0, rectangle.calcArea(), 1e-10, "Rectangle area should be zero for length 0.");
    }

    @Test
    public void testRectanglePerimeterZeroWidth()
    {
        Rectangle rectangle = new Rectangle(5.0, 0.0);
        assertEquals(10.0, rectangle.calcPerimeter(), 1e-10, "Rectangle perimeter incorrect when width is zero.");
    }

    @Test
    public void testRectangleSetWidth()
    {
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        rectangle.setWidth(10.0);
        assertEquals(28.0, rectangle.calcPerimeter(), 1e-10, "Rectangle perimeter not updated correctly after setting width.");
    }

    @Test
    public void testRectangleToStringFormat()
    {
        Rectangle rectangle = new Rectangle(7.0, 3.0);
        assertTrue(rectangle.toString().contains("Rectangle with area=21.00000"), "Rectangle toString format is incorrect.");
    }

    @Test
    public void testNegativeDimensionsForRectangle()
    {
        Rectangle rectangle = new Rectangle(-4.0, 5.0);
        assertThrows(IllegalArgumentException.class, rectangle::calcArea, "Negative dimensions should throw an exception.");
    }

    @Test
    public void testRectangleNegativeDimensions()
    {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-4.0, 3.0), "Negative dimensions should throw an exception.");
    }

    @Test
    public void testRectangleSquareEquivalence()
    {
        Rectangle rectangle = new Rectangle(4.0, 4.0);
        Square square = new Square(4.0);
        assertTrue(rectangle.equals(square), "Rectangle and square with the same dimensions should be equal.");
    }

    @Test
    public void testRectangleSetNegativeLength()
    {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        assertThrows(IllegalArgumentException.class, () -> rectangle.setLength(-5.0), "Setting negative length should throw an exception.");
    }

    @Test
    public void testRectangleSetNegativeWidth()
    {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        assertThrows(IllegalArgumentException.class, () -> rectangle.setWidth(-3.0), "Setting negative width should throw an exception.");
    }

    @Test
    public void testRectangleLargeDimensions()
    {
        Rectangle rectangle = new Rectangle(1e6, 1e6);
        assertEquals(1e12, rectangle.calcArea(), 1e5, "Rectangle area incorrect for large dimensions.");
    }

    // Right Triangle Tests
    @Test
    public void testRightTriangleZeroBase()
    {
        RightTriangle triangle = new RightTriangle(0.0, 5.0);
        assertEquals(0.0, triangle.calcArea(), 1e-10, "Right triangle area should be zero for base 0.");
    }

    @Test
    public void testRightTriangleZeroHeight()
    {
        RightTriangle triangle = new RightTriangle(5.0, 0.0);
        assertEquals(0.0, triangle.calcArea(), 1e-10, "Right triangle area should be zero for height 0.");
    }

    @Test
    public void testRightTriangleHypotenuseCalculation()
    {
        RightTriangle triangle = new RightTriangle(3.0, 4.0);
        assertEquals(5.0, triangle.calcPerimeter() - 7.0, 1e-10, "Right triangle hypotenuse is not calculated correctly.");
    }

    @Test
    public void testRightTriangleSetBase()
    {
        RightTriangle triangle = new RightTriangle(3.0, 4.0);
        triangle.setBase(6.0);
        assertEquals(12.0, triangle.calcArea(), 1e-10, "Right triangle area not updated correctly after setting base.");
    }

    @Test
    public void testRightTriangleToStringFormat()
    {
        RightTriangle triangle = new RightTriangle(6.0, 8.0);
        assertTrue(triangle.toString().contains("RightTriangle with area=24.00000"), "Right triangle toString format is incorrect.");
    }

    @Test
    public void testRightTriangleNegativeBase()
    {
        assertThrows(IllegalArgumentException.class, () -> new RightTriangle(-3.0, 4.0), "Negative base should throw an exception.");
    }

    @Test
    public void testRightTriangleNegativeHeight()
    {
        assertThrows(IllegalArgumentException.class, () -> new RightTriangle(3.0, -4.0), "Negative height should throw an exception.");
    }

    @Test
    public void testRightTriangleHypotenusePrecision()
    {
        RightTriangle triangle = new RightTriangle(1e6, 1e6);
        double expectedHypotenuse = Math.sqrt(2) * 1e6;
        assertEquals(expectedHypotenuse, triangle.calcPerimeter() - 2 * 1e6, 1e3, "Hypotenuse calculation may lose precision.");
    }

    @Test
    public void testRightTriangleSetBaseNegative()
    {
        RightTriangle triangle = new RightTriangle(3.0, 4.0);
        assertThrows(IllegalArgumentException.class, () -> triangle.setBase(-3.0), "Setting negative base should throw an exception.");
    }

    @Test
    public void testRightTriangleSetHeightNegative()
    {
        RightTriangle triangle = new RightTriangle(3.0, 4.0);
        assertThrows(IllegalArgumentException.class, () -> triangle.setHeight(-4.0), "Setting negative height should throw an exception.");
    }

    @Test
    public void testSquareNegativeLength()
    {
        assertThrows(IllegalArgumentException.class, () -> new Square(-4.0), "Negative side length should throw an exception.");
    }

    // Square Tests
    @Test
    public void testSquareEqualityDifferentLengths()
    {
        Square square1 = new Square(4.0);
        Square square2 = new Square(5.0);
        assertFalse(square1.equals(square2), "Squares with different side lengths should not be equal.");
    }

    @Test
    public void testSquareSetNegativeLength()
    {
        Square square = new Square(5.0);
        assertThrows(IllegalArgumentException.class, () -> square.setLength(-5.0), "Setting negative side length should throw an exception.");
    }

    @Test
    public void testSquareSmallSideLength()
    {
        Square square = new Square(1e-10);
        assertEquals(Math.pow(1e-10, 2), square.calcArea(), 1e-20, "Square area incorrect for very small side length.");
    }

    @Test
    public void testSquarePerimeterPrecisionLoss()
    {
        Square square = new Square(1e9);
        assertEquals(4 * 1e9, square.calcPerimeter(), 1e3, "Square perimeter may lose precision for large side length.");
    }

    @Test
    public void testSquareZeroLength()
    {
        Square square = new Square(0.0);
        assertEquals(0.0, square.calcArea(), 1e-10, "Square area should be zero for length 0.");
    }

    @Test
    public void testSquareSetLength()
    {
        Square square = new Square(4.0);
        square.setLength(5.0);
        assertEquals(25.0, square.calcArea(), 1e-10, "Square area not updated correctly after setting length.");
    }

    @Test
    public void testSquarePerimeterAfterLengthUpdate()
    {
        Square square = new Square(4.0);
        square.setLength(7.0);
        assertEquals(28.0, square.calcPerimeter(), 1e-10, "Square perimeter not updated correctly after setting length.");
    }

    @Test
    public void testSquareToStringFormat()
    {
        Square square = new Square(4.0);
        assertTrue(square.toString().contains("Square with area=16.00000"), "Square toString format is incorrect.");
    }

    // Mixed Shape Tests
    @Test
    public void testCircleAndRectangleEquality()
    {
        Circle circle = new Circle(Math.sqrt(4.0 / Math.PI));
        Rectangle rectangle = new Rectangle(2.0, 2.0);
        assertTrue(circle.equals(rectangle), "Circle and rectangle with the same area should be equal.");
    }

    @Test
    public void testRectangleAndSquareEquality()
    {
        Rectangle rectangle = new Rectangle(4.0, 4.0);
        Square square = new Square(4.0);
        assertTrue(rectangle.equals(square), "Rectangle and square with the same area should be equal.");
    }

    @Test
    public void testRightTriangleAndRectangleInequality()
    {
        RightTriangle triangle = new RightTriangle(6.0, 8.0);
        Rectangle rectangle = new Rectangle(6.0, 8.0);
        assertFalse(triangle.equals(rectangle), "Triangle and rectangle should not be equal even if dimensions differ.");
    }

    @Test
    public void testSetAndGetMethodsConsistency()
    {
        Rectangle rectangle = new Rectangle(5.0, 7.0);
        rectangle.setLength(10.0);
        rectangle.setWidth(20.0);
        assertEquals(10.0, rectangle.getLength(), 1e-10, "Rectangle length getter is incorrect.");
        assertEquals(20.0, rectangle.getWidth(), 1e-10, "Rectangle width getter is incorrect.");
    }

    @Test
    public void testShapePerimeterConsistency()
    {
        Square square = new Square(4.0);
        Circle circle = new Circle(2.0);
        assertNotEquals(square.calcPerimeter(), circle.calcPerimeter(), "Square and circle perimeters should not match.");
    }

    @Test
    public void testShapeToStringIncludesName()
    {
        RightTriangle triangle = new RightTriangle(3.0, 4.0);
        assertTrue(triangle.toString().contains("RightTriangle"), "toString should include shape name.");
    }

    @Test
    public void testLargeDimensions()
    {
        Circle circle = new Circle(1e6);
        assertEquals(Math.PI * Math.pow(1e6, 2), circle.calcArea(), 1e-5, "Circle area incorrect for large radius.");
    }

    @Test
    public void testSmallDimensions()
    {
        Square square = new Square(1e-6);
        assertEquals(Math.pow(1e-6, 2), square.calcArea(), 1e-10, "Square area incorrect for small side length.");
    }

    @Test
    public void testZeroAreaEquality()
    {
        Circle circle = new Circle(0.0);
        Square square = new Square(0.0);
        assertTrue(circle.equals(square), "Shapes with zero area should be equal.");
    }

    // Equality and General Comparison Tests
    @Test
    public void testCircleAndSquareInequality()
    {
        Circle circle = new Circle(2.0);
        Square square = new Square(3.0);
        assertFalse(circle.equals(square), "Circle and square with different areas should not be equal.");
    }

    @Test
    public void testRectangleAndCircleEqualityWithSameArea()
    {
        Rectangle rectangle = new Rectangle(2.0, Math.PI);
        Circle circle = new Circle(1.0);
        assertTrue(rectangle.equals(circle), "Rectangle and circle with the same area should be equal.");
    }

    @Test
    public void testShapeInequalityWithDifferentPerimeters()
    {
        Square square = new Square(4.0);
        Circle circle = new Circle(4.0);
        assertNotEquals(square.calcPerimeter(), circle.calcPerimeter(), "Shapes with different perimeters should not be equal.");
    }

    @Test
    public void testShapeWithZeroDimensionsInequality()
    {
        Circle circle = new Circle(0.0);
        Rectangle rectangle = new Rectangle(0.0, 0.0);
        assertTrue(circle.equals(rectangle), "Shapes with zero area should still be equal.");
    }

    @Test
    public void testShapeToStringContent()
    {
        Circle circle = new Circle(5.0);
        assertTrue(circle.toString().contains("Circle"), "toString should include shape type.");
        assertTrue(circle.toString().contains("area"), "toString should include area.");
    }

    // Large Dimension Tests
    @Test
    public void testShapesWithExtremeDimensions()
    {
        Circle circle = new Circle(1e15);
        assertEquals(Math.PI * Math.pow(1e15, 2), circle.calcArea(), 1e10, "Circle area incorrect for extreme radius.");
    }

    @Test
    public void testSmallDimensionsWithPrecision()
    {
        Square square = new Square(1e-9);
        assertEquals(Math.pow(1e-9, 2), square.calcArea(), 1e-18, "Square area incorrect for very small side length.");
    }

    @Test
    public void testZeroAreaDifferentShapes()
    {
        Circle circle = new Circle(0.0);
        Square square = new Square(0.0);
        assertTrue(circle.equals(square), "Shapes with zero area should be equal regardless of type.");
    }

    @Test
    public void testSetLargeDimensions()
    {
        Rectangle rectangle = new Rectangle(1e5, 1e5);
        rectangle.setLength(1e6);
        rectangle.setWidth(1e6);
        assertEquals(1e12, rectangle.calcArea(), 1e5, "Rectangle area incorrect after setting large dimensions.");
    }

    @Test
    public void testSetSmallDimensions()
    {
        Square square = new Square(1e-5);
        square.setLength(1e-8);
        assertEquals(Math.pow(1e-8, 2), square.calcArea(), 1e-20, "Square area incorrect after setting small side length.");
    }

    @Test
    public void testShapeEqualsSymmetry()
    {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(5.0);
        assertTrue(circle1.equals(circle2) && circle2.equals(circle1), "Equality should be symmetric.");
    }

    @Test
    public void testShapeEqualsTransitivity()
    {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(5.0);
        Circle circle3 = new Circle(5.0);
        assertTrue(circle1.equals(circle2) && circle2.equals(circle3) && circle1.equals(circle3), "Equality should be transitive.");
    }

    @Test
    public void testShapeEqualsNull()
    {
        Circle circle = new Circle(5.0);
        assertFalse(circle.equals(null), "A shape should not be equal to null");
    }

    @Test
    public void testCircleSetRadiusNaN()
    {
        Circle circle = new Circle(5.0);
        assertThrows(IllegalArgumentException.class, () -> circle.setRadius(Double.NaN), "Setting radius to NaN should throw an exception.");
    }

    @Test
    public void testRectangleAreaWithInfinity()
    {
        Rectangle rectangle = new Rectangle(Double.POSITIVE_INFINITY, 5.0);
        assertThrows(IllegalArgumentException.class, rectangle::calcArea, "infinity should throw an exception");
    }

    @Test
    public void testCircleAndSquareExtremeDifference()
    {
        Circle circle = new Circle(1e100);
        Square square = new Square(1e-100);
        assertFalse(circle.equals(square), "Shapes with with different dimensions should not be equal.");
    }

    @Test
    public void testCircleLargePerimeter()
    {
        Circle circle = new Circle(1e7);
        assertEquals(2 * Math.PI * 1e7, circle.calcPerimeter(), 1e5, "Circle perimeter incorrect for large radius.");
    }

    @Test
    public void testCircleSmallArea()
    {
        Circle circle = new Circle(1e-5);
        assertEquals(Math.PI * Math.pow(1e-5, 2), circle.calcArea(), 1e-10, "Circle area incorrect for small radius.");
    }

    @Test
    public void testRightTriangleSetHeight()
    {
        RightTriangle triangle = new RightTriangle(3.0, 4.0);
        triangle.setHeight(5.0);
        assertEquals(7.5, triangle.calcArea(), 1e-10, "Right triangle area not updated correctly after setting height.");
    }

    @Test
    public void testRightTrianglePerimeterWithZeroHeight()
    {
        RightTriangle triangle = new RightTriangle(3.0, 0.0);
        assertEquals(3.0, triangle.calcPerimeter(), 1e-10, "Right triangle perimeter should equal base when height is zero.");
    }

    @Test
    public void testRightTriangleNegativeHeigt()
    {
        assertThrows(IllegalArgumentException.class, () -> new RightTriangle(3.0, -4.0), "Negative height should throw exception.");
    }

    @Test
    public void testRectangleZeroArea()
    {
        Rectangle rectangle = new Rectangle(0.0, 0.0);
        assertEquals(0.0, rectangle.calcArea(), 1e-10, "Rectangle area should be zero for zero dimensions.");
    }

    @Test
    public void testtRectangleSetNegativeLength()
    {
        Rectangle rectangle = new Rectangle(5.0, 6.0);
        assertThrows(IllegalArgumentException.class, () -> rectangle.setLength(-1.0), "Setting negative length should throw exception.");
    }

    @Test
    public void testtRectangleSetNegativeWidth()
    {
        Rectangle rectangle = new Rectangle(5.0, 6.0);
        assertThrows(IllegalArgumentException.class, () -> rectangle.setWidth(-1.0), "Setting negative width should throw exception.");
    }

    @Test
    public void testSquareZeroSide()
    {
        Square square = new Square(0.0);
        assertEquals(0.0, square.calcArea(), 1e-10, "Square area should be zero for side length 0.");
    }

    @Test
    public void testSquareSetNegativeSide()
    {
        Square square = new Square(4.0);
        assertThrows(IllegalArgumentException.class, () -> square.setLength(-5.0), "Setting negative side length should throw exception.");
    }

    @Test
    public void testSquareLargeSide()
    {
        Square square = new Square(1e6);
        assertEquals(1e12, square.calcArea(), 1e5, "Square area incorrect for large side length.");
    }

    @Test
    public void testShapeEqualityWithZeroArea()
    {
        Circle circle = new Circle(0.0);
        Rectangle rectangle = new Rectangle(0.0, 0.0);
        assertTrue(circle.equals(rectangle), "Shapes with zero area should be equal.");
    }

    @Test
    public void testRectangleAndSquareInequality()
    {
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Square square = new Square(4.0);
        assertFalse(rectangle.equals(square), "Rectangle and square with different areas should not be equal.");
    }

    @Test
    public void testCircleAndTriangleInequality()
    {
        Circle circle = new Circle(5.0);
        RightTriangle triangle = new RightTriangle(3.0, 4.0);
        assertFalse(circle.equals(triangle), "Circle and triangle with different areas should not be equal.");
    }

    @Test
    public void testShapeSetMethodsConsistency()
    {
        Rectangle rectangle = new Rectangle(5.0, 7.0);
        rectangle.setLength(10.0);
        rectangle.setWidth(20.0);
        assertEquals(10.0, rectangle.getLength(), 1e-10, "Rectangle length getter is incorrect.");
        assertEquals(20.0, rectangle.getWidth(), 1e-10, "Rectangle width getter is incorrect.");
    }


    @Test
    public void testCircleWithZeroRadius()
    {
        Circle circle = new Circle(0.0);
        assertEquals(0.0, circle.calcArea(), 1e-10, "Circle area should be zero for radius 0.");
        assertEquals(0.0, circle.calcPerimeter(), 1e-10, "Circle perimeter should be zero for radius 0.");
    }

    @Test
    public void testRectangleWithZeroDimensions()
    {
        Rectangle rectangle = new Rectangle(0.0, 0.0);
        assertEquals(0.0, rectangle.calcArea(), 1e-10, "Rectangle area should be zero for zero dimensions.");
        assertEquals(0.0, rectangle.calcPerimeter(), 1e-10, "Rectangle perimeter should be zero for zero dimensions.");
    }

    @Test
    public void testRightTriangleWithZeroBaseOrHeight()
    {
        RightTriangle triangle = new RightTriangle(0.0, 5.0);
        assertEquals(0.0, triangle.calcArea(), 1e-10, "Right triangle area should be zero for base 0.");
        triangle = new RightTriangle(5.0, 0.0);
        assertEquals(0.0, triangle.calcArea(), 1e-10, "Right triangle area should be zero for height 0.");
    }







}
