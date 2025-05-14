from heapq import heappop, heappush

def solution(n, k, enemy):
    hq=[]
    romain = n
    answer = 0
    for i in range(len(enemy)):
        heappush(hq, -enemy[i])
        romain -= enemy[i]
        answer+=1
        if romain <0:
            if k > 0:
                max_ = -heappop(hq)
                romain += max_
                k -=1
            else:
                answer-=1
    return answer