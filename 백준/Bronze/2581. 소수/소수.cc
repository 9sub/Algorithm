#include<stdio.h>

int main()
{
	int n, m,min=100000,sum=0,count=0,count1=0;
	scanf("%d %d", &m, &n);
	for (int i = m; i <= n; i++)
	{
		if (i == 1)
			count++;
		else if (i == 2)
		{
			count1++;
		}
		for (int j = 2; j < i; j++)
		{
			if (i % j == 0)
				count++;
			
		}
		if (count == 0)
		{
			count1++;
			sum += i;
			if (min > i)
				min = i;
		}
		count = 0;
	}
	if(count1==0)
		printf("%d\n", -1);
	else
		printf("%d\n%d\n", sum, min);

	return 0;
}