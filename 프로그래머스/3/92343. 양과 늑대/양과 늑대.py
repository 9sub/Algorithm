from collections import deque

def solution(info, edges):
    visit = [0]*len(info)
    answer= []
    def dfs(sheep, wolf):
        if sheep > wolf:
            answer.append(sheep)
        else:
            return
        for s, e in edges:
            if visit[s] and not visit[e]:
                visit[e] = 1
                if info[e] == 0:
                    dfs(sheep+1, wolf)
                else:
                    dfs(sheep, wolf+1)    
                visit[e] = 0
    visit[0] = 1
    dfs(1,0)
    return max(answer)