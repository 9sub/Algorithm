def hanoi(start, end, middle, answer, t):
    if t == 1:
        answer.append([start, end])
    else:
        hanoi(start, middle, end, answer, t-1)
        answer.append([start, end])
        hanoi(middle, end, start, answer, t-1)
        
    return answer


def solution(n):
    answer=[]
    answer = hanoi(1,3,2,answer, n)
    return answer