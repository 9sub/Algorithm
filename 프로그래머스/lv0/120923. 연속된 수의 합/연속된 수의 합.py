def solution(num, total):
    answer = []
    for i in range(-(total+num),total+num+1):
        sum=0
        for j in range(i,i+num):
            sum+=j
        if sum==total:
            for j in range(i,i+num):
                answer.append(j)
    return answer

print(solution(5,0))