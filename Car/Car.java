
/**
 * Calc car info
 */
public class Car
{
    // Set variables
    private double _milesPerGallon;
    private double _fuelTankCapacity;
    private double _fuelInTank;
    private double _odometer;

    /**
     * Set variables
     */
    public Car(double milesPerGallon, double fuelTankCapacity, double odometer)
    {
        _milesPerGallon = milesPerGallon;
        _fuelTankCapacity = fuelTankCapacity;
        _fuelInTank = fuelTankCapacity;
        _odometer = odometer;
    }

    /**
     * Not completely sure?
     */
    public Car(double milesPerGallon, double fuelTankCapacity)
    {
        _milesPerGallon = milesPerGallon;
        _fuelTankCapacity = fuelTankCapacity;
        _fuelInTank = fuelTankCapacity;
        _odometer = 0;
    }

    /**
     * Get MPG
     */
    public double getMilesPerGallon()
    {
        return _milesPerGallon;
    }

    /**
     * Get Fuel tank capacity
     */
    public double getFuelTankCapacity()
    {
        return _fuelTankCapacity;
    }

    /**
     * Get fuel in tank
     */
    public double getFuelInTank()
    {
        return _fuelInTank;
    }

    /**
     * Get odometer reading
     */
    public double getOdometer()
    {
        return _odometer;
    }

    /**
     * Get gas to add
     */
    public void addGas(double gallons)
    {
        _fuelInTank = Math.min(_fuelInTank + gallons, _fuelTankCapacity);
    }

    /**
     * Get gas amount to fill tank
     */
    public void fillUp()
    {
        _fuelInTank = _fuelTankCapacity;
    }

    /**
     * Get miles you can drive
     */
    public boolean drive(double miles)
    {
        double maxDistance = _fuelInTank * _milesPerGallon;
        boolean success = false;
        if (maxDistance >= miles)
        {
            _odometer += miles;
            _fuelInTank -= miles / _milesPerGallon;
            success = true;
        }
        return success;
    }

    /**
     * Print results
     */
    public String toString()
    {
        return "Car" +
                "Miles Per Gallon = " + _milesPerGallon +
                ", Fuel Tank Capacity = " + _fuelTankCapacity +
                ", Fuel In Tank = " + _fuelInTank +
                ", Odometer = " + _odometer;
    }
}
