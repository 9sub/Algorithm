def solution(park, routes):
    index=[]
    c=0
    r=0
    for i in range(len(park)):
        r+=1
        c=0
        for j in range(len(park[i])):
            c+=1
            if park[i][j]=='S':
                index.append(i)
                index.append(j)
    for i in routes:
        cnt=0
        if i[0]=='E':
            temp=index[1]
            for j in range(int(i[2])):
                temp+=1
                if temp>c-1:
                    cnt+=1
                    break
                if park[index[0]][temp]=='X':
                    cnt+=1
            if cnt!=0:
                continue
            index[1]+=int(i[2])
        elif i[0]=='W':
            temp=index[1]
            for j in range(int(i[2])):
                temp-=1
                if temp<0:
                    cnt+=1
                    break
                if park[index[0]][temp]=='X':
                    cnt+=1
            if cnt!=0:
                continue
            index[1]-=int(i[2])
        elif i[0]=='N':
            temp=index[0]
            for j in range(int(i[2])):
                temp-=1
                if temp<0:
                    cnt+=1
                    break
                if park[temp][index[1]]=='X':
                    cnt+=1
            if cnt!=0:
                continue
            index[0]-=int(i[2])
        elif i[0]=='S':
            temp=index[0]
            for j in range(int(i[2])):
                temp+=1
                if temp>c-1:
                    cnt+=1
                    break
                if park[temp][index[1]]=='X':
                    cnt+=1
            if cnt!=0:
                continue
            index[0]+=int(i[2])
    return index
a=["OSO","OOO","OXO","OOO"]
b=["E 2","S 3","W 1"]
print(solution(a,b))