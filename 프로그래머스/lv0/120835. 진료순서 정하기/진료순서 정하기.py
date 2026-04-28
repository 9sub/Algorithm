def solution(emergency):
    answer = []
    t=sorted(emergency,reverse=True)
    for i in emergency:
        answer.append(t.index(i)+1)
    return answer