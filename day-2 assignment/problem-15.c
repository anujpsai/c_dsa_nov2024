//find the smallest digit in a number
#include<stdio.h>
int main(){
    int n, r, sm=9;
    printf("enter a number");
    scanf("%d", &n);
    while(n>0){
        r = n%10;
        if (sm>r)
        {
            sm=r;
        }
        n=n/10;
    }
    printf("smallest digit:%d", sm);
    return 0;
}