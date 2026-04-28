a=int(input())

for i in range(a):
    b,c,d=map(int,input().split())
    if(b+d==c):
        print("does not matter")
    elif b+d<c:
        print("advertise")
    else:
        print("do not advertise")