def solution(k, score):
    answer = []
    min_ = []
    for i in range(len(score)):
        if i < k:
            answer.append(score[i])
        else:
            if min(answer) < score[i]:
                answer.remove(min(answer))
                answer.append(score[i])
        min_.append(min(answer))
    return min_