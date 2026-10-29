from collections import deque

def bfs( graph,n):
    start = 1
    visit = [0]*(n+1)
    visit[start] = 1
    que = deque([start])
    cnt=1
    while len(que) != 0:
        st = que.popleft()
        for t in graph[st]:
            if visit[t] != 1:
                que.append(t)
                visit[t] = 1
                cnt+=1
    return cnt   

def solution(n, wires):
    graph = [[] for _ in range(n+1)]
    tmp = 9999999
    for wire in wires:
        graph[wire[0]].append(wire[1])
        graph[wire[1]].append(wire[0])
    
    for wire in wires:
        graph[wire[0]].remove(wire[1])
        graph[wire[1]].remove(wire[0])
        
        t = bfs(graph,n)
        tmp = min(tmp, abs(n-2*t))
        
        graph[wire[0]].append(wire[1])
        graph[wire[1]].append(wire[0])
    
    return tmp