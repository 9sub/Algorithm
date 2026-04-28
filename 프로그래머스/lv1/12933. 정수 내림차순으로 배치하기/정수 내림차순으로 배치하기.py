def solution(n):
    answer = "".join(sorted(str(n), reverse=True))
    return int(answer)