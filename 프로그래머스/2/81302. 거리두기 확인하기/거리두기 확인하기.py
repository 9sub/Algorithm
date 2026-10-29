from collections import deque

def bfs(places):
    
    dx = [1,0,-1,0]
    dy = [0,-1,0,1]
    
    for i in range(len(places)):
        for j in range(len(places[i])):
            if places[i][j] == 'P':
                visit = [[0]*len(places[0]) for _ in range(len(places))]
                visit[i][j] = 1
                que = deque([[i,j,0]])
                while len(que) != 0:
                    y,x,cnt = que.popleft()
                    if cnt>=2:
                        break
                    for t in range(4):
                        ny = y+dy[t]
                        nx = x+dx[t]
                        if (nx>=0 and nx<len(places[0])) and (ny>=0 and ny<len(places[0])) and visit[ny][nx] != 1 and places[ny][nx] != "X":
                            if places[ny][nx] == "P" and cnt<=2:
                                return 0
                            visit[ny][nx] = 1
                            que.append([ny,nx,cnt+1])
    return 1
    
    

def solution(places):
    answer = []
    
    for tt in places:
        answer.append(bfs(tt))
    
    return answer