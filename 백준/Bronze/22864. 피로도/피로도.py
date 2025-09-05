

a,b,c,m = map(int, input().split())

t = 0
work = 0
i = 0

while i < 24:
    if a+t <= m:
        t+=a
        work+=b
    else:
        t -= c
        if t < 0:
            t = 0
    i+=1

print(work)