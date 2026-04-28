def solution(array, n):
    answer = 0
    min=99999999999
    for i in array:
        if abs(i-n)<min:
            answer=i
            min=abs(i-n)
        elif abs(i-n)==min:
            if answer>i:
                answer=i
    return answer