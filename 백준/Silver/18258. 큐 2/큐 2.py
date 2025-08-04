from collections import deque
import sys

n = int(input())

que = deque()

for _ in range(n):
    t = sys.stdin.readline().split()
    if t[0] == 'push':
        que.append(t[1])
    elif t[0] == 'pop':
        if len(que) == 0:
            print('-1')
        else:
            print(que.popleft())
    elif t[0] == 'size':
        print(len(que))
    elif t[0] == 'empty':
        if len(que) == 0:
            print(1)
        else:
            print(0)
    elif t[0] == 'front':
        if len(que) == 0:
            print(-1)
        else:
            print(que[0])
    elif t[0] == 'back':
        if len(que) == 0:
            print(-1)
        else:
            print(que[-1])