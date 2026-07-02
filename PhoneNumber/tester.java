public class tester
{
    public static void main(String[] args)
    {
        try
        {
            // Valid phone number
            PhoneNumber p1 = PhoneNumber.parsePhoneNumber("555-555-1234");
            PhoneNumber p2 = PhoneNumber.parsePhoneNumber("555-555-1234");
            PhoneNumber p3 = PhoneNumber.parsePhoneNumber("555-555-1234");
            System.out.println("Parsed phone number: " + p1);
            System.out.println("Parsed phone number: " + p2);
            System.out.println("Parsed phone number: " + p3);

            // Testing getDigits method
            System.out.println("Digits only: " + p1.getDigits());

            // Comparison
            PhoneNumber ppn2 = PhoneNumber.parsePhoneNumber("555-444-1234");
            System.out.println("Comparison result: " + p1.compareTo(p2)); // Positive result, since p1 > p2

        }

        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}