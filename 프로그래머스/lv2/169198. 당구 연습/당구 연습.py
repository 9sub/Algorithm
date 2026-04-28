def solution(m, n, startx, starty, balls):
    answer = []
    
    for ball in balls:
        diffx = startx-ball[0]
        diffy = starty-ball[1]
        
        left = (startx+ball[0])**2 + (diffy)**2
        right = (m-startx+m-ball[0])**2 + (diffy)**2
        up = (diffx)**2+(n-starty+n-ball[1])**2
        down=(diffx)**2+(starty+ball[1])**2
        
        if diffx == 0:
            if diffy>0:
                res = min(left,right,up)
            else:
                res = min(left,right,down)
        elif diffy==0:
            if diffx>0:
                res = min(right,up,down)
            else:
                res = min(left,up,down)
        else:
            res = min(left,right,up,down)
        
        answer.append(res)
        
    return answer