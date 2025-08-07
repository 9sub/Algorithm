
n = int(input())
t = []
for _ in range(n):
    t.append(int(input()))
cnt=0
for i in range(n-1, 0, -1):

    while t[i] <= t[i-1]:
        t[i-1] -=1
        cnt+=1

print(cnt)