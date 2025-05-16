def solution(k, m, score):
    score.sort(reverse=True)
    tmp= 0
    sum_=0
    while tmp < len(score):
        if len(score[tmp:tmp+m]) == m:
            sum_ += min(score[tmp:tmp+m])*m
        tmp += m
    
    return sum_