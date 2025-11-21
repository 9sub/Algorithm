from itertools import product
import sys

input = sys.stdin.readline

n,m = map(int, input().split())

lis = [i for i in range(1, n+1)]

for t in product(lis, repeat=m):
    print(*t)
