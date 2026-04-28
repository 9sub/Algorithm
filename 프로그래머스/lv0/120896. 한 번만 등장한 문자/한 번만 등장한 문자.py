def solution(s):
    answer = ''
    for i in s:
        if s.count(i)==1:
            answer+=i
    a=''.join(sorted(answer))
    return a