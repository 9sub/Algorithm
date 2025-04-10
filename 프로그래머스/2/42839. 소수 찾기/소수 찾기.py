from itertools import permutations
def is_prime(num):
    if num < 2:
        return 0
    elif num == 2:
        return 1
    for i in range(2,num//2+1):
        if num%i ==0:
            return 0
    return 1

def solution(numbers):
    answer = 0
    permu = []
    primes = []

    for t in permutations(numbers):
        permu.append(t)
    for t in permu:
        tmp=0
        for i in range(len(t)):
            tmp = tmp*10+int(t[i])
            if is_prime(tmp) and tmp not in primes:
                primes.append(tmp)

    return len(primes)