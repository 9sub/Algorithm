
#include <stdio.h>
#include<stdlib.h>
#include<string.h>

int matrix(int [][40], int,int);

int main() {

    int  i, j, t, a[40][40] = { 0 }, cnt = 0;
    int b[38][38] = { 0 };
    scanf("%d %d", &i, &j);
    for (int k = 0; k < i; k++) {
        for (int l = 0; l < j; l++) {
            scanf("%d", &a[k][l]);
        }
    }
    scanf("%d", &t);
    for (int k = 0; k < i - 2; k++) {
        for (int l = 0; l < j - 2; l++) {
            if (matrix(a, k, l) >= t) {
                
                cnt++;
            }
        }
    }
    printf("%d\n", cnt);
    return 0;
} 

int matrix(int a[][40], int x,int y) {
    int i, j, b[9] = { 0 }, k = 0;
    for (i = x; i < x + 3; i++) {
        for (j = y; j < y + 3; j++) {
            b[k] = a[i][j];
            k++;
        }
    }
    for (i = 0; i < 8; i++) {
        for (j = 0; j < 8; j++) {
            if (b[j] < b[j+1])
            {
                int temp = b[j];
                b[j] = b[j+1];
                b[j+1] = temp;
            }
        }
    }
    
    return b[4];
}