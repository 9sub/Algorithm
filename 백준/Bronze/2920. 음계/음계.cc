#include<stdio.h>

int main()
{
	int a[8], i,count=0,count2=0;
	for (i = 0; i < 8; i++)
		scanf("%d", &a[i]);
	for (i = 0; i < 8; i++)
	{
		if (a[i] == i + 1)
			count++;
		else if (a[7 - i] == i + 1)
			count2++;
	}
	if (count == 8)
		printf("ascending\n");
	else if (count2 == 8)
		printf("descending\n");
	else
		printf("mixed\n");
}