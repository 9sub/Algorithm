from itertools import combinations


n,m = map(int, input().split())

tmp = [i for i in range(1,n+1)]

t = combinations(tmp,m)

for t_ in t:
    print(*t_)