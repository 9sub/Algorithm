def solution(brown, yellow):
    answer=[]
    for i in range(1,yellow+1):
        if yellow%i==0:
            j=yellow//i
            if 2*(i+j)+4==brown:
                if i<j:
                    answer.append(j+2)
                    answer.append(i+2)
                else:
                    answer.append(i+2)
                    answer.append(j+2)
                break
    return answer