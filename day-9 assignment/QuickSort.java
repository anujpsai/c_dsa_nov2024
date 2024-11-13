public class QuickSort {

    // Method to perform the Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partitioning index
            int pi = partition(arr, low, high);
            
            // Recursively sort the two sub-arrays
            quickSort(arr, low, pi - 1);  // Left sub-array
            quickSort(arr, pi + 1, high); // Right sub-array
        }
    }

    // Partition method that selects a pivot and arranges elements around it
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = (low - 1); // Index for the smaller element
        
        // Traverse through all elements of the array
        for (int j = low; j <= high - 1; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++; // Increment the smaller element index
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i + 1] and arr[high] (pivot element)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return (i + 1); // Return the partition index
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the quick sort
    public static void main(String[] args) {
        int[] arr = {90 ,80, 10, 50, 40, 70};
        
        System.out.println("Original array:");
        printArray(arr);
        
        quickSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
}