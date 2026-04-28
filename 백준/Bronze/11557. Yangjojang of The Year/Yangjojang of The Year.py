t=int(input())
max=0

for i in range(t):
    a=int(input())
    for j in range(a):
        b,c=input().split()
        c=int(c)
        if max<c:
            max=c
            mmax=b
    print(mmax)
    max=0
