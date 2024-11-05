//find sum of digits in a number


#include <stdio.h>

int sumOfDigits(int number) {
    int sum = 0;
    
    // If the number is negative, make it positive
    if (number < 0) {
        number = -number;
    }
    
    while (number > 0) {
        sum += number % 10; // Add the last digit to sum
        number /= 10;       // Remove the last digit
    }
    
    return sum;
}

int main() {
    int number;
    printf("Enter a number: ");
    scanf("%d", &number);
    
    int sum = sumOfDigits(number);
    printf("Sum of digits: %d\n", sum);
    
    return 0;
}