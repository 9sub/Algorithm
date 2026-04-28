def is_same(a,b):
    if a=='(':
        if b==')':
            return 1
        else:
            return 0
    elif a=='{':
        if b=='}':
            return 1
        else:
            return 0
    elif a=='[':
        if b==']':
            return 1
        else:
            return 0
        
def is_correct(s):
    a=[]
    for i in s:
        if i == '[' or i == '{' or i == '(':
            a.append(i)
        elif i == ']' or i == '}' or i == ')':
            #print(a)
            if len(a)==0:
                return False
            t=a.pop()
            if is_same(t,i) == 0:
                return False
    if len(a)!=0:
        return False
    else:
        return True
def solution(s):
    answer = 0
    for i in range(len(s)):
        if is_correct(s):
            answer+=1
        s=s[1:]+s[0]
    return answer