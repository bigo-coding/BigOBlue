import java.io.*;
import java.util.*;

public class Floyd_Warshall {
    final static int INF = 1000000000;
    private static int path[][];
    private static int dist[][];
    private static int graph[][];
    public static void printPath(int s, int t) {
        ArrayList<Integer> b = new ArrayList<Integer>();
        while (s != t) {
            b.add(t);
            t = path[s][t];
        }
        b.add(s);
        for (int i = b.size() - 1; i >= 0; i--) {
            System.out.print(b.get(i) + " ");
        }
        System.out.println();
    }
    public static void floydWarshall(int graph[][], int dist[][]) {
        int n = graph.length;
        int i, j, k;
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    path[i][j] = i;
                }
                else {
                    path[i][j] = -1;
                }
            }
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp;
        graph = new int[n][n];
        path = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp = sc.nextInt();
                if (temp == 0 && i != j) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = temp;
                }
            }
        }
    }
    floydWarshall(graph, dist);
    int s = 0, t = 4;
    int result = dist[s][t];
    printPath(s, t);
    System.out.println(result);
}
