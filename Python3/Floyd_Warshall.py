import queue
MAX = 100
INF = int(1e9)
def printPath(s, t):
    b = []
    while s != t:
        b.append(t)
        t = path[s][t]
    b.append(s)
    for i in range(len(b)-1,-1,-1):
        print(b[i], end=' ' if i > 0 else '\n')

def FloydWarshall(graph, dist):
    for i in range(n):
        for j in range(n):
            dist[i][j] = graph[i][j]
            if graph[i][j] != INF and i != j:
                path[i][j] = i
            else:
                path[i][j] = -1
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
                    path[i][j] = path[k][j]

if __name__ == '__main__':
    n = int(input())
    graph = [[None for i in range(n)] for j in range(n)]
    dist = [[None for i in range(n)] for j in range(n)]
    path = [[None for i in range(n)] for j in range(n)]
    for i in range(n):
        line = list(map(int, input().split()))
        for j in range(n):
            graph[i][j] = INF if line[j] == 0 and i != j else line[j]
            FloydWarshall(graph, dist)
    s, t = 0, 4
    printPath(s, t)
    print(dist[s][t])
