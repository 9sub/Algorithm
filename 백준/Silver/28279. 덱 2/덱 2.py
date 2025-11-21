from collections import deque
import sys

input = sys.stdin.readline

n = int(input())

que = deque()


for _ in range(n):
    t = list(map(int, input().split()))

    if t[0] == 1:
        que.appendleft(t[1])
    elif t[0] == 2:
        que.append(t[1])
    elif t[0] == 3:
        if len(que) == 0:
            print(-1)
        else:
            print(que.popleft())
    elif t[0] == 4:
        if len(que) == 0:
            print(-1)
        else:
            print(que.pop())
    elif t[0] == 5:
        print(len(que))
    elif t[0] == 6:
        if len(que) == 0:
            print(1)
        else:
            print(0)
    elif t[0] == 7:
        if len(que) == 0:
            print(-1)
        else:
            print(que[0])
    elif t[0] == 8:
        if len(que) == 0:
            print(-1)
        else:
            print(que[-1])