#include<stdio.h>
main()
{
	int a,b,c;
	int d, e;
	scanf("%d %d", &a,&b);
	scanf("%d", &c);
	d = c / 60;
	e = c % 60;
	if ((a + d) >= 24) {
		if ((b + e) >= 60) {
			a = a + d - 24 + 1;
			b = b + e - 60;
		}
		else if ((b + e) < 60) {
			a = a + d - 24;
			b = b + e;
		}
	}
	else {
		if ((b + e) >= 60) {
			if (a+d == 23) {
				a = 0;
				b = b + e - 60;
			}
			else {
				a = a + d + 1;
				b = b + e - 60;
			}
		}
		else if ((b + e) < 60) {
			a = a + d;
			b = b + e;
		}
	}
	printf("%d %d\n", a, b);
}