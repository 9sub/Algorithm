def solution(park, routes):
    x,y = 0,0
    
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "S":
                y = i
                x = j
    
    
    for route in routes:
        di, go = route.split()
        
        if di == "E":
            dx = 1
            dy = 0
        elif di == "W":
            dx = -1
            dy = 0
        elif di == "S":
            dx = 0
            dy = 1
        else:
            dx = 0
            dy = -1
        flag = 0
        tx = x
        ty = y
        for t in range(int(go)):
            tx += dx
            ty += dy
            if tx<0 or tx>=len(park[0]) or ty<0 or ty>=len(park) or park[ty][tx] == "X" :
                flag=1
                break
        if flag != 1:
            x = tx
            y = ty
        
    return [y,x]