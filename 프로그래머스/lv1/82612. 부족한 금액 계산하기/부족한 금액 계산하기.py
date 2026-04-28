def solution(price, money, count):
    answer=0
    for i in range(1,count+1):
        answer+=price*i
    answer=(money-answer)
    if answer>=0:
        return 0
    else:
        return -answer