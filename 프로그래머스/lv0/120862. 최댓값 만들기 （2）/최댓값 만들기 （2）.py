def solution(numbers):
    answer = 0
    maxx=-9999999999
    for i in range(len(numbers)-1):
        for j in range(i+1,len(numbers)):
            if numbers[i]*numbers[j]>maxx:
                maxx=numbers[i]*numbers[j]
    return maxx