def solution(X, Y):
    x_count = [0]*(10)
    y_count = [0]*(10)
    
    for x in X:
        x_count[int(x)]+=1
    for y in Y:
        y_count[int(y)]+=1

    answer = ''
        
    for i in range(9,-1,-1):
        answer+= str(i)*min(x_count[i], y_count[i])
        
    if answer == '':
        return '-1'
    elif answer[0] == '0':
        return '0'
    
    return answer