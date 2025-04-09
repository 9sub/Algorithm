def solution(n, w, num):
    answer = 0
    cnt=0
    while (num<=n):
        num+= (w-((num-1)%w)-1)*2+1
        cnt+=1
    
    return cnt