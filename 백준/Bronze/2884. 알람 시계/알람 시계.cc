#include<stdio.h>
main()
{
	int a,b;
	scanf("%d %d", &a,&b);
	if (a==0&&b - 45 < 0) {
		a = 23;
		b = 60 - (45 - b);
	}
	else if (a == 0 && b - 45 >= 0) {
		b = b-45 ;
	}
	else if (a > 0 && b - 45 < 0) {
		a -= 1;
		b = 60 - (45 - b);
	}
	else if (a > 0 && b - 45 >= 0) {
		b = b - 45;
	}
	printf("%d %d\n", a, b);
}