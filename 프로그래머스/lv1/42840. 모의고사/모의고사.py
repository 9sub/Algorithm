def solution(answers):
    answer = [0]*3
    a=[1,2,3,4,5]
    b=[2,1,2,3,2,4,2,5]
    c=[3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ind1=0
    ind2=0
    ind3=0
    for i in answers:
        ind1%=len(a)
        ind2%=len(b)
        ind3%=len(c)
        if a[ind1]==i:
            answer[0]+=1
        if b[ind2]==i:
            answer[1]+=1
        if c[ind3]==i:
            answer[2]+=1
        ind1+=1
        ind2+=1
        ind3+=1
    maxx=max(answer)
    t=[]
    for i in range(3):
        if maxx==answer[i]:
            t.append(i+1)
        
    return t