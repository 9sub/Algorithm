def solution(num_list, n):
    answer = []
    j=0
    for i in range(len(num_list)//n):
        answer.append(list(num_list[j:j+n]))
        j+=n
    return answer