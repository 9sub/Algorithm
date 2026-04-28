

t= int(input())
sum=0
past=0
a=list(map(int,input().split()))
for i in range(len(a)):
    if a[i]==1:
        if past>=1:
            a[i]+=past
        past+=1
    else:
        past=0
    sum+=a[i]
print(sum)
