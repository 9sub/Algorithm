#include<stdio.h>
#include<string.h>
int main()
{
	char a[20];
	int b,t,i,j,k;
	scanf("%d", &t);
	for (i = 0; i < t; i++)
	{
		scanf("%d %s", &b, a);
		for (j = 0; j < strlen(a); j++)
			for(k=0;k<b;k++)
				printf("%c", a[j]);
		printf("\n");
	}
	

	return 0;
}