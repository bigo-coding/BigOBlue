import java.io.*;
import java.util.*;

public class BinarySearch {
    public static int binarySearch(int a[], int left, int right, int x) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == a[mid]) {
                return mid;
            }
            else if (x < a[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static int binarySearch_recursion(int a[], int left, int right, int x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == a[mid]) {
                return mid;
            }
            else if (x < a[mid]) {
                return binarySearch(a, left, mid - 1, x);
            }
            else {
                return binarySearch(a, mid + 1, right, x);
            }
        }
        return -1;
    }
    public static int bsFirst(int[] a, int left, int right, int x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == left || x > a[mid - 1]) && a[mid] == x)
                return mid;
            else if (x > a[mid])
                return bsFirst(a, (mid + 1), right, x);
            else
                return bsFirst(a, left, (mid - 1), x);
        }
        return -1;
    }
    public static int bsLast(int[] a, int left, int right, int x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == right || x < a[mid + 1]) && a[mid] == x) {
                return mid;
            }
            else if (x < a[mid])
                return bsLast(a, left, mid - 1, x);
            else
                return bsLast(a, mid + 1, right, x);
        }
        return -1;
    }
    public static int lower_bound(int[] a, int left, int right, int x) {
        int pos = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= x) {
                pos = mid;
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return pos;
    }
    public static int upper_bound(int[] a, int left, int right, int x) {
        int pos = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > x) {
                pos = mid;
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return pos;
    }
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print(binarySearch(a, 0, n - 1, x));
	}
}
