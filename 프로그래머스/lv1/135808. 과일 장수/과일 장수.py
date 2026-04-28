def solution(k, m, score):
    score.sort(reverse=True)
    i = 0
    result = 0
    while i<len(score):
        if i+m > len(score):
            break
        a = score[i:i+m]
        minn = min(a)
        result += minn*m
        i+=m
    return result