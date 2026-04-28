#include<stdio.h>
main()
{
	int a,i,b,c;
	int d[1000];
	scanf("%d", &a);
	for (i = 0; i < a; i++) {
		scanf("%d %d", &b, &c);
		d[i] = b + c;

	}
	for (i = 0; i < a; i++)
		printf("Case #%d: %d\n", i + 1, d[i]);
}