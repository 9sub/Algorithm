#include<stdio.h>
#include<string.h>

main()
{
	int i, n, sum, score, num, j;
	int test[1000];
	double ave, total;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		sum = 0;
		ave = 0.;
		score = 0;
		total = 0.;
		scanf("%d", &num);
		for (j = 0; j < num; j++) {
			scanf("%d", &test[j]);
			sum += test[j];
		}
		ave = (double)sum / (double)num;
		for (j = 0; j < num; j++) {
			if (test[j] > ave)
				score++;
		}
		total = (double)score / (double)num * 100;
		printf("%.3f%%\n", total);
	}
}
	
	
