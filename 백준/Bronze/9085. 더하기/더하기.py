

t= int(input())
sum=0
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    for j in range(len(a)):
        sum+=a[j]
    print(sum)
    sum=0