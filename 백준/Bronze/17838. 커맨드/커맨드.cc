#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main()
{
    int t,cnt=0,right=0;
    char a[10000],*p;
    scanf("%d", &t);
    while (cnt != t) {
        right = 0;
        scanf("%s", a);
        if (strlen(a) == 7) {
            right++;
            p = a;
            if (*p == *(p + 1) && *p == *(p + 4) &&
                *(p + 2) == *(p + 3) && *(p + 2) == *(p + 5)
                && *(p + 2) == *(p + 6)&&*p!=*(p+6))
            {
                printf("%d\n", 1);
            }
            else
                printf("%d\n", 0);
        }
        else
            printf("0\n");
        cnt++;
    }
}

