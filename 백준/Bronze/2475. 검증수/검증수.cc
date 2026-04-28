#include<stdio.h>

int main()
{
	int i, a[5],sum=0;
	for (i = 0; i < 5; i++)
		scanf("%d", &a[i]);
	for (i = 0; i < 5; i++)
	{
		sum += a[i] * a[i];
	}
	printf("%d\n", sum % 10);
}