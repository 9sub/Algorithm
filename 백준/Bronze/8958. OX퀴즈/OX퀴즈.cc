#include<stdio.h>
#include<string.h>

main()
{
	int i, n, sum, score,j;
	char test[80];

	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		sum = 0;
		score = 1;
		scanf("%s", test);
		for (j = 0; j < strlen(test); j++) {
			if (test[j] == 'O') {
				sum += score;
				score++;
			}
			if (test[j] == 'X')
				score = 1;
		}
		printf("%d\n", sum);
	}
	
}