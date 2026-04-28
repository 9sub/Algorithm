h1,m1,s1=map(int,input().split(":"))
h2,m2,s2=map(int,input().split(":"))


if(s2-s1<0):
    m2-=1
    s=s2-s1+60
else:
    s=s2-s1
if m2-m1<0:
    h2-=1
    m=m2-m1+60
else:
    m=m2-m1
if h2-h1<0:
    h=h2-h1+24
else:
    h=h2-h1

print("%02d:%02d:%02d"%(h,m,s))

