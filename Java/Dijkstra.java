public class Dijkstra {
    class Node implements Comparable<Node> {
        public Integer id;
        public Integer dist;
        public Node(Integer id, Integer dist) {
            this.id = id;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node other) {
            return this.dist.compareTo(other.dist);
        }
    }
    public static void Dijkstra(int s, ArrayList<ArrayList<Node>> graph)
    {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int n = graph.size();
        dist = new int[n];
        path = new int[n];
        for (int i=0; i<n; i++) {
            dist[i] = Integer.MAX_VALUE;
            path[i] = -1;
        }
        pq.add(new Node(s, 0));
        dist[s] = 0;
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int node = top.id;
            d = top.dist;
            for (int i = 0; i < graph.get(node).size(); i++) {
                Node neighbor = graph.get(node).get(i);
                if (d + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = d + neighbor.dist;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                    path[neighbor.id] = node;
                }
            }
        }
    }
    private static int[] dist;
    private static int[] path;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = 0, t = 4;
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
            for (int j = 0; j < n; j++) {
                int d = sc.nextInt();
                if (d > 0) {
                    graph.get(i).add(new Node(j, d));
                }
            }
        }
        Dijkstra(s, graph);
        System.out.println(dist[t]);
    }
}
