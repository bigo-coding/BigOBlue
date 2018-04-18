import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    
    static class BinarySearchTree {
        private Node root = null;
        public BinarySearchTree() {
            root = null;
        }
        private Node createNode(int key) {
            Node temp = new Node(key);
            return temp;
        }
        private Node insertNode(Node root, int x) {
            if (root == null)
                return createNode(x);
            if (x < root.key)
                root.left = insertNode(root.left, x);
            else if (x > root.key)
                root.right = insertNode(root.right, x);
            return root;
        }
        public void insertNode(int x) {
            root = insertNode(root, x);
        }
        public void createTree(int a[], int n) {
            root = null;
            for (int i = 0; i < n; i++) {
                root = insertNode(root, a[i]);
            }
        }
        public Node searchNode(int x) {
            return searchNode(root, x);
        }
        private Node searchNode(Node root, int x) {
            if (root == null || root.key == x) {
                return root;
            }
            if (root.key < x)
                return searchNode(root.right, x);
            else
                return searchNode(root.left, x);
        }
        public void deleteNode(int x) {
            root = deleteNode(root, x);
        }
        private Node minValueNode(Node root) {
            Node current = root;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }
        private Node deleteNode(Node root, int x) {
            if (root == null)
                return root;
            if (x < root.key) {
                root.left = deleteNode(root.left, x);
            }
            else if (x > root.key) {
                root.right = deleteNode(root.right, x);
            }
            else {
                if (root.left == null) {
                    Node temp = root.right;
                    root = null;
                    return temp;
                }
                else if (root.right == null) {
                    Node temp = root.left;
                    root = null;
                    return temp;
                }
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
            return root;
        }
        public void traversalTree() {
            traversalTree(root);
        }
        private void traversalTree(Node root) {
            if (root != null) {
                traversalTree(root.left);
                System.out.print(root.key + " ");
                traversalTree(root.right);
            }
        }
        public int size() {
            return size(root);
        }
        private int size(Node root) {
            if (root == null)
                return 0;
            return size(root.left) + size(root.right) + 1;
        }
        public void deleteTree() {
            deleteTree(root);
        }
        private void deleteTree(Node root) {
            if (root == null)
                return;
            deleteTree(root.left);
            deleteTree(root.right);
            root = null;
        }
    }
	public static void main(String args[]) {
		
	}
}
