

n = int(input())

parent = list(map(int, input().split()))

k = int(input())
root=0
for i in range(n):
    if parent[i] == -1:
        root = i
        break

black = [0]*n
for i in range(n):
    u = i
    while True:
        if u == k:
            black[i] = 1
            break
        if u == root:
            break

        u = parent[u]

red = [0]*n
for i in range(n):
    if black[i] == 1:
        continue
    if i == root:
        continue
    red[parent[i]] = 1

cnt = 0
for i in range(n):
    if black[i] == 1 or red[i] == 1:
        continue
    cnt+=1

print(cnt)