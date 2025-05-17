import sys

 

n,k = map(int, sys.stdin.readline().split())

time_=[]

for t in range(k):
    time_.append(list(map(int, sys.stdin.readline().split())))

time_.sort()

pos = 0
cnt_time =0

for x,t,s in time_:
    cnt_time += x-pos
    pos = x

    if cnt_time < s:
        cnt_time = s
    else:
        cycle = 2*t
        d = (cnt_time - s)%cycle
        if d>= t:
            cnt_time += cycle - d

cnt_time += n- pos
print(cnt_time)


