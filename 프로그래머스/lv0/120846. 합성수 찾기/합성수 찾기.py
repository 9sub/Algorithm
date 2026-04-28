def is_com(n):
    cnt=0
    for i in range(1,n+1):
        if cnt>=3:
            return True
        if n%i==0:
            cnt+=1
    if cnt>=3:
        return True
    else:
        return False

def solution(n):
    answer = 0
    for i in range(4,n+1):
        if is_com(i):
            answer+=1
    return answer