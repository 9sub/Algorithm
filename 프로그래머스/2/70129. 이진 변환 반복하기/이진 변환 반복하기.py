def solution(s):
    answer = []
    cnt = 0
    cnt_0 = 0
    x = s
    while True:
        if x == '1':
            break
        cnt_0 += x.count('0')
        x = '1'*x.count('1')
        c =len(x)
        x = bin(c)[2:]
        print(x)
        cnt+=1
    return [cnt, cnt_0]