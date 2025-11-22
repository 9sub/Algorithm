
for i in range(10):
    nnn = int(input())

    board = [input().strip() for _ in range(100)]
    n = 100
    col = []
    for c in range(n):
        tmp = ''
        for r in range(n):
            tmp += board[r][c]
        col.append(tmp)

    answer = 1
    #가로
    for length in range(n, 0, -1):
        found = False
        for r in range(n):
            for start in range(n-length+1):
                s = board[r][start:start+length]
                if s == s[::-1]:
                    answer = length
                    found = True
                    break
            if found:
                break

        if not found:
            for c in range(n):
                for start in range(n-length+1):
                    s = col[c][start:start+length]
                    if s == s[::-1]:
                        answer = length
                        found = True
                        break
                if found:
                    break

        if found:
            break

    print(f"#{nnn} {answer}")

