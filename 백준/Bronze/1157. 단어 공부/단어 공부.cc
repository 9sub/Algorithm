#include<stdio.h>
#include<string.h>
char s[1000001];
int main()
{
	int count = 0, len, a[26] = { 0 },max=-1,mmax;
	scanf("%[^\n]s", s);
	len = strlen(s);
	for (int i = 0; i < len; i++)
	{
		if (s[i] >= 'a')
			a[s[i] - 'a']++;
		else
			a[s[i] - 'A']++;
	}
	for (int i = 0; i < 26; i++)
	{
		if (a[i] > max) {
			max = a[i];
			mmax = i;
		}
	}
	for (int i = 0; i < 26; i++)
		if (max == a[i])
			count++;
	if (count <=1)
		printf("%c\n", mmax + 'A');
	else
		printf("?\n");
}