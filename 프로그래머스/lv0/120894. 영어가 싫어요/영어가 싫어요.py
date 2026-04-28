def solution(numbers):
    answer = ''
    num=["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    for a,b in enumerate(num):
        numbers=numbers.replace(b,str(a))
    return int(numbers)