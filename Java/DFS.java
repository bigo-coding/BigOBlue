import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class a {
    public static void DFS(int src) {
        int V = graph.size();
        path = new ArrayList<Integer>();
        visited = new ArrayList<Boolean>();
        for (int i = 0; i < V; i++) {
            visited.add(false);
            path.add(-1);
        }
        Stack<Integer> stack = new Stack<Integer>();
        visited.set(src, true);
        stack.add(src);
        while (!stack.isEmpty()) {
            int u = stack.peek();
            stack.pop();
            for (int i = 0; i < graph.get(u).size(); i++) {
                int v = graph.get(u).get(i);
                if (!visited.get(v)) {
                    visited.set(v, true);
                    stack.add(v);
                    path.set(v, u);
                }
            }
        }
    }
    public static void DFSRecursion(int s) {
        visited.set(s, true);
        for (int i = 0; i < graph.get(s).size(); i++) {
            int v = graph.get(s).get(i);
            if (!visited.get(v)) {
                path.set(v, s);
                DFSRecursion(v);
            }
        }
    }
    public static void printPathRecursion(int s, int f) {
        if (s == f) {
            System.out.print(f + " ");
        }
        else {
            if (path.get(f) == -1) {
                System.out.print("NO PATH");
            } else {
                printPathRecursion(s, path.get(f));
                System.out.print(f + " ");
            }
        }
    }
    public static void printPath(int s, int f) {
        if (f == s) {
            System.out.print(s);
            return;
        }
        if (path.get(f) == -1) {
            System.out.print("NO PATH");
            return;
        }
        ArrayList<Integer> b = new ArrayList<Integer>();
        while (true) {
            b.add(f);
            f = path.get(f);
            if (s == f) {
                b.add(f);
                break;
            }
        }
        for (int i = b.size() - 1; i >= 0; i--) {
            System.out.print(b.get(i) + " ");
        }
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int s = 0, f = 5;
        DFS(s);
        printPath(s, f);
    }
}
