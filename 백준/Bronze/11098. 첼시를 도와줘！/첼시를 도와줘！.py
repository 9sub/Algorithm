n=int(input())
max=0

for i in range(n):
    p=int(input())
    for j in range(p):
        a,b=input().split()
        a=int(a)
        if max<a:
            max=a
            mmax=b
    max=0
    print(mmax)