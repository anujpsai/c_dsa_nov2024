//find the number of even digits in a number


#include <stdio.h>

int countEvenDigits(int number) {
    int count = 0;
    
    // If the number is negative, make it positive
    if (number < 0) {
        number = -number;
    }
    
    while (number > 0) {
        int digit = number % 10; // Get the last digit
        if (digit % 2 == 0) {    // Check if the digit is even
            count++;
        }
        number /= 10;            // Remove the last digit
    }
    
    return count;
}

int main() {
    int number;
    printf("Enter a number: ");
    scanf("%d", &number);
    
    int evenCount = countEvenDigits(number);
    printf("Number of even digits: %d\n", evenCount);
    
    return 0;
}