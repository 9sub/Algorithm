from collections import deque

def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n+1)]
    
    visit = [False]*(n+1)
    distance = [0]*(n+1)
    
    for i in edge:
        graph[i[0]].append(i[1])
        graph[i[1]].append(i[0])
    
    def bfs(start):
        que = deque()
        que.append(start)
        visit[start] = True
        
        while que:
            now = que.popleft()
            for i in graph[now]:
                if not visit[i]:
                    distance[i] = distance[now]+1
                    que.append(i)
                    visit[i] = True
    
    bfs(1)

    return distance.count(max(distance))