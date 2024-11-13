public class MergeSort {

    // Method to perform the Merge Sort
    public static void mergeSort(int[] arr) {
        // Base case: if the array has one or zero elements, it's already sorted
        if (arr.length <= 1) {
            return;
        }
        
        // Find the middle point to divide the array into two halves
        int mid = arr.length / 2;
        
        // Create two sub-arrays
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        // Copy data to the left and right sub-arrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        
        // Recursively sort the left and right sub-arrays
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted sub-arrays back into the original array
        merge(arr, left, right);
    }

    // Merge two sorted sub-arrays into a single sorted array
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        // Merge the two sub-arrays into the original array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        
        // If there are remaining elements in left[], copy them
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        
        // If there are remaining elements in right[], copy them
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test Merge Sort
    public static void main(String[] args) {
        int[] arr = {11, 16, 9, 15, 18};
        
        System.out.println("Original array:");
        printArray(arr);
        
        mergeSort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
