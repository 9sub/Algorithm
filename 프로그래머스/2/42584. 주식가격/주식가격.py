from collections import deque


def solution(prices):
    answer = []
    que = deque(prices)
    
    while que:
        tmp = que.popleft()
        cnt=0
        for q in que:
            cnt+=1
            if tmp > q:
                break
        answer.append(cnt)
    return answer