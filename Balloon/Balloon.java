public class Balloon {
    private double _radius;

    public Balloon(double initialRadius) {
        _radius = initialRadius;
    }

    public Balloon() {
        _radius = 1.0;
    }

    public double getRadius() {
        return _radius;
    }

    public double calcSurfaceArea() {
        return 4 * Math.PI * Math.pow(_radius, 2);
    }

    public double calcVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(_radius, 3);
    }

    public void inflate(double cubicUnits) {
        double additionalVolume = Math.max(0, cubicUnits);
        double newVolume = calcVolume() + additionalVolume;
        _radius = Math.cbrt((3.0 * newVolume) / (4.0 * Math.PI));
    }

    public void deflate(double cubicUnits) {
        double removedVolume = Math.max(0, cubicUnits);
        double newVolume = Math.max(0, calcVolume() - removedVolume);
        _radius = Math.cbrt((3.0 * newVolume) / (4.0 * Math.PI));
    }

    public String toString() {
        return "Balloon{" +
                "_radius=" + _radius +
                '}';
    }
}
