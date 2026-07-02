/**
 * Class to collect Employees information
 */
public class Employee extends Person
{
    // Declare variables
    private String _employeeID;


    /**
     * Create variable
     */
    public Employee(String name, String phone, String email, String employeeID)
    {
        super(name, phone, email);
        _employeeID = employeeID;
    }

    /**
     * Return employee ID
     */
    public String getEmployeeID()
    {
        return _employeeID;
    }

    /**
     * Set new employee ID
     */
    public void setEmployeeID(String newEmployeeID)
    {
        _employeeID = newEmployeeID;
    }

    /**
     * Print results
     */
    @Override
    public String toString()
    {
        return " Employee's name: " + getName()
                + ", phone: " + getPhone()
                + ", email: " + getEmail()
                + ", employee ID: " + getEmployeeID();
    }
}
