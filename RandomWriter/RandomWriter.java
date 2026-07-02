import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * A functioning hash map based procedural text generator.
 *
 * @author mfullhart20@georgefox.edu
 */
public class RandomWriter
{
    public static void main(String[] args)
    {
        // Error codes
        final int INSUFFICIENT_ARGS = 1;
        final int INVALID_ARGS = 1;
        final int FILE_ERROR = 2;

        // Require at least 3 args
        if (args.length < 3)
        {
            System.err.println("Need at least 3 arguments");
            System.exit(INSUFFICIENT_ARGS);
        }

        // Parse prefix length argument
        int _prefixLength = -1;
        try
        {
            _prefixLength = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e)
        {
            System.err.println("Prefix length must be an integer");
            System.exit(INVALID_ARGS);
        }

        // Validate prefix length
        if (_prefixLength < 1)
        {
            System.err.println("Prefix length must be at least 1");
            System.exit(INVALID_ARGS);
        }

        // Parse output length argument
        int _outputLength = -1;

        try
        {
            _outputLength = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e)
        {
            System.err.println("Output length must be an integer");
            System.exit(INVALID_ARGS);
        }

        // Validate output length
        if (_outputLength < 1)
        {
            System.err.println("Output length must be at least 1");
            System.exit(INVALID_ARGS);
        }

        // Create a HashMap to store the language model
        HashMap<String, ArrayList<Character>> map = new HashMap<>();

        // Read files and build the language model
        for (int i = 2; i < args.length; i++)
        {
            Scanner scanner = null;
            String filename = args[i];

            try
            {
                scanner = new Scanner(new File(filename)); // Open the file using Scanner
            }
            catch (FileNotFoundException e)
            {
                System.err.println("File not found: " + filename);
                System.exit(FILE_ERROR); // Exit if the file does not exist
            }

            StringBuilder content = new StringBuilder();

            // Read the entire file using Scanner
            while (scanner.hasNextLine())
            {
                content.append(scanner.nextLine()).append("\n");
            }

            // Build the language model from file contents
            String text = content.toString();

            for (int j = 0; j <= text.length() - _prefixLength - 1; j++)
            {
                String prefix = text.substring(j, j + _prefixLength);
                char nextChar = text.charAt(j + _prefixLength);

                // Add next character to the map for the given prefix
                map.computeIfAbsent(prefix, k -> new ArrayList<>()).add(nextChar);
            }
        }

        // Ensure the map is not empty
        if (map.isEmpty())
        {
            System.err.println("Insufficient input data to generate text");
            System.exit(FILE_ERROR);
        }

        // Generate the random text
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        // Pick a random prefix to begin with
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        String prefix = keys.get(random.nextInt(keys.size()));
        result.append(prefix);

        // Generate the rest of the text
        for (int i = _prefixLength; i < _outputLength; i++)
        {
            ArrayList<Character> followingChars = map.get(prefix);

            // Stop if no following characters are available
            if (followingChars == null || followingChars.isEmpty())
            {
                break;
            }

            // Pick a random character from the list of followers
            char nextChar = followingChars.get(random.nextInt(followingChars.size()));
            result.append(nextChar);

            // Update the prefix for the next iteration
            prefix = prefix.substring(1) + nextChar;
        }

        // Print the generated text
        System.out.println(result);
    }
}