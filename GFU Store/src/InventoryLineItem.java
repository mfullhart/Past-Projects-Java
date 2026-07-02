//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class InventoryLineItem implements Comparable <InventoryLineItem>
{
   private long _lineItemCount = 0;
   private long _lineItemNumber;
   private Product _product;
   private int _quantity;

   public InventoryLineItem(Product product, int quantity)
   {
      _lineItemCount++;
      _lineItemNumber = _lineItemCount;
      _product = product;
      _quantity = quantity;
   }

   public InventoryLineItem(Product product)
   {
      this(product, 0);
   }

   public long getItemNumber()
   {
      return _lineItemNumber;
   }

   public Product getProduct()
   {
      return _product;
   }

   public int getQuantity()
   {
      return _quantity;
   }

   public double calcDiscountRate()
   {
      if (_quantity >= 50)
         return 0.25;
      else if (_quantity >= 25)
         return 0.20;
      else if (_quantity >= 10)
         return 0.10;
      else return 0.0;
   }

   public double calcSubtotal()
   {
      double discount = _product.getPrice() * calcDiscountRate();
      return (_product.getPrice() - discount) * _quantity;
   }

   @Override
   public int compareTo(InventoryLineItem other)
   {
      return Double.compare(this.calcSubtotal(), other.calcSubtotal());
   }

   @Override
   public String toString()
   {
      return "Line Item Number: " + _lineItemNumber +
              ", Product: " +_product.getDescription() +
              ", Quantity: " + _quantity +
              ", Subtotal: " + calcSubtotal();
   }
}