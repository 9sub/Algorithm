def solution(s):
    answer = 0
    same=0
    dif=0
    for i in s:
        if same == 0 and dif == 0:
            t = i
        if t == i:
            same+=1
        else:
            dif+=1
        if same == dif:
            answer+=1
            same =0
            dif=0
    if same!=0 or dif !=0:
        answer+=1
    return answer