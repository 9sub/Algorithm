def solution(x, y, n):
    answer = 0
    s = set()
    s.add(x)
    
    while s:
        if y in s:
            return answer
        tmp = set()
        for i in s:
            if i+n <= y:
                tmp.add(i+n)
            if i*2 <=y:
                tmp.add(i*2)
            if i*3 <=y:
                tmp.add(i*3)
        s = tmp
        answer+=1
    return -1