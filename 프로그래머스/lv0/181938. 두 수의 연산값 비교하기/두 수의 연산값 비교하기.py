def solution(a, b):
    answer = ''
    answer = str(a)+str(b)
    return max(int(answer), 2*a*b)