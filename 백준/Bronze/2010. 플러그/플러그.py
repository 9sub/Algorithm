import sys
n=int(input())
sum=0
for i in range(n):
    t=int(sys.stdin.readline())
    sum+=t
print(sum-(n-1))