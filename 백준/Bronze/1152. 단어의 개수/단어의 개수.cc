#include<stdio.h>
#include<string.h>
char s[1000001];
int main()
{
	int count=0;
	scanf("%[^\n]s", s);
	if (s[0] != ' ')
		count++;
	for (int i = 1; i < strlen(s); i++)
		if (s[i-1] == ' '&&s[i]!=' ')
			count++;
	printf("%d\n", count);
}