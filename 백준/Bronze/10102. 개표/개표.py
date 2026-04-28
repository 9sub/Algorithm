a=int(input())
b=str(input())

a_count=b.count("A")
b_count=b.count("B")
if a_count>b_count:
    print("A")
elif a_count<b_count:
    print("B")
else:
    print("Tie")