import java.io.*;
import java.util.*;

public class Bellman_Ford {
    static class Triad {
        private int source;
        private int target;
        private int weight;
        public Triad(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
        public int getSource() { return this.source; }
        public int getTarget() { return this.target; }
        public int getWeight() { return this.weight; }
    }
    public static boolean BellmanFord(int source, ArrayList<Triad> graph,
            int[] dist, int[] path) {
        int u, v, w;
        dist[source] = 0;
        for (int j=1; j<=dist.length-1; j++) {
            for (int l=0; l<graph.size(); l++) {
                u = graph.get(l).getSource();
                v = graph.get(l).getTarget();
                w = graph.get(l).getWeight();
                if (dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v])) {
                    dist[v] = dist[u] + w;
                    path[v] = u;
                }
            }
        }
        for (int i=0; i<graph.size(); i++) {
            u = graph.get(i).getSource();
            v = graph.get(i).getTarget();
            w = graph.get(i).getWeight();
            if (dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Triad> graph = new ArrayList<Triad>();
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.add(new Triad(u, v, w));
        }
        int s = 0, t = 4;
        boolean res = BellmanFord(s, graph, dist, path);
        if (res == false) {
            System.out.println("Graph contains negative weight cycle");
        }
        else {
            System.out.println(dist[t]);
        }
	}
}
