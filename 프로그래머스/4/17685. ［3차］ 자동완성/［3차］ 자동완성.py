class Node:
    def __init__(self, key, cnt=0):
        self.key = key
        self.cnt = cnt
        self.child = {}

class Trie:
    def __init__(self):
        self.head = Node(None)
        
    def insert(self, word):
        node = self.head
        
        for w in word:
            if w not in node.child:
                node.child[w] = Node(w)
                
            node = node.child[w]
            node.cnt +=1

    
    def search(self, word):
        head = self.head
        cnt=0
        for w in word:
            cnt+=1
            head = head.child[w]
            if head.cnt ==1:
                return cnt
        return len(word)
        

def solution(words):
    answer = 0
    trie = Trie()
    for w in words:
        trie.insert(w)
    for w in words:
        answer += trie.search(w)
    
    return answer