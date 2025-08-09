from collections import deque

computers = int(input())
n = int(input())

adj = [[] for _ in range(computers+1)]
for _ in range(n):
    i,j = map(int, input().split())
    adj[i].append(j)
    adj[j].append(i)

warm = [0]*(computers+1)
warm[1] = 1

que = deque([1])
while que:
    tmp = que.popleft()
    for next in adj[tmp]:
        if not warm[next]:
            warm[next] = 1
            que.append(next)

print(sum(warm)-1)