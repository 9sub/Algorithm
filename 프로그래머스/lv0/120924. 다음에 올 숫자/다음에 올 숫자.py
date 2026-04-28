def solution(common):
    answer = 0
    a=common[1]-common[0]
    if common[2]-common[1]==a:
        return common[-1]+a
    b=common[1]//common[0]
    if common[2]//common[1]==b:
        return common[-1]*b