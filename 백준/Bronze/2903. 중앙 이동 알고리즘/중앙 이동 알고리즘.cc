
#include <stdio.h>

int main() {
    int n, t = 2,cnt=0;
    scanf("%d", &n);
    while (cnt < n) {
        t += t - 1;
        cnt++;
    }
    printf("%d\n", t * t);
    return 0;
} 
