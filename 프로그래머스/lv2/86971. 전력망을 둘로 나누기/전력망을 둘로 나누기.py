from collections import deque
def solution(n, wires):
    answer=0
    graph=[[] for _ in range(n+1)]
    for a,b in wires:
        graph[a].append(b)
        #print(graph)
        graph[b].append(a)
        #print(graph)
    def bfs(start):
        visited=[0]*(n+1)
        q=deque([start])
        visited[start]=1
        cnt=1
        while q:
            s=q.popleft()
            #print("deque",q,s)
            for i in graph[s]:
                if not visited[i]:
                    #print("i,visited[i]",i,visited[i])
                    q.append(i)
                    visited[i]=1
                    cnt+=1
        return cnt
    
    res=n
    for a,b in wires:
        graph[a].remove(b)
        graph[b].remove(a)
        
        res=min(abs(bfs(a)-bfs(b)),res)
        
        graph[a].append(b)
        graph[b].append(a)
    return res