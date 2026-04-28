def solution(i, j, k):
    answer = 0
    for a in range(i,j+1):
        while a!=0:
            if a%10==k:
                answer+=1
            a//=10
    return answer