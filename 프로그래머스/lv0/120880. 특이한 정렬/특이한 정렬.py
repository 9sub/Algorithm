def solution(numlist, n):
    answer = []
    for i in range(len(numlist)-1):
        for j in range(len(numlist)-1):
            if abs(numlist[j]-n)>abs(numlist[j+1]-n):
                tmp=numlist[j]
                numlist[j]=numlist[j+1]
                numlist[j+1]=tmp
            elif abs(numlist[j]-n)==abs(numlist[j+1]-n):
                if numlist[j]<numlist[j+1]:
                    tmp=numlist[j]
                    numlist[j]=numlist[j+1]
                    numlist[j+1]=tmp
    return numlist