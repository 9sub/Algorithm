#include<stdio.h>


int main()
{
    int t, n,cnt=0,sum=0,a[100001],*p;
    p = a;
    for (int i=3;i<=80000;i++)
    {
        if (i % 3 == 0 || i % 7 == 0)
            sum += i;
        *(p + i) = sum;
    }
    scanf("%d", &t);
    for (int i=0; i < t; i++) {
        scanf("%d", &n);
        printf("%d\n", *(a + n));
    }
}

