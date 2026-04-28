from itertools import combinations

def solution(clothes):
    answer = 0
    kind = {}
    for name, cloth in clothes:
        if cloth in kind.keys():
            kind[cloth] += [name]
        else:
            kind[cloth] = [name]
    answer = 1
    for _, value in kind.items():
        answer *= len(value)+1
    return answer-1