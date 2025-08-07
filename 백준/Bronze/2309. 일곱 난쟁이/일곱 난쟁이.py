from itertools import combinations

t = []

for _ in range(9):
    t.append(int(input()))


for i in combinations(t, 7):
    if sum(i) == 100:
        i = list(i)
        i.sort()
        for j in i:
            print(j)
        break