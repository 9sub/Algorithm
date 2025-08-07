

n,k = map(int, input().split())
t = list(map(int, input().split()))

list_ = []

for i in range(1, n):
    t[i] += t[i-1]

max_ = t[k-1]
for i in range(1, n-k+1):
    max_ = max(max_, t[i+k-1] - t[i-1])
print(max_)
