def solution(my_string):
    answer=0
    a=my_string.split(' ')
    for i in range(len(a)):
        if i==0:
            answer+=int(a[i])
            continue
        if a[i]=='+':
            answer+=int(a[i+1])
        elif a[i]=='-':
            answer-=int(a[i+1])
        else:
            continue
    return answer
