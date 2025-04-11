import sys
sys.setrecursionlimit(10**6)

class Node:
    def __init__(self, data):
        self.x = data[0][0]
        self.data = data[1]
        self.left = None
        self.right = None

def insert(node,data):
    if node is None:
        return Node(data)
    if data[0][0] < node.x:
        node.left = insert(node.left, data)
    else:
        node.right = insert(node.right, data)
    return node
    
        
def make_tree(info):
    info.sort(key=lambda x:x[0][1], reverse=True)
    
    root = None
    for inf in info:
        root = insert(root,inf)
    return root



def solution(nodeinfo):
    answer = [[]]
    node = []
    for i,n in enumerate(nodeinfo):
        node.append((n,i+1))
    root = make_tree(node)
    
    pre = []
    post = []
    
    def preorder(t):
        if t:
            pre.append(t.data)
            preorder(t.left)
            preorder(t.right)
    
    def postorder(t):
        if t:
            postorder(t.left)
            postorder(t.right)
            post.append(t.data)
    
    preorder(root)
    postorder(root)
    
    
    return [pre,post]