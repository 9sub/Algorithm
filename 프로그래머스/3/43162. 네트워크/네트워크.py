def solution(n, computers):
    answer = 0
    visit = [False]*n
    for com in range(n):
        if not visit[com]:
            dfs(computers,n,com,visit)
            answer+=1
    return answer


def dfs(computers, n, com, visit):
    visit[com] = True
    for i in range(n):
        if i!=com and computers[com][i]==1:
            if visit[i] == False:
                dfs(computers,n,i, visit)
            