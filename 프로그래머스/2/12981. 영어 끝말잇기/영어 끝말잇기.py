def solution(n, words):
    answer = []
    last = words[0][0]
    for i, word in enumerate(words):
        if word not in answer:
            if i != 0 and word[0] != last:
                return [i%n+1, i//n+1]
            answer.append(word)
            last = word[-1]
        else:
            return [i%n+1, i//n+1]
    return [0,0]