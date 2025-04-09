
def solution(friends, gifts):
    answer = 0
    total_give_take = [[0]*2 for _ in range(len(friends))]
    give_and_take = [[0]*len(friends) for _ in range(len(friends))]
    
    #make give and take matrix
    for i in range(len(friends)):
        for j in range(len(gifts)):
            give,take = gifts[j].split()
            if give == friends[i]:
                give_and_take[i][friends.index(take)]+=1

    for i in range(len(give_and_take)):
        for j in range(len(give_and_take[0])):
            total_give_take[i][0]+=give_and_take[i][j]
            total_give_take[i][1]+=give_and_take[j][i]
    gift_index = []
    for give_take in (total_give_take):
        gift_index.append(give_take[0]-give_take[1])
    last_take=[0]*len(friends)
    for i in range(len(give_and_take)):
        for j in range(len(give_and_take[0])):
            if give_and_take[i][j]>give_and_take[j][i]:
                last_take[i]+=1
            elif give_and_take[i][j] == give_and_take[j][i]:
                if gift_index[i] > gift_index[j]:
                    last_take[i]+=1
    
    
    return max(last_take)