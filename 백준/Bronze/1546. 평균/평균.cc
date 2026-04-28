#include<stdio.h>
main()
{
	int i,n;
	double ave = 0.,  sum = 0., a[1001], max = 0;
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		scanf("%lf", &a[i]);
	for (i = 0; i < n; i++) {
		if (a[i] > max)
			max = a[i];
	}
	for (i = 0; i < n; i++) {
		a[i] = (a[i] / max) * 100.;
	}
	for (i = 0; i < n; i++) {
		sum += a[i];
	}
	ave = sum / (double)n;
	printf("%f\n", ave);
}