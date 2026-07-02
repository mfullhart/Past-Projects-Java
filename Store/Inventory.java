import java.util.ArrayList;

/**
 * Class for inventory of the products
 */
public class Inventory
{
    private ArrayList<InventoryLineItem> _lineItems;

    /**
     * Set variable for Inventory
     */
    public Inventory()
    {
        _lineItems = new ArrayList<>();
    }

    /**
     * Return inventory line items
     */
    public ArrayList<InventoryLineItem> getLineItems()
    {
        return _lineItems;
    }

    /**
     * Inventory line to finding items by id
     */
    public InventoryLineItem findItemByID(String productID)
    {

        // if nothing returns null
        InventoryLineItem foundItem = null;


        //returning inventory line
        for (InventoryLineItem item : _lineItems)
        {
            if (item.getProduct().getID().equals(productID))
            {
                foundItem = item;
            }
        }
        return foundItem;
    }

    /**
     * Create array for inventory
     */
    public InventoryLineItem[] findItemsOfType(String productType)
    {
        ArrayList<InventoryLineItem> items = new ArrayList<>();

        // Iterate over each inventory line item
        for (InventoryLineItem item : _lineItems)
        {
            // Check if the product ID starts with the specified productType
            if (productType.isEmpty() || item.getProduct().getID().startsWith(productType))
            {
                // Add the matching inventory line item to the list
                items.add(item);
            }
        }

        // Convert the ArrayList to an array and return it
        return items.toArray(new InventoryLineItem[0]);
    }

    /**
     * Getting quantity by id
     */
    public int getQuantityByID(String productID)
    {
        InventoryLineItem item = findItemByID(productID);

        int result = 0;

        // return the quantity in stock
        if (item != null)
        {
            result = item.getQuantity();
        }

        return result;
    }

    /**
     * Restock function
     */
    public int restock(Product product, int quantity)
    {
        int result;

        InventoryLineItem item = findItemByID(product.getID());
        // put the product back into inventory
        if (item != null)
        {
            item.adjustQuantity(quantity);
            result = item.getQuantity();
        }
        // Adjust inventory
        else
        {
            _lineItems.add(new InventoryLineItem(product, quantity));
            result = quantity;
        }
        return result;
    }

    /**
     * Decide Function
     */
    public int pick(String productID, int quantity)
    {
        InventoryLineItem item = findItemByID(productID);

        // Default return value
        int result = -1;

        // If item found in inventory
        if (item != null && item.getQuantity() > 0)
        {
            if (item.getQuantity() >= quantity)
            {
                item.adjustQuantity(-quantity);
                result = 0;

            }
            else
            {
                // Return available quantity if requested quantity exceeds availability
                result = item.getQuantity();
            }
        }
        return result;
    }

    /**
     * Calculate inventory value
     */
    public double calcInventoryValue()
    {
        double totalValue = 0.0;


        // returning entire inventory value
        for (InventoryLineItem item : _lineItems)
        {
            totalValue += item.calcSubtotal();
        }
        return totalValue;
    }
}
