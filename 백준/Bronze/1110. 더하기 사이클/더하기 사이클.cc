#include<stdio.h>
main()
{
	int a, b,x,y,c=0;
	scanf("%d", &x);
	y = x;
	while (1)
	{
		a = y / 10 + y % 10;
		if (y <10)
		a=y;
		b = y % 10 * 10 + a % 10;
		y = b;
		c++;
		if (y == x)
			break;
	}
	printf("%d\n", c);
}