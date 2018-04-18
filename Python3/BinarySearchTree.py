class Node:
    def __init__(self, key = 0, left = None, right = None):
        self.key = key
        self.left = left
        self.right = right

def createNode(x):
    newNode = Node(x)
    return newNode

def insertNode(root, x):
    if root == None:
        return createNode(x)
    if x < root.key:
        root.left = insertNode(root.left, x)
    elif x > root.key:
        root.right = insertNode(root.right, x)
    return root

def createTree(a, n):
    root = None
    for i in range(n):
        root = insertNode(root, a[i])
    return root

def searchNode(root, x):
    if root == None or root.key == x:
        return root
    if root.key < x:
        return searchNode(root.right, x)
    return searchNode(root.left, x)

def minValueNode(root):
    current = root
    while current.left != None:
        current = current.left
        return current

def deleteNode(root, x):
    if root == None:
        return root
    if x < root.key:
        root.left = deleteNode(root.left, x)
    elif x > root.key:
        root.right = deleteNode(root.right, x)
    else:
        if root.left == None:
            temp = root.right
            del root
            return temp
        elif root.right == None:
            temp = root.left
            del root
            return temp
        temp = minValueNode(root.right)
        root.key = temp.key
        root.right = deleteNode(root.right, temp.key)
        return root

def traversalTree(root):
    if root != None:
        traversalTree(root.left)
        print(root.key, end=' ')
        traversalTree(root.right)

def size(root):
    if root == None:
        return 0
    return size(root.left) + 1 + size(root.right)

def deleteTree(root):
    if root == None:
        return
    deleteTree(root.left)
    deleteTree(root.right)
    del root
