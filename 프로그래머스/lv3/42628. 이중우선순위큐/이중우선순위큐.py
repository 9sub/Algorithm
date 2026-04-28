def solution(operations):
    answer = []
    for i in operations:
        tmp=i.split(' ')
        if tmp[0]=='I':
            answer.append(int(tmp[1]))
        elif tmp[0]=='D':
            if len(answer)==0:
                continue
            if int(tmp[1])==-1:
                del answer[answer.index(min(answer))]
            elif int(tmp[1])==1:
                del answer[answer.index(max(answer))]
    if len(answer)==0:
        return [0,0]
    else:
        return[max(answer),min(answer)]