import queue
MAX = 100
INF = int(1e9)
class Triad:
    source = 0
    target = 0
    weight = 0
    def __init__(self, source, target, weight):
        self.source = source
        self.target = target
        self.weight = weight

def BellmanFord(source, graph, dist):
    dist[source] = 0
    for i in range(1, n):
        for j in range(m):
            u = graph[j].source
            v = graph[j].target
            w = graph[j].weight
            if dist[u] != INF and dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                path[v] = u
    for i in range(m):
        u = graph[i].source
        v = graph[i].target
        w = graph[i].weight
        if dist[u] != INF and dist[u] + w < dist[v]:
            return False
    return True

if __name__ == '__main__':
    n, m = map(int, input().split())
    graph = []
    dist = [INF for i in range(n+5)]
    path = [-1 for i in range(n+5)]
    for i in range(m):
        u, v, w = map(int, input().split())
        graph.append(Triad(u, v, w));
    s, t = 0, 4
    res = BellmanFord(s, graph, dist)
    if res == False:
        print("Graph contains negative weight cycle")
    else:
        print(dist[t])
