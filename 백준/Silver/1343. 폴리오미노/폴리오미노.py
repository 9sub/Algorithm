

t = input()
answer = ''
flag = 0
for i, t_ in enumerate(t.split('.')):
    if len(t_)%2 != 0:
        flag =1
        break

    len_t = len(t_)

    a = len_t//4
    len_t %= 4
    b = len_t//2
    answer += 'AAAA'*a + 'BB'*b
    if i != len(t.split('.'))-1:
        answer+='.'


if flag:
    print(-1)
else:
    print(answer)