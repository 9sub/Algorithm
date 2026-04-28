#include<stdio.h>
main()
{
	int a,i,b,c;
	int d[100];
	scanf("%d", &a);
	for (i = 0; i < a; i++) {
		scanf("%d %d", &b, &c);
		d[i] = b + c;

	}
	for (i = 0; i < a; i++)
		printf("%d\n",d[i]);
}