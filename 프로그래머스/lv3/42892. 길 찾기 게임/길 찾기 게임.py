import sys
sys.setrecursionlimit(10**6)

class Node:
    def __init__(self, info):
        self.x  = info[0][0]
        self.data = info[1]
        self.left = None
        self.right = None

        
def insert(root,info):
    
    if not root:
        return Node(info)
    
    if info[0][0] < root.x:
        root.left = insert(root.left,info)
    else:
        root.right = insert(root.right,info)
    return root
    
        
def make_tree(infos):
    infos.sort(key=lambda x:x[0][1], reverse=True)
    root = None
    for info in infos:
        root=insert(root,info)
    return root

def solution(nodeinfo):
    
    nodes = [(info,i+1) for i,info in enumerate(nodeinfo)]
    
    root = make_tree(nodes)
    
    pre = []
    post = []
    
    def preorder(root):
        if root:
            pre.append(root.data)
            preorder(root.left)
            preorder(root.right)
    
    def postorder(root):
        if root:
            postorder(root.left)
            postorder(root.right)
            post.append(root.data)
    
    preorder(root)
    postorder(root)
    
    return [pre,post]