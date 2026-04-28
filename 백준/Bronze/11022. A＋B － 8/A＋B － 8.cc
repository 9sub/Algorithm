#include<stdio.h>
main()
{
	int a,i,b[1000],c[1000];
	int d[1000];
	scanf("%d", &a);
	for (i = 0; i < a; i++) {
		scanf("%d %d", &b[i], &c[i]);
		d[i] = b[i] + c[i];

	}
	for (i = 0; i < a; i++)
		printf("Case #%d: %d + %d = %d\n", i + 1,b[i],c[i], d[i]);
}