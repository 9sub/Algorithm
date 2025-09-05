from collections import deque

n,k = map(int,input().split())

t = [i+1 for i in range(n)]
que = deque(t)
answer= []
while que:

    for _ in range(k-1):
        tmp = que.popleft()
        que.append(tmp)
    pop_ = que.popleft()
    answer.append(pop_)

print('<', end='')
for i in range(n-1):
    print(answer[i], end=', ')
print(answer[-1], end='>')