from collections import deque
def solution(maps):
    answer = 0
    bfs(maps)
    if maps[len(maps)-1][len(maps[0])-1] == 1:
        return -1
    return maps[len(maps)-1][len(maps[0])-1]


def bfs(maps):
    que = deque()
    que.append((0,0))
    dx = [-1,1,0,0]
    dy=[0,0,-1,1]
    n = len(maps)
    m = len(maps[0])
    visit = [[False]*m for _ in range(n)]
    visit[0][0]=True
    while que:
        x,y = que.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<m and 0<=ny<n and maps[ny][nx] ==1:
                if not visit[ny][nx]:
                    maps[ny][nx] = maps[y][x]+1
                    visit[ny][nx] =True
                    que.append((nx,ny))
    