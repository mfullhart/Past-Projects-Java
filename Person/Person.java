/**
 * Class to collect Peoples information
 */
public class Person
{
    // Declare variables
    private String _name;
    private String _phone;
    private String _email;


    /**
     * Create variable
     */
    public Person(String name, String phone, String email)
    {
        _name = name;
        _phone = phone;
        _email = email;
    }

    /**
     * Return name
     */
    public String getName()
    {
        return _name;
    }

    /**
     * Return phone
     */
    public String getPhone()
    {
        return _phone;
    }

    /**
     * Return email
     */
    public String getEmail()
    {
        return _email;
    }

    /**
     * Set new name
     */
    public void setName(String newName)
    {
        _name = newName;
    }

    /**
     * Set new phone
     */
    public void setPhone(String newPhone)
    {
        _phone = newPhone;
    }

    /**
     * Set new email
     */
    public void setEmail(String newEmail)
    {
        _email = newEmail;
    }

    /**
     * Print results
     */
    public String toString()
    {
        return ("Person's name: " + _name
                + ", phone: " + _phone
                + ", email: " + _email);
    }
}
