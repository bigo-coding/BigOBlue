import java.io.*;
import java.util.*;

public class Main {
    public static int findSet(ArrayList <Integer> parent, int u) {
        while (u != parent.get(u)) {
            u = parent.get(u);
        }
        return u;
    }
    public static void unionSet(ArrayList<Integer> parent, int u, int v)
    {
        int up = findSet(parent, u);
        int vp = findSet(parent, v);
        parent.set(vp,
                parent.get(up));
    }
	static ArrayList<Integer> parent = new ArrayList<Integer>();
    public static void main (String[] args) {
        for (int i = 0; i <= MAX; i++)
            parent.add(i);
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            if (z == 1)
                unionSet(x, y);
            else {
                int parentX = findSet(x);
                int parentY = findSet(y);
                if (parentX == parentY)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
}
