#include<stdio.h>
main()
{
	int a, b, c, x[11] = { 0 }, d,  y, i;
	scanf("%d %d %d", &a, &b, &c);
	d = a * b * c;
	while (d != 0)
	{
		y = d % 10;
		for (i = 0; i < 10; i++) {
			if (y == i)
				x[i]++;
		}
		d=d / 10;
	}
	for (i = 0; i < 10; i++)
		printf("%d\n", x[i]);
}