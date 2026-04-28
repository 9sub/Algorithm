def solution(x):
    tt = list(map(int,str(x)))

    if x % sum(tt) == 0:
        return True
    return False