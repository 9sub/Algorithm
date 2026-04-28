def fac(n):
    if n==1:
        return 1
    return fac(n-1)*n

def solution(balls, share):
    answer = 1
    for i in range(balls,balls-share,-1):
        answer*=i
    answer//=fac(share)
    return answer