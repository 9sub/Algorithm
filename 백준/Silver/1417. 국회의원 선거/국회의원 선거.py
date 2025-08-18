import sys
from queue import PriorityQueue

input = sys.stdin.readline


n = int(input())

que= PriorityQueue()

dasom = int(input())

for _ in range(n-1):
    que.put(-int(input()))
if n == 1:
    print(0)
else:
    cnt=0
    while True:
        tmp = -que.get()
        if tmp < dasom:
            break
        que.put(-(tmp-1))
        dasom+=1
        cnt+=1

    print(cnt)


