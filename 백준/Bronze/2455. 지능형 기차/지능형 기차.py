
sum=0
max=0
for i in range(4):
    a,b=map(int,input().split())
    sum+=b-a
    if sum>max:
        max=sum
print(max)
