#include<stdio.h>


int main()
{
    int N, m, M, T, R;
    int time = 0,mac,rest=0,wrong=0;
    scanf("%d %d %d %d %d", &N, &m, &M, &T, &R);
    mac = m;
    if (m + T > M)
        printf("-1\n");
    else {
        while (1)
        {
            if (mac + T <= M)
            {
                mac += T;
                time++;
            }
            else
            {
                if (mac - R > m)
                {
                    mac -= R;
                    rest++;
                }
                else {
                    mac = m;
                    rest++;
                }
            }
            if (time == N)
                break;
        }
        printf("%d\n", time + rest);
    }
}

