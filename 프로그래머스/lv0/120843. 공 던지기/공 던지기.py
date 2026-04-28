def solution(numbers, k):
    answer = 0
    t=(k-1)*2
    answer=t%(len(numbers))
    return answer+1