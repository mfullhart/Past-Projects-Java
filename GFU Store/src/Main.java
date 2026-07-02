import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<InventoryLineItem> items = new ArrayList<>();
        items.add(new InventoryLineItem(new FlashDrive("FD_005", "SanDisk Cruzer", 8.99, 16), 10));
        items.add(new InventoryLineItem(new Book("BK_202", "Big Java: Early Objects", 99.99, "Cay S. Horstmann", "Wiley"), 70));
        items.add(new InventoryLineItem(new WaterBottle("WB_001", "HydroFlask w/Sport Lid, Navy Blue", 49.99, 40), 5));

        for (InventoryLineItem item: items)
        {
            System.out.println(item);
        }

    }
}
