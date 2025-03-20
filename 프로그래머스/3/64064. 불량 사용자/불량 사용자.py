from itertools import permutations

def find(user_id, banned_id):
    for i in range(len(banned_id)):
        if len(user_id[i]) != len(banned_id[i]):
            return False
        for j in range(len(user_id[i])):
            if banned_id[i][j] == '*':
                continue
            if banned_id[i][j] != user_id[i][j]:
                return False
    return True



def solution(user_id, banned_id):
    per_user = list(permutations(user_id, len(banned_id)))
    ban = []
    for user in per_user:
        if not find(user, banned_id):
            continue
        else:
            users = set(user)
            if users not in ban:
                ban.append(users)
    return len(ban)


