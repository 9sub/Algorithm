import sys

sys.setrecursionlimit(10**6)


class Node:
    def __init__(self, tmp):
        self.x = tmp[0][0]
        self.data = tmp[1]
        self.left = None
        self.right = None

def insert_node(node, info):
    if node is None:
        return Node(info)

    if info[0][0] < node.x:
        node.left = insert_node(node.left, info)
    else:
        node.right = insert_node(node.right, info)
    return node
        
        
def make_tree(nodeinfo):
    
    nodes = []
    for i, node in enumerate(nodeinfo):
        nodes.append((node, i+1))
        
    nodes.sort(key=lambda x: x[0][0])
    nodes.sort(key=lambda x:x[0][1], reverse=True)
    
    root = None
    for node in nodes:
        root = insert_node(root, node)
    return root

def preorder(root, answer):
    if root:
        answer.append(root.data)
        preorder(root.left, answer)
        preorder(root.right, answer)
    
    return answer

    
def huwiorder(root, answer):
    if root:
        huwiorder(root.left, answer)
        huwiorder(root.right, answer)
        answer.append(root.data)
    
    return answer

def solution(nodeinfo):
    root = make_tree(nodeinfo)
    answer1 = preorder(root, [])
    answer2 = huwiorder(root, [])
    return [answer1, answer2]