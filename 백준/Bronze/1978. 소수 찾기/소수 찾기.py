

n=int(input())
sum=0
a = list(map(int, input().split()))
for j in range(len(a)):
    if a[j] == 1:
        continue
    elif a[j] == 2:
        sum += 1
    else:
        sum2 = 0
        for k in range(2, a[j]):
            if a[j] % k == 0:
                sum2 += 1
        if sum2 == 0:
            sum += 1

print(sum)