def solution(n):
    answer = 1
    t=6
    while True:
        if t%n==0:
            return answer
        t+=6
        answer+=1
    return answer