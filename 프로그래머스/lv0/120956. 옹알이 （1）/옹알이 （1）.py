def solution(babbling):
    answer = 0
    a=["aya", "ye", "woo", "ma"]
    for i in range(len(babbling)):
        for j in a:
            if j in babbling[i]:
                if babbling[i].count(j)>=2:
                    break
                babbling[i]=babbling[i].replace(j," ")
    for i in babbling:
        cnt=0
        for j in i:
            if j !=' ':
                cnt+=1
        if cnt==0:
            answer+=1
    return answer