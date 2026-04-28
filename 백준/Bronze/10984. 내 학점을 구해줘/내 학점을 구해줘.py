n=int(input())


hak=0
gpa=0.
for i in range(n):
    t=int(input())
    for j in range(t):
        a,b=input().split()
        a=int(a)
        b=float(b)
        hak+=a
        gpa+=a*b
    print("%d %.1f"%(hak,gpa/hak))
    hak=0
    gpa=0