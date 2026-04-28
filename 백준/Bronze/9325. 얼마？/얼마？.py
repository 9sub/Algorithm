n=int(input())
sum=0
for i in range(n):
    s=int(input())
    t=int(input())
    for j in range(t):
        a,b=map(int,input().split())
        sum+=a*b
    sum+=s
    print(sum)
    sum=0