x=int(input())
s1=100
s2=100
for i in range(x):
    a,b=map(int,input().split())
    if(a>b):
        s2-=a
    elif a<b:
        s1-=b
    else:
        continue
print(s1)
print(s2)