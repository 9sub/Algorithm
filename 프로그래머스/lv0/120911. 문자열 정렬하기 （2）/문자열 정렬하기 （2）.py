def solution(my_string):
    answer =[]
    a=ord('a')-ord('A')
    for i in my_string:
        if i>='A' and i<='Z':
            answer.append(ord(i)+a)
        else:
            answer.append(ord(i))
    answer.sort()
    re=''
    for i in answer:
        re+=chr(i)
    return re