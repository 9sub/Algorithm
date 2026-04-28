def solution(players, m, k):
    answer = 0
    server = []
    for j,player in enumerate(players):
        for i in range(len(server)-1,-1,-1):
            if server[i][0] == k:
                server.pop(i)
        if player >= len(server)*m+m:
            for _ in range(player//m - len(server)):
                #print(j,player)
                server.append([0])
                answer+=1
        for i in range(len(server)-1,-1,-1):
            server[i][0] +=1
        
    return answer