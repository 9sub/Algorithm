def solution(score):
    answer = []
    rank=[1]*len(score)
    for i in score:
        answer.append(sum(i))
    for i in range(len(answer)):
        for j in range(len(answer)):
            if answer[i]>answer[j]:
                rank[j]+=1
    return rank