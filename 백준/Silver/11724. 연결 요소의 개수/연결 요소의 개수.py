from collections import deque
import sys

input = sys.stdin.readline

n,m = map(int, input().split())

adj = [[] for _ in range(n)]

for _ in range(m):
    a,b = map(int, input().split())
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)

cnt = 0
visit = [0]*n

for s in range(n):
    if visit[s] == 0:
        cnt += 1
        que = deque([s])
        visit[s] = 1
        while que:
            tmp = que.popleft()
            for next in adj[tmp]:
                if visit[next] == 0:
                    visit[next] = 1
                    que.append(next)

print(cnt)