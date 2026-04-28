

x = int(input())

inp = [64,32,16,8,4,2,1]

cnt=0

for ins in (inp):
    if x <=0:
        break
    if ins > x :
        pass
    else:
        x-=ins
        cnt+=1


print(cnt)