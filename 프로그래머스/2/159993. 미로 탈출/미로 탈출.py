from collections import deque

def bfs(start, end , maps):
    
    dx = [1,0,-1,0]
    dy = [0,-1,0,1]
    visit= [[0]*len(maps[0]) for _ in range(len(maps))]
    visit[start[0]][start[1]] = 1
    
    que = deque([[start[0],start[1], 0]])
    while len(que) !=0:
        st_y,st_x,cnt = que.popleft()
        for i in range(4):
            ny = dy[i]+st_y
            nx = dx[i]+st_x
            
            if (ny>=0 and ny<len(maps)) and (nx>=0 and nx<len(maps[0])) and visit[ny][nx] == 0:
                if maps[ny][nx] == "X": continue
                if ny == end[0] and nx == end[1]:
                    return cnt+1
                visit[ny][nx] = 1
                que.append([ny,nx, cnt+1])
                    
    return -1


def solution(maps):

    for i in range(len(maps)):
        for j in range(len(maps[i])):
            if maps[i][j] == "S":
                start=[i,j]
            elif maps[i][j] == "E":
                end=[i,j]
            elif maps[i][j] == "L":
                lab=[i,j]
                
    cnt = bfs(start, lab, maps)
    if cnt == -1: return -1
    cnt2 = bfs(lab, end, maps)
    if cnt2 == -1: return -1
    
    return cnt+cnt2