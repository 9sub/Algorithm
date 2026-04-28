def solution(my_str, n):
    answer = []
    t=0
    while t< len(my_str):
        answer.append(my_str[t:t+n])
        t+=n
    return answer