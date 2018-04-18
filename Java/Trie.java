import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        static final int MAX = 26;
        public Node[] child;
        public int countLeaf;
        public Node() {
            countLeaf = 0;
            child = new Node[MAX];
        }
    }
    static class Trie {
        public static final int MAX = 26;
        private Node root;
        public Trie() {
            root = new Node();
        }
        public void addWord(String s) {
            int ch;
            Node temp = root;
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i) - 'a';
                if (temp.child[ch] == null) {
                    Node x = new Node();
                    temp.child[ch] = x;
                }
                temp = temp.child[ch];
            }
            temp.countLeaf++;
        }
        public boolean findWord(String s) {
            int ch;
            Node temp = root;
            for (int i = 0; i < s.length(); i++)
            {
                ch = s.charAt(i) - 'a';
                if (temp.child[ch] == null)
                {
                    return false;
                }
                temp = temp.child[ch];
            }
            return temp.countLeaf > 0;
        }
        private boolean isWord(Node pNode) {
            return (pNode.countLeaf != 0);
        }
        private boolean isEmpty(Node pNode) {
            for (int i = 0; i < MAX; i++)
                if (pNode.child[i] != null)
                    return false;
            return true;
        }
        public boolean removeWord(String s) {
            return removeWord(root, s, 0, s.length());
        }
        private boolean removeWord(Node root, String s, int level, int len) {
            if (root == null)
                return false;
            if (level == len) {
                if (root.countLeaf > 0) {
                    root.countLeaf--;
                    return true;
                }
                return false;
            }
            int ch = s.charAt(level) - 'a';
            boolean flag = removeWord(root.child[ch], s, level + 1, len);
            if (flag && !isWord(root.child[ch]) && isEmpty(root.child[ch]))
            {
                root.child[ch] = null;
            }
            return flag;
        }
    }
	public static void main(String args[]) {
		
	}
}

