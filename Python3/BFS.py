from queue import Queue
MAX = 100
V = None
E = None
visited = [False]*MAX
path = [0]*MAX
graph = [[] for i in range(MAX)]
def BFS(s):
    for i in range(V):
        visited[i] = False
        path[i] = -1
        q = Queue()
        visited[s] = True
    q.put(s)
    while q.empty() == False:
        u = q.get()
        for v in graph[u]:
            if visited[v] == False:
                visited[v] = True
                q.put(v)
                path[v] = u

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
    f = 5
    BFS(s)
    printPath(s, f)
