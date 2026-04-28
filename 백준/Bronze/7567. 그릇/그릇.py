a= list(str(input()))
sum=0
for i in range(len(a)):
    if i==0:
        sum+=10
    elif a[i]==a[i-1]:
        sum+=5
    else:
        sum+=10
print(sum)