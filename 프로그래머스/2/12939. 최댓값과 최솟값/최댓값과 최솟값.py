def solution(s):
    answer = ''
    spl = list(map(int,s.split()))
    print((spl))
    answer = str(min(spl))+' '+str(max(spl))
    return answer