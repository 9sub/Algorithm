#include <stdio.h>
#include<string.h>
#include<stdlib.h>

int main() {
    int a[3][4];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            scanf("%d", &a[i][j]);
        }
    }
    int sum = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            if (a[i][j] == 1)
                sum++;
        }
        if (sum == 3)
            printf("A\n");
        else if (sum == 4)
            printf("E\n");
        else if (sum == 2)
            printf("B\n");
        else if (sum == 1)
            printf("C\n");
        else
            printf("D\n");
        sum = 0;
    }
    return 0;
}

