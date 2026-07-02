//TIP To <b>Run</b> code, press <shortcut actionId=Run/> or
// click the <icon src=AllIcons.Actions.Execute/> icon in the gutter.
/**
 * Class to get inventory
 */
public class InventoryLineItem implements Comparable <InventoryLineItem>
{
    // Declare variables
    private static long _lineItemCount = 0;
    private long _lineItemNumber;
    private Product _product;
    private int _quantity;

    /**
     * Create variables
     */
    public InventoryLineItem(Product product, int quantity)
    {
        _lineItemCount++;
        _lineItemNumber = _lineItemCount;
        _product = product;
        _quantity = quantity;
    }

    /**
     * Set product to zero
     */
    public InventoryLineItem(Product product)
    {
        this(product, 0);
    }

    /**
     * Return line item number
     */
    public long getLineItemNumber()
    {
        return _lineItemNumber;
    }

    /**
     * return product
     */
    public Product getProduct()
    {
        return _product;
    }

    /**
     * Return quantity
     */
    public int getQuantity()
    {
        return _quantity;
    }

    /**
     * Calculate discount rate
     */
    public double calcDiscountRate()
    {
        double discount;

        // If else to calc discount
        if (_quantity >= 50)
        {
            discount = 0.25;
        }
        else if (_quantity >= 25)
        {
            discount = 0.20;
        }
        else if (_quantity >= 10)
        {
            discount = 0.10;
        }
        else
        {
            discount = 0.0;
        }

        return discount;
    }

    /**
     * Calculate subtotal
     */
    public double calcSubtotal()
    {
        double discount = _product.getPrice() * calcDiscountRate();
        return (_product.getPrice() - discount) * _quantity;
    }

    /**
     * Compare subtotals
     */
    public int compareTo(InventoryLineItem other)
    {
        return Double.compare(this.calcSubtotal(), other.calcSubtotal());
    }

    /**
     * Adjusting Quality
     */
    public void adjustQuantity(int adjustment)
    {
        // If else for adjusting quantity
        if(_quantity > 0)
        {
            _quantity += adjustment;
        }
        else if(_quantity < 0)
        {
            _quantity -= adjustment;
        }
        else
        {
            _quantity += adjustment;
        }
    }

    /**
     * Print results of inventory line item
     */
    public String toString()
    {
        return "Line Item Number: " + _lineItemNumber +
                ", Product: " +_product.toString() +
                ", Quantity: " + _quantity;
    }
}