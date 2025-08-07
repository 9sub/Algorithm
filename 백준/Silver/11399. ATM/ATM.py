
n = int(input())
t = list(map(int, input().split()))

t.sort()
sum_ = 0
for i in range(n):
    sum_ += sum(t[:i+1])

print(sum_)