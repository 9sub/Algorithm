def solution(my_string):
    answer = ''
    for i in my_string:
        if i=='a' or i=='e' or i=='i' or i=='o' or i=='u':
            continue
        answer+=i
    return answer