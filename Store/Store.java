import java.io.*;
import java.util.*;

/**
 * Class For Store
 */
public class Store
{
    private Inventory _inventory;

    /**
     * setting variable for store
     */
    public Store()
    {
        _inventory = new Inventory();
    }

    /**
     * Load store
     */
    public void loadStore(String filename)
    {
        String line;
        String[] items;
        File file;
        Scanner input;
        Book book;
        FlashDrive flash;
        WaterBottle water;

        // Access files
        try
        {
            file = new File(filename);
            input = new Scanner(file);

            while(input.hasNext())
            {
                line = input.nextLine();
                items = line.split(",");

                // code for book
                if(items[0].charAt(0) == 'B')
                {
                    book = new Book(items[0], items[1], Double.parseDouble(items[2]),
                            items[3], items[4]);


                    _inventory.restock(book, Integer.parseInt(items[5]));
                }

                // code for flash drive
                else if(items[0].charAt(0) == 'F')
                {
                    flash = new FlashDrive(items[0], items[1],
                            Double.parseDouble(items[2]), Integer.parseInt(items[3]));


                    _inventory.restock(flash, Integer.parseInt(items[4]));
                }

                // code for water bottle
                else if(items[0].charAt(0) == 'W')
                {
                    water = new WaterBottle(items[0], items[1],
                            Double.parseDouble(items[2]), Integer.parseInt(items[3]));


                    _inventory.restock(water, Integer.parseInt(items[4]));
                }
            }
            input.close();
        }
        catch (IOException e)
        {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Process Returns
     */
    public String processReturn(String item)
    {
        Book book;
        FlashDrive flash;
        WaterBottle water;

        String[] items = item.split(",");

        // code for book
        if(items[0].charAt(0) == 'B')
        {
            book = new Book(items[0], items[1], Double.parseDouble(items[2]),
                    items[3], items[4]);

            _inventory.restock(book, Integer.parseInt(items[5]));
        }

        // code for flash drive
        else if(items[0].charAt(0) == 'F')
        {
            flash = new FlashDrive(items[0], items[1],
                    Double.parseDouble(items[2]), Integer.parseInt(items[3]));

            _inventory.restock(flash, Integer.parseInt(items[4]));
        }

        // code for water bottle
        else if(items[0].charAt(0) == 'W')
        {
            water = new WaterBottle(items[0], items[1],
                    Double.parseDouble(items[2]), Integer.parseInt(items[3]));

            _inventory.restock(water, Integer.parseInt(items[4]));
        }
        return  "RETURNED";
    }

    /**
     * Process orders
     */
    public String processOrder(String order)
    {
        // variables for processOrder
        String[] parts = order.split(",");
        String resultMessage = "";
        String productID;
        int quantityRequested;
        InventoryLineItem item;
        int quantityOnHand;

        // Check if the order format is valid
        if (parts.length != 2)
        {
            resultMessage = "INVALID ORDER FORMAT";
        }
        else
        {
            productID = parts[0];
            quantityRequested = Integer.parseInt(parts[1]);

            // Find the item in the inventory
            item = _inventory.findItemByID(productID);

            if (item == null || item.getQuantity() == 0)
            {
                resultMessage = "OUT OF STOCK";
            }
            else
            {
                quantityOnHand = item.getQuantity();

                if (quantityOnHand < quantityRequested)
                {
                    resultMessage = String.format("INSUFFICIENT %d OF %d", quantityOnHand, quantityRequested);
                }
                else
                {
                    _inventory.pick(productID, quantityRequested);
                    resultMessage = String.format("PROCESSED %d", quantityRequested);
                }
            }
        }
        return resultMessage;
    }

    /**
     * Find product types
     */
    public Product[] findProductsOfType(String productType)
    {

        ArrayList<Product> products = new ArrayList<>();

        // returning array for product found in inventory
        for (InventoryLineItem item : _inventory.findItemsOfType(productType))
        {
            products.add(item.getProduct());
        }
        return products.toArray(new Product[0]);
    }

    /**
     * Save inventory info to specified filename
     */
    public void saveStore(String filename)
    {
        try (PrintWriter writer = new PrintWriter(filename))
        {
            for (InventoryLineItem item : _inventory.getLineItems())
            {
                writer.println(item.getProduct());
            }
        }
        catch (IOException e)
        {
            System.err.println("Error saving store: " + e.getMessage());
        }
    }

    /**
     * Processes an array of transactions
     */
    public String[] processTransactions(Transaction[] transactions)
    {
        String[] results = new String[transactions.length];
        for (int i = 0; i < transactions.length; i++)
        {
            Transaction transaction = transactions[i];
            if (transaction.isReturn()) {
                results[i] = processReturn(transaction.getTransaction());
            } else {
                results[i] = processOrder(transaction.getTransaction());
            }
        }
        return results;
    }
}
