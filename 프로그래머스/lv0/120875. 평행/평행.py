def deg(a,b):
    return (a[0]-b[0])/(a[1]-b[1])

def solution(d):
    answer = 0
    if deg(d[0],d[1])==deg(d[2],d[3]):
        return 1
    if deg(d[0],d[2])==deg(d[1],d[3]):
        return 1
    if deg(d[0],d[3])==deg(d[1],d[2]):
        return 1
    return 0