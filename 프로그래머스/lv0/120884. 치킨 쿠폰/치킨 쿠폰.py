def solution(chicken):
    re=0
    answer=0
    while chicken>=10:
        answer+=chicken//10
        re=(chicken)%10
        chicken//=10
        chicken+=re
        re=0
    return answer