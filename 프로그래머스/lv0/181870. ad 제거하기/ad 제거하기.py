def solution(strArr):
    t=[]
    for i in strArr:
        if "ad" not in i:
            t.append(i)
    return t