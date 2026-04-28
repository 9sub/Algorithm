
#include <stdio.h>

struct human {
    int we;
    int t;
};


int main() {
    struct human a[50];
    int n, rank[50] = { 0 };
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d %d", &a[i].we, &a[i].t);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if ((a[i].we < a[j].we) && (a[i].t < a[j].t))
                rank[i]++;
        }
    }
    for (int i = 0; i < n; i++)
        printf("%d ", rank[i] + 1);
    printf("\n");
    return 0;
} 
