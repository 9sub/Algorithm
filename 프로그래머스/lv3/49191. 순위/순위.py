from collections import defaultdict

def solution(n, results):
    win = defaultdict(set)
    lose = defaultdict(set)
    answer = 0
    
    for a,b in results:
        win[a].add(b)
        lose[b].add(a)
        
        
    for i in range(1,n+1):
        for node in win[i]:
            lose[node].update(lose[i])
        for node in lose[i]:
            win[node].update(win[i])
    
    for i in range(1,n+1):
        if len(win[i]) + len(lose[i]) == n-1:
            answer+=1
    
            
    return answer