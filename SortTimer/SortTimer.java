import java.util.Arrays;
import java.util.Random;

/**
 * A utility class to evaluate the run-time performance of sort algorithms
 *
 * @author bsnider@georgefox.edu
 */
public class SortTimer
{
    // TODO experiment with larger stopping points, step sizes
    private static final int STEP = 100000;
    private static final int START = STEP;
    private static final int STOP = 1000000;


    /**
     * Main entry point to run the sort algorithms
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        // random number generator
        Random rng = new Random();

        // holds the randomly-generated values of length n
        int[] values;

        // run time of each sort algorithm, in milliseconds
        long bubbleTime;
        long selectionTime;
        long insertionTime;
        long quickTime;
        long javaTime;

        // print header row
        System.out.format("n, Bubble Sort, Selection Sort, Insertion Sort, Quick Sort, Arrays.sort()%n");

        // start at START, increase by STEP, stop at STOP
        for (int n = START; n < STOP + 1; n += STEP)
        {
            // generate a length-n array of random int values
            values = rng.ints(n, 0, 1000000).toArray();

            // run each sort algorithm on a copy of the random values
            bubbleTime = bubbleSort(Arrays.copyOf(values, n));
            selectionTime = selectionSort(Arrays.copyOf(values, n));
            insertionTime = insertionSort(Arrays.copyOf(values, n));
            quickTime = quickSort(Arrays.copyOf(values, n));
            javaTime = javaSort(Arrays.copyOf(values, n));

            // print a row of times for current n
            System.out.format("%d, %d, %d, %d, %d, %d%n",
                n, bubbleTime, selectionTime, insertionTime, quickTime, javaTime
            );
        }
    }


    /**
     * Sorts an array of int values in-place using the bubble sort algorithm
     *
     * @param a The unsorted array to sort
     * @return The run time in milliseconds
     */
    private static long bubbleSort(int[] a)
    {
        long startTime = System.currentTimeMillis();

        int n = a.length;

        // for each position in the array starting from the far end,
        for (int i = n - 1; i >= 0; i--)
        {
            // working from the start to position i,
            for (int j = 0; j < i; j++)
            {
                // bubble largest element to the right
                if (a[j] > a[j + 1])
                {
                    _swap(a, j, j + 1);
                }
            }
        }

        return System.currentTimeMillis() - startTime;
    }


    /**
     * Sorts an array of int values in-place using the selection sort algorithm
     *
     * @param a The unsorted array to sort
     * @return The run time in milliseconds
     */
    private static long selectionSort(int[] a)
    {
        long startTime = System.currentTimeMillis();

        int n = a.length;
        int argmin;

        // for each position in the array,
        for (int i = 0; i < n - 1; i++)
        {
            // for each element in the remainder of the array,
            argmin = 0;
            for (int j = i + 1; j < n; j++)
            {
                // find the position of the smallest element in the remainder
                if (a[j] < a[argmin])
                {
                    argmin = j;
                }
            }
            // "select" the found smallest element for this position by swapping it in
            _swap(a, i, argmin);
        }

        return System.currentTimeMillis() - startTime;
    }


    /**
     * Sorts an array of int values in-place using the insertion sort algorithm
     *
     * @param a The unsorted array to sort
     * @return The run time in milliseconds
     */
    private static long insertionSort(int[] a)
    {
        long startTime = System.currentTimeMillis();

        int n = a.length;
        int temp;
        int j;

        // starting with a list of length 1 (i.e., a[0]),
        // for each element from position 1 to the end,
        for (int i = 1; i < n; i++)
        {
            temp = a[i];
            j = i - 1;
            // while the current element is larger,
            while (j > -1 && a[j] > temp)
            {
                // shift values to the right to make room for current element
                a[j + 1] = a[j];
                j--;
            }
            // finally, place current element in sorted position
            a[j + 1] = temp;
            // array a is partially sorted from index 0 to index i
        }

        return System.currentTimeMillis() - startTime;
    }


    /**
     * Sorts an array of int values in-place using the quick sort algorithm
     *
     * @param a The unsorted array to sort
     * @return The run time in milliseconds
     */
    private static long quickSort(int[] a)
    {
        long startTime = System.currentTimeMillis();

        int n = a.length;

        // kick off the recursive quick sort over the entire array
        _quicksort(a, 0, n - 1);

        return System.currentTimeMillis() - startTime;
    }


    /**
     * Sorts a portion (from lo to hi indices) of an array of int values in-place
     *
     * @param a The unsorted array to sort
     * @param lo The index of the left boundary for the current recursive call
     * @param hi The index of the right boundary for the current recursive call
     */
    private static void _quicksort(int[] a, int lo, int hi)
    {
        int i = lo;
        int j = hi;
        // set the pivot to the midpoint between lo and hi
        int pivot = a[lo + (hi - lo) / 2];

        // partition from index lo to index hi,
        // ensuring values < pivot are on the left and values > pivot are on the right
        while (i <= j)
        {
            // while values left of pivot are smaller,
            while (a[i] < pivot)
            {
                // walk i to the right
                i++;
            }
            // stop walking i when larger value found

            // while values right of pivot are larger,
            while (a[j] > pivot)
            {
                // walk j to the left
                j--;
            }
            // stop walking j when smaller value found

            // if position i is to the left of position j,
            if (i <= j) {
                // swap larger value from left with smaller value from right
                _swap(a, i, j);
                // continue walking i to right and j to left
                i++;
                j--;
            }
        }

        // recursively call quick sort on lo/hi portions
        if (lo < j)
        {
            _quicksort(a, lo, j);
        }
        if (i < hi)
        {
            _quicksort(a, i, hi);
        }
        // array a is partially sorted from index lo to index hi
    }


    /**
     * Sorts an array of int values in-place using Java's Arrays.sort() method
     *
     * @param a The unsorted array to sort
     * @return The run time in milliseconds
     */
    private static long javaSort(int[] a)
    {
        long startTime = System.currentTimeMillis();

        Arrays.sort(a);

        return System.currentTimeMillis() - startTime;
    }


    /**
     * Swaps two elements in an array, given by indices i and j
     *
     * @param a The array containing the elements to swap
     * @param i The index of the first element to swap
     * @param j The index of the second element to swap
     */
    private static void _swap(int a[], int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
