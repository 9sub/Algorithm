import heapq
def change_time_to_int(time):
    return int(time.split(':')[0])*60 + int(time.split(':')[1])

def solution(book_time):
    book_time = [[change_time_to_int(start), change_time_to_int(end)+10] for start, end in book_time]
    book_time.sort(key=lambda x : x[0])
    room = []
    
    for start, end in book_time:
        if room and room[0] <= start:
            heapq.heappop(room)
        heapq.heappush(room, end)
    return len(room)