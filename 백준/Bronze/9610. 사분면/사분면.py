a=int(input())
d=[0]*5

for i in range(a):
    b,c=map(int,input().split())

    if b>0 and c>0:
        d[0]+=1
    elif b>0 and c<0:
        d[3]+=1
    elif b<0 and c>0:
        d[1]+=1
    elif b<0 and c<0:
        d[2]+=1
    else:
        d[4] += 1
for i in range(4):
    print("Q%d: %d" %((i+1),(d[i])) )
print("AXIS: %d" %d[4])