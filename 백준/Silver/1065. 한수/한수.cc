#include<stdio.h>

int main()
{
	int n, i, j,a=0,t,h,o;
	scanf("%d", &n);
	if (n <= 99)
		a = n;
	else
	{
		a = 99;
		for (i = 100; i <= n; i++)
		{
			h = i/100;
			t = (i % 100) / 10;
			o = (i % 100) % 10;
			if (h - t == t - o)
				a++;
		}
	}
	printf("%d\n", a);
}