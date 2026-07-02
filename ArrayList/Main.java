public class Main
{
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> myList = new ArrayList<>();




        // Add elements to the list
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        System.out.println("List after adding elements: " + displayList(myList));




        // Insert an element at a specific index
        myList.add(1, "Blueberry");
        System.out.println("List after inserting Blueberry at index 1: " + displayList(myList));




        // Get the element at index 2
        String fruit = myList.get(2);
        System.out.println("Element at index 2: " + fruit);




        // Remove the element at index 0
        String removedFruit = myList.remove(0);
        System.out.println("Removed element: " + removedFruit);
        System.out.println("List after removing the element at index 0: " + displayList(myList));




        // Check if the list is empty
        boolean isEmpty = myList.isEmpty();
        System.out.println("Is the list empty? " + isEmpty);




        // Get the size of the list
        int size = myList.size();
        System.out.println("Size of the list: " + size);




        // Find the index of a specific element
        int index = myList.indexOf("Cherry");
        System.out.println("Index of Cherry: " + index);




        // Set a new value at index 1
        myList.set(1, "Strawberry");
        System.out.println("List after setting Strawberry at index 1: " + displayList(myList));




        // Clear the list
        myList.clear();
        System.out.println("List after clearing: " + displayList(myList));
    }




    // Utility method to display the list elements
    private static String displayList(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
