from collections import deque

def solution(n, wires):
    answer = -1
    graph = [[] for _ in range((n+1))]
    
    for a,b in wires:
        graph[a].append(b)
        graph[b].append(a)
    
    def bfs(start):
        visit = [0]*(n+1)
        que = deque([start])
        visit[start] =1
        cnt=1
        while que:
            s = que.popleft()
            for i in graph[s]:
                if not visit[i]:
                    que.append(i)
                    visit[i] = 1
                    cnt+=1
        return cnt     
    res = 100000000
    for a,b in wires:
        graph[a].remove(b)
        graph[b].remove(a)
        res = min(res, abs(bfs(a) - bfs(b)))
        graph[a].append(b)
        graph[b].append(a)
    return res