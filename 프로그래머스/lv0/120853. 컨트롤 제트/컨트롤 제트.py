def solution(s):
    answer = 0
    a=s.split(' ')
    for i in a:
        if i!='Z':
            answer+=int(i)
            t=int(i)
        else:
            answer-=t
    return answer