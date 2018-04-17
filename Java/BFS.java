import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static ArrayList<Integer> BFS(int s, int f, ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        Queue<Integer> q = new LinkedList <Integer>();
        ArrayList<Integer> path = new ArrayList <Integer> ();
        ArrayList<Boolean> visited = new ArrayList <Boolean> ();
        for (int i = 0; i < V; i++) {
            visited.add(false);
            path.add(-1);
        }
        visited.set(s, true);
        q.add(s);
        while (q.isEmpty() == false) {
            int u = (int)q.remove();
            for (int i = 0; i < graph.get(u).size(); i++) {
                int v = graph.get(u).get(i);
                if (visited.get(v) == false) {
                    visited.set(v, true);
                    path.set(v, u);
                    q.add(v);
                }
            }
        }
        return path;
    }
    public static void printPathRecursion(int s, int f) {
        if (s == f)
            System.out.print(f + " ");
        else {
            if (path.get(f) == -1)
                System.out.println("No path");
            else {
                printPathRecursion(s, path.get(f));
                System.out.print(f + " ");
            }
        }
    }
    public static void printPath(int s, int f) {
        if (s == f) {
            System.out.print(s);
            return;
        }
        if (path.get(f) == -1) {
            System.out.print("No path");
            return;
        }
        ArrayList<Integer> b = new ArrayList<Integer> ();
        int m = 0;
        while (true) {
            b.add(f);
            f = path.get(f);
            if (s == f) {
                b.add(f);
                break;
            }
        }
        for (int i = b.size() - 1; i >= 0; i--) {
            System.out.print(b.get(i));
            System.out.print(" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList <Integer> (0));
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int s = 0, f = 5;
        ArrayList <Integer> path = BFS(s, f, graph);
        printPath(s, f);
    }
}
