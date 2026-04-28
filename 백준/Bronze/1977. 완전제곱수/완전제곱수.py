import math
m=int(input())
n=int(input())
max=n
sum=0
for i in range(m,n+1):
    if (math.sqrt(i))==int((math.sqrt(i))):
        sum+=i
        if max>i:
            max=i

if sum==0:
    print(-1)
else:
    print(sum)
    print(max)