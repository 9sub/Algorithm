import sys
from collections import deque

input = sys.stdin.readline

n,m = map(int, input().split())

adj = [[] for _ in range(n)]
for _ in range(m):
    a,b = map(int, input().split())
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)

short_cut = [0]*n
for i in range(n):
    visit = [-1]*n
    visit[i] = 0
    que = deque([i])
    while que:
        tmp = que.popleft()
        for next in adj[tmp]:
            if visit[next] == -1:
                visit[next] = visit[tmp] + 1
                que.append(next)
    short_cut[i] = sum(visit)
print(short_cut.index(min(short_cut))+1)
