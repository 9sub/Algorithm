#include<stdio.h>
main()
{
	int a[10], i,max=0,b=0;
	for (i = 0; i < 9; i++)
		scanf("%d", &a[i]);
	for (i = 0; i < 9; i++) {
		if (a[i] > max)
			max = a[i];
		if (max == a[i]) {
			b = i+1;
		}
	}
	printf("%d %d\n", max, b);
}