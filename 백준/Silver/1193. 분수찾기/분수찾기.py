
x = int(input())

t=0
line_end=0

while line_end < x:
    t+=1
    line_end +=t

k = line_end - x

if t%2==0:
    row = t - k
    col = k + 1
else:
    row = k+1
    col = t-k


print(f"{row}/{col}")