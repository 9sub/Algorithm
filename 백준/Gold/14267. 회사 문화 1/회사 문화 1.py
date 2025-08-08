

n,m = map(int, input().split())
parent = list(map(int, input().split()))

for i in range(n):
    parent[i] -= 1
good = [0]*n
for _ in range(m):
    i, w = map(int, input().split())
    good[i-1] +=w

total_goods = [0]*n
for i in range(1,n):
    total_goods[i] += total_goods[parent[i]] + good[i]

print(*total_goods)