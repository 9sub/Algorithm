def solution(num, k):
    answer = 0
    a=[]
    while num!=0:
        a.append(num%10)
        num//=10
    a.reverse()
    print(a)
    for i in range(len(a)):
        if a[i]==k:
            return i+1
    return -1