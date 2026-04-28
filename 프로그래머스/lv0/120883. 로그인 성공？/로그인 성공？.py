def solution(id_pw, db):
    answer = ''
    for a in db:
        key=a[0]
        value=a[1]
        if key == id_pw[0]:
            if value==id_pw[1]:
                return 'login'
            else:
                return 'wrong pw'
    return 'fail'