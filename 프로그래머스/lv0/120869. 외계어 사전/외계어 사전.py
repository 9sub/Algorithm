def solution(spell, dic):
    answer = 0
    for i in dic:
        cnt=0
        for j in spell:
            if j in i and i.count(j)<2:
                cnt+=1
        if cnt==len(i) and cnt==len(spell):
            return 1
    return 2