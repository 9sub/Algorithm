def solution(sides):
    answer = 0
    maxx=max(sides)
    minn=min(sides)
    for i in range(1,maxx):
        if i+minn>maxx:
            answer+=1
    for i in range(maxx,sum(sides)):
        answer+=1
    return answer