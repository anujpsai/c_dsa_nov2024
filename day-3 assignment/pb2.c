//find the fibo series of nth term


#include<stdio.h>
int main(){
    int inputNumbers, first = 0, second = 1, next;
    printf("enter the number of terms:");
    scanf(" %d", &inputNumbers);
    printf("the fibonacci series are:\nm");
    for (int i = 1; i<=inputNumbers; i++)
    {
        printf(" %d", first);
        next=first + second;
        first=second;
        second=next;
    }
    return 0;
}