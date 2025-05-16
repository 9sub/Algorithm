def solution(s):

    stack = []
    for st in s:
        if st == '(':
            stack.append(st)
        elif st == ')':
            if stack:
                stack.pop()
            else:
                return False
    if stack:
        return False
    return True