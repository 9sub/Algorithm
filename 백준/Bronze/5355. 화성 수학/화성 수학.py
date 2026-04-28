a=int(input())
for i in range(a):
    b=list(map(str,input().split()))
    num=float(b[0])
    for j in range(len(b)):
        if(b[j]=='@'):
            num*=3
        elif b[j]=='%':
            num+=5
        elif b[j]=='#':
            num-=7

    print("%0.2f"%num)
