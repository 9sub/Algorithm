x=int(input())
a=0
b=0
c=0

if x>=300:
    d=x//300
    x-=300*d
    a+=d
if x>=60:
    d=x//60
    x-=60*d
    b+=d
if x>=10:
    d=x//10
    x-=10*d
    c+=d
if x!=0:
    print(-1)
else:
    print(a,b,c)
