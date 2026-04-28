def solution(array, commands):
    answer = []
    for a in commands:
        temp=array[a[0]-1:a[1]]
        temp.sort()
        answer.append(temp[a[2]-1])
    return answer
