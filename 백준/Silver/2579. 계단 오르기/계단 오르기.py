x = int(input())

a = [0]*x
b = [0]*x

stair = []

for _ in range(x):
    stair.append(int(input()))

a[0] = stair[0]
b[0] = stair[0]

for i in range(1, x):
    if i >=2:
        a[i] = stair[i] + max(a[i-2], b[i-2])
    else:
        a[i] = stair[i]
    if i>=3:
        b[i] = stair[i] + stair[i-1] + max(a[i-3],b[i-3])
    else:
        b[i] = stair[i] + stair[i-1]

print(max(a[x-1], b[x-1]))