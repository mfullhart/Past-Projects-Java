/**
 * Class to collect Students information
 */
public class Student extends Person
{
    // Declare variables
    private String _major;
    private double _gpa;


    /**
     * Create variable
     */
    public Student(String name, String phone, String email, String major, double gpa)
    {
        super(name, phone, email);
        _major = major;
        _gpa = gpa;
    }

    /**
     * Return major
     */
    public String getMajor()
    {
        return _major;
    }

    /**
     * Return gpa
     */
    public double getGPA()
    {
        return _gpa;
    }

    /**
     * Set new major
     */
    public void setMajor(String newMajor)
    {
        _major = newMajor;
    }

    /**
     * Set new gpa
     */
    public void setGPA(double newGPA)
    {
        _gpa = newGPA;
    }

    /**
     * Print results
     */
    @Override
    public String toString()
    {
        return ("Student's name: " + getName()
                + ", phone: " + getPhone()
                + ", email: " + getEmail()
                + ", major: " + getMajor()
                + ", GPA: " + getGPA());
    }
}
