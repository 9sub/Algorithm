def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book)-1):
        pre=phone_book[i]
        next=phone_book[i+1]
        if pre == next[:len(pre)]:
            return False
    return True