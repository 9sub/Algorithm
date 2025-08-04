import sys

match = {')':'(', '}':'{' , ']':'['}

while True:
    check = 0
    t = input()
    if t == '.':
        break
    s = []
    for i in t:
        if i == '(' or i == '{' or i == '[':
            s.append(i)
        elif i == ')' or i == '}' or i == ']':
            if len(s) == 0 or match[i] != s[-1]:
                check+=1
                break
            else:
                s.pop()
    if len(s) != 0:
        check+=1
    if check == 0:
        print('yes')
    else:
        print('no')