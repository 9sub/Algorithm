def solution(participant, completion):
    count = {}
    
    for part in participant:
        count[part] = count.get(part, 0) + 1
        
    for com in completion:
        count[com] -=1
        
    for key, val in count.items():
        if val>0:
            return key
        
    