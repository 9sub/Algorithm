def solution(spell, dic):
    answer = 0
    for sen in dic:
        cnt=0
        for i in spell:
            if i in sen:
                cnt+=1
        if cnt == len(spell):
            return 1
    return 2