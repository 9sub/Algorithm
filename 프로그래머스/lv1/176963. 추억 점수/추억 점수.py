def solution(name, yearning, photo):
    answer = []
    for i in photo:
        s=0
        for j in i:
            if j in name:
                indx=name.index(j)
                s+=yearning[indx]
        answer.append(s)
    return answer