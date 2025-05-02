def solution(genres, plays):
    answer=[]
    dic = {}
    ans = [[genres[i], plays[i],i] for i in range(len(genres))]
    ans.sort(key=lambda x: ( -x[1],x[2]))
    for tmp in ans:
        if tmp[0] not in dic:
            dic[tmp[0]] = tmp[1]
        else:
            dic[tmp[0]] += tmp[1]
            
    dic = sorted(dic.items(), key=lambda x: x[1], reverse=True)
    for i in dic:
        cnt=0
        for j in ans:
            if cnt>=2:
                break
            if i[0] == j[0]:
                answer.append(j[2])
                cnt+=1
    return answer