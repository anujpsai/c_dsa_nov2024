public class InsertionSort {

    // Method to perform insertion sort on an array
    public static void insertionSort(int[] arr) {
        // Loop through the array starting from the second element (index 1)
        for (int i = 1; i < arr.length; i++) {
            // 'key' is the element to be inserted into the sorted portion of the array
            int key = arr[i];
            
            // 'j' will be used to find the correct position for the 'key'
            int j = i - 1;

            // Shift elements of arr[0.i-1], that are greater than 'key', one position ahead
            // to make space for the 'key'
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Shift element to the right
                j = j - 1;  // Move to the next element in the sorted portion
            }
            // Insert the 'key' in the correct position
            arr[j + 1] = key;
        }
    }

    // Main method to test the insertion sort
    public static void main(String[] args) {
        int[] arr = {11,12,5,7,1,9};  // Example unsorted array
        
        System.out.println("Original array:");
        printArray(arr);
        
        // Call the insertion sort method
        insertionSort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
