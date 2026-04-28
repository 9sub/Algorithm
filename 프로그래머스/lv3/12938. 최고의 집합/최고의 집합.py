def solution(n, s):
    answer = []
    if n>s:
        return[-1]
    t=s//n
    for i in range(n):
        answer.append(t)
    ind=len(answer)-1
    for i in range(s%n):
        answer[ind]+=1
        ind-=1
    return answer