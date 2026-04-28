a,b,c=map(int,input().split())
d=int(input())

sec=d+c
if sec>=60:
    s=sec//60
    b+=s
    sec-=s*60
if(b>=60):
    m=b//60
    a+=m
    b-=m*60
if(a>=24):
    t=a//24
    a-=t*24
print(a,b,sec)