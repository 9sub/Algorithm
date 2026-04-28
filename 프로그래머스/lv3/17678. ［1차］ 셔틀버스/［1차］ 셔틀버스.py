def solution(n, t, m, timetable):
    answer = ''
    timetable = [(int(t.split(":")[0])*60+int(t.split(":")[1])) for t in timetable]
    timetable.sort()
    start = 9*60
    bus_time = [(9*60)+(t*i) for i in range(n)]
    i=0
    for bus in bus_time:
        cnt=0
        while cnt<m and i<len(timetable) and timetable[i] <= bus:
            i+=1
            cnt+=1
        if cnt<m:
            answer = bus
        else:
            answer = timetable[i-1]-1
    return f"{str(answer//60).zfill(2)}:{str(answer%60).zfill(2)}"