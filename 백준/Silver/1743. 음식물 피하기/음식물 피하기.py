from collections import deque


n,m,k = map(int, input().split())

trash = [[1]*m for _ in range(n)]


for _ in range(k):
    r,c = map(int, input().split())
    trash[r-1][c-1] = 0

def bfs(i,j):
    que = deque([(i,j)])
    trash[i][j] = 1

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    cnt = 1

    while que:
        x,y = que.popleft()

        for t in range(4):
            nx,ny = x+dx[t], y+dy[t]
            if (0<=nx<n) and (0<=ny<m) and trash[nx][ny] == 0 :
                cnt+=1
                trash[nx][ny] = 1
                que.append((nx,ny))

    return cnt


max_ = 0
for n_ in range(n):
    for m_ in range(m):
        if not trash[n_][m_]:
            k = bfs(n_,m_)
            max_ = max(k, max_)

print(max_)