

t= int(input())
cnt=0
a=list(map(int,input().split()))
for i in range(len(a)):
    if a[i]%10==t:
        cnt+=1
print(cnt)
