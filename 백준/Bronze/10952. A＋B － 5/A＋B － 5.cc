#include<stdio.h>
main()
{
	int a[1000], b[1000], i,j;
	i = 0;
	while (1)
	{
		scanf("%d %d", &a[i], &b[i]);
		if (a[i] == 0 && b[i] == 0)
			break;
		i++;
	}
	for (j = 0; j < i; j++)
		printf("%d\n", a[j] + b[j]);
}