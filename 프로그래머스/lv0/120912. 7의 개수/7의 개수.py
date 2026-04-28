def solution(array):
    answer = 0
    for i in array:
        while i!=0:
            if i%10==7:
                answer+=1
            i//=10
    return answer