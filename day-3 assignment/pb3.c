// print the nth fibonacci term



#include <stdio.h>
int inputNumber(int n) {
    if (n <= 1)
        return n;
    return inputNumber(n - 1) + inputNumber(n - 2);
}
int main() {
    int n;
    printf("Enter a positive integer: ");
    scanf("%d", &n);

    if (n < 0)
        printf("Please enter a non-negative integer.\n");
    else
        printf("The %dth Fibonacci term is:\n %d\n", n, inputNumber(n));

    return 0;
}