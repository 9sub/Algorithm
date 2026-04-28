def solution(age):
    answer = ''
    a=[]
    while age!=0:
        a.append(age%10)
        age//=10
    a.reverse()
    for i in a:
        answer+=chr((i)+ord('a'))
    return answer