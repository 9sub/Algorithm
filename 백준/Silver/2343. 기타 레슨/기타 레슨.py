


n,m = map(int,input().split())

t = list(map(int, input().split()))

answer = -1

left = max(t)
right = sum(t)

while left <= right:
    mid = (left + right) //2
    blue_num = 1
    remain = mid
    for i in range(n):
        if remain < t[i]:
            remain = mid
            blue_num += 1

        remain -= t[i]
    if blue_num <= m:
        answer = mid
        right = mid -1
    else:
        left = mid + 1

print(answer)