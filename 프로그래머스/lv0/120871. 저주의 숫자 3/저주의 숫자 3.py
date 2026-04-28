def solution(n):
    answer = 0
    for i in range(n):
        answer+=1
        while answer%3==0 or '3' in str(answer):
            answer+=1
    return answer
#print(solution(6))
#print(solution(12))
#print(solution(13))
#print(solution(14))