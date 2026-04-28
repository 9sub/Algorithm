def solution(nums):
    answer = 0
    a=set(nums)
    nn=len(a)
    n=len(nums)//2
    if nn>n:
        return n
    else:
        return nn