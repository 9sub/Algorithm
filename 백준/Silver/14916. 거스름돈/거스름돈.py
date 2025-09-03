

n = int(input())


flag = False
for i in range(n//2+1):
    if (n - 2*i)%5 == 0:
        print(i + (n-2*i)//5)
        flag = True
        break
if not flag:
    print(-1)