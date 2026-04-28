t=int(input())
a1=0
a2=0
for i in range(t):
    for j in range(9):
        a,b=map(int,input().split())
        a1+=a
        a2+=b
    if a1>a2:
        print("Yonsei")
    elif a2>a1:
        print("Korea")
    else:
        print("Draw")