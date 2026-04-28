import math
def solution(n, k):
    answer = []
    a=[]
    for i in range(1,n+1):
        answer.append(i)
    while answer:
        t=(k-1)//math.factorial(n-1)
        a.append(answer.pop(t))
        k=k%math.factorial(n-1)
        n-=1
    return a