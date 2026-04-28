def solution(order):
    answer = 0
    while order!=0:
        if (order%10)==3 or (order%10)==6 or (order%10)==9:
            answer+=1
        order//=10
    return answer