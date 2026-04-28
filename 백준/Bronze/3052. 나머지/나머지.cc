#include<stdio.h>
main()
{
	int i,j,sum,result=0;
	int a[11], b[11] = { 43 };
	for (i = 0; i < 10; i++) {
		scanf("%d", &a[i]);
		b[i] = a[i] % 42;
	}
	for (i = 0; i < 10; i++) {
		sum = 0;
		for (j = i+1; j < 10; j++) {
			if (b[j] == b[i])
				sum += 1;
		}
		if (sum == 0)
			result++;
	}
	printf("%d\n", result);
}