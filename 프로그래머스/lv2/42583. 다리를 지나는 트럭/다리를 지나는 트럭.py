def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge=[0]*bridge_length
    up=0
    #truck_weights=truck_weights[::-1]
    while truck_weights:
        answer+=1
        up-=bridge.pop(0)
        if up+truck_weights[0]<=weight:
            w=truck_weights.pop(0)
        else:
            w=0
        up+=w
        bridge.append(w)
    return answer+len(bridge)
