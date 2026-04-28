def is_prime(t):
    cnt=0
    for i in range(2,t):
        if t%i==0:
            cnt+=1
    if cnt==0:
        return 1
    else:
        return 0

def solution(n):
    answer = []
    t=n
    for i in range(2,n+1):
        if is_prime(i)==1:
            if t%i==0:
                answer.append(i)
                while t%i==0:
                    t//=i
    return answer