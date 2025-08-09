import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n= int(input())

adj = [[] for _ in range(n)]

for _ in range(n-1):
    a,b = map(int, input().split())
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)

visit = [0]*n
parent = [-1]*n

def dfs(t):
    visit[t] = 1
    for v in adj[t]:
        if not visit[v]:
            parent[v] = t
            dfs(v)
dfs(0)
for i in range(1,n):
    print(parent[i]+1)