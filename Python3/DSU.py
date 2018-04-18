def findSet(u):
    while u != parent[u]:
        u = parent[u]
    return u

def unionSet(u, v):
    up = findSet(u)
    vp = findSet(v)
    parent[vp] = up

MAX = 100
q = int(input())
parent = [i for i in range(MAX + 1)]
for i in range(q):
    x, y, z = map(int, input().split())
    if z == 1:
        unionSet(x, y)
    else:
        parentX = findSet(x)
        parentY = findSet(y)
        if parentX == parentY:
            print("1")
        else:
            print("0")
