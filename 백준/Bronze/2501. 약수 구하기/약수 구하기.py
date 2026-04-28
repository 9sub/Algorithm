

n,k=map(int,input().split())
cnt=0
cnt2=0
for i in range(1,n+1):
    if n%i==0:
        cnt+=1
        if cnt==k:
            print(i)
            cnt2+=1
            break
if cnt2==0:
    print("0")