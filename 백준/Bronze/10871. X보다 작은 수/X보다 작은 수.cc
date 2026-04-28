#include<stdio.h>
main()
{
	int i, n, x;
	int a[10000];
	scanf("%d %d", &n, &x);
	for (i = 0; i < n; i++)
		scanf("%d", &a[i]);
	for (i = 0; i < n; i++) {
		if (x > a[i])
			printf("%d ", a[i]);
	}
	printf("\n");
}