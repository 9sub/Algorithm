import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

t = int(input())

def dfs(x,y):
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]

    for i in range(4):
        nx = dx[i]+x
        ny = dy[i]+y
        if (0<=nx<m) and (0<=ny<n) and lis[ny][nx] == 1:
            lis[ny][nx] = -1
            dfs(nx, ny)


for _ in range(t):
    m,n,k = map(int, input().split())

    lis = [[0]*m for _ in range(n)]

    for _ in range(k):
        x,y = map(int, input().split())
        lis[y][x] = 1

    count = 0
    for a in range(m):
        for b in range(n):
            if lis[b][a] == 1:
                dfs(a,b)
                count+=1
    print(count)

