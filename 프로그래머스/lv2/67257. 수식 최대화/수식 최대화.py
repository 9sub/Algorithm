from itertools import permutations
from re import split

def solution(expression):
    answer = []
    for pri in permutations(['*','+','-'],3):
        string = list(map(int, split('[\*\+\-]', expression)))
        operation = [c for c in expression if c in '*+-']
        for op in pri:
            while op in operation:
                i = operation.index(op)
                
                if op == '*':
                    v = string[i] * string[i+1]
                elif op == '+':
                    v = string[i] + string[i+1]
                elif op == '-':
                    v = string[i] - string[i+1]
                    
                string[i] = v
                string.pop(i+1)
                operation.pop(i)
        answer.append(string[0])
    return max(abs(v) for v in answer)