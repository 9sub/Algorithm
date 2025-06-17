def count_measure(t):
    cnt=0
    until = int(t**0.5)
    for i in range(1,until+1):
        if i*i == t:
            cnt+=1
        elif t%i==0:
            cnt+=2
    return cnt


def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        t = count_measure(i)
        if t%2==0:
            answer+=i
        else:
            answer-=i
    return answer