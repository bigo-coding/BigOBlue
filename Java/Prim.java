import java.io.*;
import java.util.*;

public class Prim {   
    private static int[] dist;
    private static int[] path;
    private static boolean[] visited;

    static class Node implements Comparable<Node> {
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
    private static void printMST() {
        int n = dist.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (path[i] == -1) {
                continue;
            }
            ans += dist[i];
            System.out.printf("%d - %d: %d\n", path[i], i, dist[i]);
        }
        System.out.printf("Weight of MST: %d", ans);
    }
    public static void prim(int source, ArrayList<ArrayList<Node>> graph)
    {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int n = graph.size();
        dist = new int[n];
        path = new int[n];
        visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        Arrays.fill(visited, false);
        pq.add(new Node(source, 0));
        dist[source] = 0;
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            visited[u] = true;
            for (int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                int v = neighbor.id, w = neighbor.dist;
                if (!visited[v] && w < dist[v]) {
                    dist[v] = w;
                    pq.add(new Node(v, w));
                    path[v] = u;
                }
            }
        }
    }
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }
        prim(0, graph);
        printMST();
    }
}
