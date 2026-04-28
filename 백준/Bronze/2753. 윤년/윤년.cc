#include<stdio.h>
main()
{
	int a;
	scanf("%d", &a);
	if (a % 4 == 0 && a % 100 != 0)
		printf("1\n");
	else if (a % 400 == 0)
		printf("1\n");
	else
		printf("0\n");
}