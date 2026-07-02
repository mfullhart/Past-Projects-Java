import java.util.ArrayList;
import java.util.Collections;
/**
 * A phone number sorting class.
 *
 * @author mfullhart20@georgefox.edu
 */
public class PhoneNumberSorter
{
    private static final int NO_ARGS = 1;
    private static final int INVALID_ARGS = 2;

    /**
     * Sorts the phone numbers in numerical order.
     *
     * @param args Arguments.
     */
    public static void main(String[] args)
    {
        // Print out the number of arguments
        // System.out.format("Number of args: %d%n",args.length);

        // validate number of args provided, so exit with status code of 1
        if (args.length == 0)
        {
            // no args provided
            System.exit(NO_ARGS);
        }

        // Create an empty list to store valid PhoneNumber objects
        ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();


        // loop over args array and TRY to parse a valid phone number from the arg string
        for (String arg : args)
        {
            try
            {
                // Try to parse a valid phone number and add it to the list
                PhoneNumber phoneNumber = PhoneNumber.parsePhoneNumber(arg);
                phoneNumbers.add(phoneNumber);
            }

            catch (IllegalArgumentException e)
            {
                // If an invalid phone number is found, print an error and exit with status code 2
                System.out.println("Invalid phone number: " + arg);
                System.exit(INVALID_ARGS);
            }
        }

        Collections.sort(phoneNumbers);

        // Print out the sorted phone numbers, one per line
        for (PhoneNumber phoneNumber : phoneNumbers)
        {
            System.out.println(phoneNumber);
        }

        // if we made it this far without any issues, exit 0
        System.exit(0);
    }
}