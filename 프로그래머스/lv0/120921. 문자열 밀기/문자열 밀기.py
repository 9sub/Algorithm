def solution(A, B):
    answer = 0
    a=0
    for i in range(len(A)):
        if A == B:
            return a
        A=A[-1]+A[:len(A)-1]
        a+=1
    return -1