import heapq

def solution(n, works):
    answer = 0
    works = [-w for w in works]
    heapq.heapify(works)
    for _ in range(n):
        tmp = -heapq.heappop(works)
        if tmp == 0:
            break
        heapq.heappush(works,-(tmp-1))
        
    return sum([w**2 for w in works])