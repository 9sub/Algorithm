
x=int(input())
y=[]
for i in range(x):
    a,b,c=map(int,input().split())

    if(a==b==c):
        y.append(10000+a*1000)
    elif a==b or a==c:
        y.append(1000+a*100)
    elif b==c:
        y.append(1000+b*100)
    else:
        y.append(max(a,b,c)*100)
print(max(y))