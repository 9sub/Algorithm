from collections import deque

def solution(maps):
    answer = []
    n = len(maps)
    m = len(maps[0])
    visit = [[False]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if visit[i][j] == False and maps[i][j] != 'X':
                answer.append(bfs(maps, visit,n,m,i,j))
    if not answer:
        return [-1]
    answer.sort()
    return answer
    
def bfs(maps,visit,n,m,i,j):
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    que = deque()
    que.append((i,j))
    visit[i][j] = True
    days=0
    while que:
        x,y = que.popleft()
        days+=int(maps[x][y])
        for i in range(4):
            nx = dx[i]+x
            ny = dy[i]+y
            if 0<=nx<n and 0<=ny<m and visit[nx][ny] == False and maps[nx][ny] !='X':
                que.append((nx,ny))
                visit[nx][ny]=True
    return days
    