def solution(participant, completion):
    answer = ''
    participant.sort()
    completion.sort()
    #print(participant,completion)
    for i in range(len(participant)-1):
        if participant[i]!=completion[i]:
            return participant[i]
    return participant[-1]