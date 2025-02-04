def solution(arr):
    answer = []
    for i in arr:
        for t in range(i):
            answer.append(i)
    return answer