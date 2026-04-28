a=int(input())
count1=0
count2=0
for i in range(a):
    b=int(input())
    if b==1:
        count1+=1
    elif b==0:
        count2+=1
if count1>count2:
    print("Junhee is cute!")
else:
    print("Junhee is not cute!")