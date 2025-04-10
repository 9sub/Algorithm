def solution(numbers):
    answer = ''
    t = [str(s) for s in numbers]
    t.sort(key = lambda x:x*3, reverse=True)
    return str(int(''.join(t)))