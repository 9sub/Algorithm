def solution(n, money):
    
    tmp = [1]+[0]*n
    
    for coin in money:
        for amount in range(coin,n+1):
            tmp[amount]+=tmp[amount-coin]
    
    return tmp[n]