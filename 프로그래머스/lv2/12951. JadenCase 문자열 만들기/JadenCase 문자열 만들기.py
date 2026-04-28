def solution(s):
    answer = ''
    tmp=1
    for s_ in s:
        if tmp == 1 and s_.isalpha():
            answer+= s_.capitalize()
            tmp = 0
        else:
            if s_ == ' ':
                tmp = 1
            else:
                tmp = 0
            s_=s_.lower()
            answer+=s_
    return answer