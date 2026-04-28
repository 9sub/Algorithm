def solution(my_string):
    answer = ''
    a=ord('a')-ord('A')
    for i in my_string:
        if i >='A' and i<='Z':
            answer+=chr((i)+a)
        elif i>='a' and i<='z':
            answer+=chr((i)-a)
    return answer