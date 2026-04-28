def solution(strings, n):
    answer = []
    for i in strings:
        answer.append(i[n])
    for i in range(len(strings)-1):
        for j in range(len(strings)-1):
            if answer[j]>answer[j+1]:
                answer[j],answer[j+1]=answer[j+1],answer[j]
                strings[j],strings[j+1]=strings[j+1],strings[j]
            elif answer[j]==answer[j+1]:
                if strings[j]>strings[j+1]:
                    answer[j],answer[j+1]=answer[j+1],answer[j]
                    strings[j],strings[j+1]=strings[j+1],strings[j]
    return strings