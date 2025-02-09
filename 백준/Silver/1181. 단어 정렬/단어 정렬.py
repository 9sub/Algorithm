

x = int(input())

t = []

for i in range(x):
    t.append(input())

t = list(set(t))
t.sort()
t.sort(key=len)

for i in range(len(t)):
    print(t[i])