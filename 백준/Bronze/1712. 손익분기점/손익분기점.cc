#include<stdio.h>
int main()
{
	 int a, b, c,total=0;
	 int t = 1,make=0,sell=0;
	scanf("%d %d %d", &a, &b, &c);
	if (b >= c)
		printf("%d\n", -1);
	else
	{
		printf("%d\n", a / (c - b) + 1);
	}
}



