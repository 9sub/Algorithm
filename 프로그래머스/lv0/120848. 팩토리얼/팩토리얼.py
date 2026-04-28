def fac(n):
    if n<=1:
        return 1
    return fac(n-1)*n

def solution(n):
    answer = 1
    while True:
        if fac(answer)>n:
            break
        else:
            answer+=1
    return answer-1