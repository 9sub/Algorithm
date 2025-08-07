

n,k,b = map(int, input().split())

traffic = []

for _ in range(b):
    traffic.append(int(input()))

check = [0]*n
check = [1 if i in traffic else 0 for i in range(1,n+1)]

check_sum = [0]*n
check_sum[0] = check[0]
for i in range(1,n):
    check_sum[i] = check_sum[i-1] +check[i]

min_ = 99999999
for i in range(n-k+1):
    min_ = min(min_, check_sum[k-1+i] - check_sum[i])
print(min_)
