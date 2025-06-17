def count_(t):
    cnt=0
    for i in range(1, int(t**0.5+1)):
        if i*i == t:
            cnt+=1
        elif t%i==0:
            cnt+=2
    return cnt

def solution(n):
    answer = 0
    for i in range(1,n+1):
        t = count_(i)
        if t>=3:
            answer+=1
    return answer