def solution(wallpaper):
    x=[]
    y=[]
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '#':
                x.append(i)
                y.append(j)
    x.sort()
    y.sort()
    answer = [x[0], y[0], x[-1]+1, y[-1]+1]
    return answer