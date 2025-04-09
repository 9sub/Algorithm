from collections import deque

def solution(queue1, queue2):
    answer = 0
    que1 = deque(queue1)
    que2 = deque(queue2)
    
    sum1 = sum(que1)
    sum2 = sum(que2)
    
    while True:
        if answer > len(queue1)*4:
            return -1
        if sum1<sum2:
            val = que2.popleft()
            que1.append(val)
            sum1+=val
            sum2-=val
        elif sum1>sum2:
            val = que1.popleft()
            que2.append(val)
            sum1-=val
            sum2+=val
        else:
            return answer
        answer+=1
    return -1