def solution(polynomial):
    answer = ''
    cnt1=0
    cnt2=0
    a=polynomial.split(' + ')
    for i in a:
        if 'x' in i:
            if i[0]>='0' and i[0]<='9':
                cnt1+=int(i[:-1])
            else:
                cnt1+=1
        elif i[0]>='1' and i[0]<='9':
            cnt2+=int(i)
    if cnt1!=0 and cnt2!=0:
        if cnt1==1:
            answer+='x + '+str(cnt2)
        else:
            answer+=str(cnt1)+'x + '+str(cnt2)
    elif cnt1!=0 and cnt2==0:
        if cnt1==1:
            answer+='x'
        else:
            answer+=str(cnt1)+'x'
    elif cnt2!=0 and cnt1==0:
        answer+=str(cnt2)
    return answer

print(solution('x'))