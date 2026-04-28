#include<stdio.h>
main()
{
	int a, b[1000000],i,max=-1000000,min=1000000;
	scanf("%d", &a);
	for (i = 0; i < a; i++)
		scanf("%d", &b[i]);
	for (i = 0; i < a; i++)
	{
		if (b[i] > max)
			max = b[i];
		if (b[i] < min)
			min = b[i];
	}
	printf("%d %d\n", min, max);
}