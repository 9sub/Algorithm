def div(n, num):
    temp = '0123456789ABCDEF'
    q, r = divmod(n,num)
    
    if q == 0:
        return temp[r]
    else:
        return div(q,num)+temp[r]

def solution(n, t, m, p):
    answer = ''
    cnt=0
    while(True):
        answer += div(cnt,n)
        
        if len(answer)>=t*m:
            answer = answer[:t*m]
            return answer[p-1:t*m:m]
        cnt +=1
