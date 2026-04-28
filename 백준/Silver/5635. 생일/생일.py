n=int(input())


list=[]
for i in range(n):
    a,b,c,d=input().split()
    b=int(b)
    c=int(c)
    d=int(d)
    list.append((d,c,b,a))
list.sort()
print(list[-1][3])
print(list[0][3])
