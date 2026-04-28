n=int(input())

t=int(0)
p=int(1)
tmp=1
for i in range(n+1):
    if i==0 or i==1:
        continue
    tmp=t+p
    t=p
    p=tmp
print(tmp)

