import sys


input = sys.stdin.readline

n,m = map(int, input().split())

t = list(map(int, input().split()))

start = 0
end = 0
cnt = 0
sum_ = t[0]

while True:
    if sum_ == m:
        cnt+=1

    if sum_>= m:
        sum_ -= t[start]
        start += 1

    else:
        if end == n-1:
            break
        end += 1
        sum_ += t[end]

print(cnt)