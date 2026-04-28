#include<stdio.h>
main()
{
	int a, b, c, d, max;
	scanf("%d %d %d", &a, &b, &c);
	if (a ==b&&b==c&&c==a) {
		d = 10000 + a * 1000;
	}
	else if (a == b|| a == c|| b == c) {
		if (a == b)
			d = 1000 + a * 100;
		else if (a == c)
			d = 1000 + a * 100;
		else if (b == c)
			d = 1000 + b * 100;
	}
	else
	{
		if (a > b)
		{
			if (a > c)
				max = a;
			else
				max = c;
		}
		else {
			if (c > b)
				max = c;
			else
				max = b;
		}
		d = max * 100;
	}
	printf("%d\n", d);
}