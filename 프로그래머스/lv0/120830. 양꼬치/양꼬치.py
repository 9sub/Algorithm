def solution(n, k):
    sum=n*12000
    k-=n//10
    sum+=k*2000
    return sum