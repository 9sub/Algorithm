
#include <stdio.h>
#include<stdlib.h>
#include<string.h>


int main() {

    int t, h, w, n,total,cnt=0;
    scanf("%d", &t);
    
    int temp;
    while (1) {
        if (cnt == t)
            break;
        scanf("%d %d %d", &h, &w, &n);
        if (n % h == 0) {
            printf("%d\n", h * 100 + n / h);
        }
        else {
            printf("%d\n", n % h * 100 + n / h+1);
        }
        cnt++;
    }
    return 0;
}
