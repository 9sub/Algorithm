def solution(my_string):
    answer = 0
    t=0
    for i in my_string:
        if i>='0' and i<='9':
            t=t*10+int(i)
        else:
            answer+=t
            t=0
    if t!=0:
        answer+=t
    return answer