import java.util.Arrays;

public class BubbleSort {

    // Method to perform Bubble Sort
    public static void bubble_sort(int[] arr) {
        int n = arr.length;

        // Outer loop to traverse through all elements
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Main method to test the Bubble Sort
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11}; // Example array

        System.out.println("Original array: " + Arrays.toString(arr));

        // Sorting the array using Bubble Sort
        bubble_sort(arr);

        // Printing the sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}