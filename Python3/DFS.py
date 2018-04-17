MAX = 100
V = None
E = None
visited = [False]*MAX
path = [0]*MAX
graph = [[] for i in range(MAX)]
def DFS(src):
    for i in range(V):
        visited[i] = False
        path[i] = -1
    s = []
    visited[src] = True
    s.append(src)
    while len(s) > 0:
        u = s[-1]
        s.pop()
        for v in graph[u]:
            if visited[v] == False:
                visited[v] = True
                s.append(v)
                path[v] = u

def DFSRecursion(s):
    visited[s] = True
    for v in graph[s]:
        if visited[v] == False:
            path[v] = s
            DFSRecursion(v)

def printPathRecursion(s, f):
    if s == f:
        print(f, end=' ')
    else:
        if path[f] == -1:
            print("No path")
        else:
            printPathRecursion(s, path[f])
            print(f, end = ' ')

def printPath(s, f):
    b = []
    if f == s:
        print(f)
        return
    if path[f] == -1:
        print("No path")
        return
    while True:
        b.append(f)
        f = path[f]
        if f == s:
            b.append(s)
            break
    for i in range(len(b)-1,-1,-1):
        print(b[i], end = ' ')

if __name__ == '__main__':
    V, E = map(int, input().split())
    for i in range(E):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    s = 0
    d = 5
    DFS(s)
    printPath(s, d)
