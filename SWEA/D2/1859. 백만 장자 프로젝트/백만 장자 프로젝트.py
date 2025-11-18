#import sys

#input = sys.stdin.readline


t = int(input())

for cnt in range(t):
    n = int(input())
    a = list(map(int, input().split()))

    max_price = 0
    sum_ = 0

    for p in reversed(a):
        if p > max_price:
            max_price=  p
        else:
            sum_ += max_price - p

    print(f"#{cnt+1} {sum_}")