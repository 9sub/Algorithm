
sum=0
while 1:
    a=int(input())
    if a==-1:
        break
    for i in range(1,a-1):
        if a%i==0:
            sum+=i
    if sum==a:
        print("%d = " %a,end='')
        for i in range(1,a//2+1):
            if a%i==0:
                if i==1:
                    print("%d "%i,end='')
                else:
                    print("+ %d " %i,end='')
        print()
    else:
        print("%d is NOT perfect." %a)
    sum=0