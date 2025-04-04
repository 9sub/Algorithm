
def solution(name):
    n = len(name)
    
    moves = sum(min(ord(c) - ord('A'), ord('Z') - ord(c)+1) for c in name)
    
    horizon = n-1
    
    for i in range(n):
        next_ind = i+1
        
        while next_ind < n and name[next_ind] == 'A':
            next_ind+=1
        horizon = min(horizon, i+n-next_ind+min(i,n-next_ind))
    return moves+horizon