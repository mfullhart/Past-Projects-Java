import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for transactions
 */
public class Transaction
{
    // Declare variables
    private String _transaction;
    private boolean _isReturn;

    /**
     * Create transaction
     */
    public Transaction(String transaction)
    {
        _transaction = transaction;
        // Determine if the transaction is a return based on the format (more than two parts when splitting on commas)
        _isReturn = transaction.split(",").length > 2;
    }

    /**
     * Returns transaction
     */
    public String getTransaction()
    {
        return _transaction;
    }

    /**
     * Return transaction true or false
     */
    public boolean isReturn()
    {
        return _isReturn;
    }

    /**
     * Reads transactions and returns array of Transaction objects
     */
    public static Transaction[] loadTransactions(String filename)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            // Count the number of lines in the file to determine the size of the array
            long count = reader.lines().count();
            Transaction[] transactions = new Transaction[(int) count];

            // Create a new reader to read from the beginning of the file
            BufferedReader newReader = new BufferedReader(new FileReader(filename));

            // Read each line and create a Transaction object
            String line;
            int index = 0;
            while ((line = newReader.readLine()) != null)
            {
                transactions[index] = new Transaction(line);
                index++;
            }

            // Close the new reader
            newReader.close();

            return transactions;
        }
        catch (IOException e)
        {
            // Handle IO exceptions
            System.err.println("Error reading transactions from file: " + e.getMessage());
            // Return an empty array in case of error
            return new Transaction[0];
        }
    }
}
