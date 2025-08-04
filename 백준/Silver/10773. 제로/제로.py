import sys


k = int(input())
s = []
for _ in range(k):
    t = int(input())
    if t == 0:
        s.pop()
    else:
        s.append(t)

if s:
    print(sum(s))
else:
    print(0)