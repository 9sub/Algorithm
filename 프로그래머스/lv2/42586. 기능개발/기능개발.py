def solution(progresses, speeds):
    answer = []
    for i,j in zip(progresses,speeds):
        pro = 100 - i
        if pro % j == 0:
            answer.append(pro//j)
        else:
            answer.append(pro//j +1)
    index = 0
    ans = []
    for i in range(len(answer)):
        if answer[index] < answer[i]:
            ans.append(i-index)
            index = i
    ans.append(len(answer) - index)
            
    return ans