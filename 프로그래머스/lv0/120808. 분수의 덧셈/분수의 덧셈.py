import math

def solution(numer1, denom1, numer2, denom2):
    n1=numer1*denom2+numer2*denom1
    n2=denom1*denom2
    return [n1//math.gcd(n2,n1),n2//math.gcd(n2,n1)]