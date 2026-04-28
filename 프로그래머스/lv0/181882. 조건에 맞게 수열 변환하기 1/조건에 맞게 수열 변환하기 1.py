def solution(arr):
    for i, t in enumerate(arr):
        if t>=50:
            if t%2==0:
                arr[i] = t/2
        else:
            if t%2!=0:
                arr[i]=t*2
    return arr