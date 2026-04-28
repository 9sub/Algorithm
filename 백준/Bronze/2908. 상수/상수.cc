#include<stdio.h>

int main()
{
	int a, b,aa=0,bb=0,t;
	scanf("%d %d", &a, &b);
	while (a != 0)
	{
		t = a % 10;
		aa = aa * 10 + t;
		a /= 10;
	}
	while (b != 0)
	{
		t = b % 10;
		bb = bb * 10 + t;
		b /= 10;
	}
	aa > bb ? printf("%d\n", aa) : printf("%d\n", bb);
}