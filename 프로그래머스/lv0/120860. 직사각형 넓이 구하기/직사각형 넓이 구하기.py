def solution(dots):
    answer = 0
    x1=dots[0][0]
    y1=dots[0][1]
    x=0
    y=0
    for i in range(1,len(dots)):
        if dots[i][0]==x1:
            y=abs(dots[i][1]-y1)
            
        if dots[i][1]==y1:
            x=abs(dots[i][0]-x1)
            #print(x)
    answer=x*y
    return answer