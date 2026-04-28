
#include <stdio.h>


int main() {
    char a[10][10];
    int n, m;
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++)
        scanf("%s", a[i]);
    for (int i = 0; i < n; i++) {
        for (int j = m - 1; j >= 0; j--)
            printf("%c", a[i][j]);
        printf("\n");
    }
    
    return 0;
} 
