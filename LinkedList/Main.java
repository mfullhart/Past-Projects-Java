import java.util.Iterator;

public class Main
{
    public static void main(String[] args) {
        // Create a new LinkedList of Integers
        LinkedList<Integer> list = new LinkedList<>();

        // Test adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After adding 10, 20, 30:");
        printList(list);

        // Test getting elements
        System.out.println("Element at index 1: " + list.get(1)); // Should print 20

        // Test removing an element
        System.out.println("Removing element at index 1 (20): " + list.remove(1));
        System.out.println("After removing element at index 1:");
        printList(list);

        // Test adding at a specific index
        list.add(1, 25); // Adding 25 at index 1
        System.out.println("After adding 25 at index 1:");
        printList(list);

        // Test size of the list
        System.out.println("Size of the list: " + list.size()); // Should print 3

        // Test isEmpty
        System.out.println("Is the list empty? " + list.isEmpty()); // Should print false

        // Test forward iteration
        System.out.println("Forward iteration:");
        for (Integer value : list) {
            System.out.println(value);
        }

//        // Test reverse iteration
        System.out.println("Reverse iteration:");
        Iterator<Integer> reverseIterator = list.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
    }

    /**
     * Helper method to print all elements in the list.
     */
    public static void printList(LinkedList<?> list) {
        System.out.print("List: ");
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
