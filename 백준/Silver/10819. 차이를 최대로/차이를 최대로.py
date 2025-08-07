from itertools import permutations

n = int(input())

t = list(map(int, input().split()))
subset = []
subset.extend(permutations(t, n))
max_=0
for list_ in subset:
    sum_=0
    for i in range(len(list_)-1):
        sum_+= abs(list_[i]-list_[i+1])
    if max_ < sum_:
        max_ = sum_

print(max_)