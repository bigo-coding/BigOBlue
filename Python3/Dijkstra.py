import queue
MAX = 100
INF = int(1e9)
class Node :
    def __init__(self, id, dist) :
        self.dist = dist
        self.id = id
    def __lt__(self, other) :
        return self.dist <= other.dist

def Dijkstra(s, graph) :
    pq = queue.PriorityQueue()
    pq.put(Node(s, 0))
    dist[s] = 0
    while pq.empty() == False :
        top = pq.get()
        node = top.id
        d = top.dist
        for neighbor in graph[node] :
            if d + neighbor.dist < dist[neighbor.id] :
                dist[neighbor.id] = d + neighbor.dist
                pq.put(Node(neighbor.id, dist[neighbor.id]))
                path[neighbor.id] = node

if __name__ == '__main__' :
    n = map(int, input().split())
    s = 0, t = 4
    graph = [[] for i in range(n + 5)]
    dist = [INF for i in range(n + 5)]
    path = [-1 for i in range(n + 5)]
    for i in range(n) :
        d = list(map(int, input().split()))
        for j in range(n) :
            if d[j] > 0:
                graph[i].append(Node(j, d[j]))
    Dijkstra(s, graph)
    ans = dist[t]
    print(ans)
