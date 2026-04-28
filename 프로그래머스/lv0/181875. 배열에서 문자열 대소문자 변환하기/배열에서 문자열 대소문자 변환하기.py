def solution(strArr):
    answer=[]
    for i, st in enumerate(strArr):
        if i%2==0:
            answer.append(st.lower())
        else:
            answer.append(st.upper())
    return answer