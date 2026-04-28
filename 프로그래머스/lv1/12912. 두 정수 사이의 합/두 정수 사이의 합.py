def solution(a, b):
    if a<b:
        answer = [x for x in range(a,b+1)]
    else:
        answer = [x for x in range(a,b-1,-1)]
    return sum(answer)