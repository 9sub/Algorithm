

min=10000
sum=0
for i in range(7):
    a=int(input())
    if a%2!=0:
        if min>a:
            min=a
        sum+=a
if sum==0:
    print("-1")
else:
    print(sum)
    print(min)