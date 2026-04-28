def solution(quiz):
    answer = []
    for i in quiz:
        a=i.split(' = ')
        b=eval(a[0])
        if b==int(a[1]):
            answer.append("O")
        else:
            answer.append("X")
        
    return answer