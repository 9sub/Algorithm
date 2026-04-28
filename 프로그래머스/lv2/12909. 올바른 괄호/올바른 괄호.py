def solution(s):
    a=[]
    for i in s:
        if i == '(':
            a.append(i)
        elif i==')':
            if len(a)==0:
                return False
            t=a.pop()
            if t!='(':
                return False
    if len(a)!=0:
        return False
    return True