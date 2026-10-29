from collections import deque

def bfs(start, end, board):
    dx = [1,0,-1,0]
    dy = [0,-1,0,1]

    visit = [[0]*len(board[0]) for _ in range(len(board))]
    visit[start[0]][start[1]] = 1
    que = deque([[start[0], start[1], 0]])

    while len(que) != 0:
        y, x, cnt = que.popleft()
        
        if [y,x] == end:
            return cnt
        
        for i in range(4):
            nx = x
            ny = y
            while True:
                tx = nx+dx[i]
                ty = ny+dy[i]
                if tx<0 or tx>=len(board[0]) or ty<0 or ty>=len(board):
                    break
                if board[ty][tx] == "D":
                    break
                nx = tx
                ny = ty
            if visit[ny][nx] == 0:
                visit[ny][nx] = 1
                que.append([ny,nx,cnt+1])
    
    return -1
                    
                    
                    
    
def solution(board):
    
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == "R":
                start = [i,j]
            elif board[i][j] == "G":
                end=[i,j]
                
    return bfs(start, end, board)

".D.R"
"...."
".G.."
"...D"