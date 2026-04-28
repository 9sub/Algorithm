#include<stdio.h>
int main()
{
	int i, j, a;
	scanf("%d", &a);
	for (i = 1; i <= 2 * a - 1; i++)
	{
		if (i <= a)
		{
			for (j = 2; j <= i; j++)
				printf(" ");

			for (j = 1; j <= 2 * a - 2 * i + 1; j++)
				printf("*");
			printf("\n");
		}
		else
		{
			for (j = 2; j <= 2 * a - i; j++)
				printf(" ");
			for (j = 1; j <= 2 * i-2*a + 1; j++)
				printf("*");
			printf("\n");
		}
	}
	return 0;
}