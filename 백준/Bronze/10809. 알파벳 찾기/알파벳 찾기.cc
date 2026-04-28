#include<stdio.h>
main()
{
	char a[101] = { 0 };
	int i,j;
	scanf("%s", a);
	for (i = 97; i <= 122; i++)
	{
		j = 0;
		while (a[j] != 0)
		{
			if (a[j] == (char)i)
				break;
			j++;
		}
		if (a[j] == (char)i)
			printf("%d ", j);
		else printf("-1 ");
	}
}


	
