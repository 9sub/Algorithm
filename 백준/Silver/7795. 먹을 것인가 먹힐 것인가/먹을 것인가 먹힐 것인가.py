import sys


input = sys.stdin.readline


t = int(input())

for _ in range(t):
    n,m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    a.sort()
    b.sort()

    start_a = 0
    start_b = 0
    cnt = 0

    while start_a < n:

        if start_b == m:
            cnt += start_b
            start_a += 1
        else:
            if a[start_a] > b[start_b]:
                start_b+=1
            else:
                start_a+=1
                cnt+=start_b

    print(cnt)

