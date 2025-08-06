

n = int(input())
t = list(map(int, input().split()))
max_ = int(input())

left = 0
right = max(t)

while left <= right:
    mid = (left+right)//2

    sum = 0
    for i in range(n):
        sum += min(mid, t[i])

    if max_ < sum:
        right = mid-1
    else:
        left = mid+1
        answer =mid

print(answer)


