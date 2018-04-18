class Node:
    def __init__(self):
        self.countLeaf = 0
        self.child = dict()
def addWord(root, s):
    tmp = root
    for ch in s:
        if ch in tmp.child:
            tmp = tmp.child[ch]
        else:
            tmp.child[ch] = Node()
            tmp = tmp.child[ch]
    tmp.countLeaf += 1
def findWord(root, s):
    tmp = root
    for ch in s:
        if ch not in tmp.child:
            return False
        tmp = tmp.child[ch]
    return tmp.countLeaf > 0

def isWord(node):
    return node.countLeaf != 0

def isEmpty(node):
    return len(node.child) == 0

def removeWord(root, s, level, len):
    if root == None:
        return False
    if level == len:
        if root.countLeaf > 0:
            root.countLeaf -= 1
            return True
        return False
    ch = s[level]
    flag = removeWord(root.child[ch], s, level + 1, len)
    if flag == True and isWord(root.child[ch]) == False and \
        isEmpty(root.child[ch]) == True:
            tmp = root.child[ch]
            del tmp
            del root.child[ch]
    return flag
