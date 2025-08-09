import sys

input = sys.stdin.readline

n = int(input())
m = int(input())

adj = [[] for _ in range(n)]

for _ in range(m):
    a,b = map(int, input().split())
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)

visit = [0]*n

def dfs(t):
    visit[t] = 1

    for i in range(len(adj[t])):
        if not visit[adj[t][i]]:
            dfs(adj[t][i])
dfs(0)
print(sum(visit)-1)