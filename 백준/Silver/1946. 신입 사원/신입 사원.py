import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    t = []
    for _ in range(n):
        s,m = map(int, input().split())
        t.append((s,m))

    t.sort()

    min_ = 1e9
    cnt = 0
    for i in range(n):
        if t[i][1] < min_:
            cnt+=1
            min_=  t[i][1]
    print(cnt)