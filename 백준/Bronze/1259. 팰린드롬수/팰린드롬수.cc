#include<stdio.h>

int main()
{
	int x[1000], i=0, j,t,n;
	while (1)
	{
		scanf("%d", &t);
		if (t == 0)
			break;
		x[i] = t;
		i++;
	}
	n = 0;
	int nn;
	for (j = 0; j < i; j++)
	{
		nn = x[j];
		while (x[j]!=0)
		{
			n = n * 10 + x[j] % 10;
			x[j] /= 10;
		}
		if (nn == n)
			printf("yes\n");
		else
			printf("no\n");
		n = 0;
	}
}