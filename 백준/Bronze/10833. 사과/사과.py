n=int(input())

sum=0
for i in range(n):
    a,b=map(int,input().split())
    t=b//a
    b-=a*t
    sum+=b
print(sum)