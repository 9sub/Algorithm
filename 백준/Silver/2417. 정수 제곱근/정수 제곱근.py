

n = int(input())

start = 0
end = 2**32


while start <= end:
    mid = (start+end)//2
    
    if mid ** 2 < n:
        start = mid+1
    else:
        answer = mid
        end = mid-1

print(answer)