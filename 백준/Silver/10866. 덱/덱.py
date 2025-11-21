from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
que = deque()

for _ in range(n):
    com = input().split()

    if com[0] == 'push_front':
        que.appendleft(com[1])
    elif com[0] == 'push_back':
        que.append(com[1])
    elif com[0] == 'pop_front':
        if len(que) == 0:
            print(-1)
        else:
            print(que.popleft())
    elif com[0] == 'pop_back':
        if len(que) == 0:
            print(-1)
        else:
            print(que.pop())
    elif com[0] == 'size':
        print(len(que))
    elif com[0] == 'empty':
        if len(que) == 0:
            print(1)
        else:
            print(0)
    elif com[0] == 'front':
        if len(que) == 0:
            print(-1)
        else:
            print(que[0])
    elif com[0] == 'back':
        if len(que) == 0:
            print(-1)
        else:
            print(que[-1])