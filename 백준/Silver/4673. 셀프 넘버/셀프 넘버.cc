#include<stdio.h>
#include<stdlib.h>
#define N 10000
int dn[10001];
main()
{
	int d(int);
	int i;
	for (i = 1; i <= N; i++) {
		dn[d(i)]=1;
		if (!dn[i])
			printf("%d\n", i);
	}
}

int d(int n)
{
	int sum;
	sum = n;
	while (1)
	{
		if (n == 0)
			break;
		sum += n % 10;
		n /= 10;
	}
	return sum;
}
	
