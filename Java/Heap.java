import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Heap {
    public static class MinHeap {
        private int[] heap;
        private int heapSize;
        private int capacity;
        public MinHeap() {
            heap = new int[1];
            capacity = 1;
            heapSize = 0;
        }
        public MinHeap(int[] h, int cap) {
            capacity = cap;
            heapSize = h.length;
            heap = Arrays.copyOf(h, cap);
            buildHeap();
        }
        private void swap(int lft_pos, int rht_pos) {
            int tmp = heap[lft_pos];
            heap[lft_pos] = heap[rht_pos];
            heap[rht_pos] = tmp;
        }
        private void heapify(int i) {
            int smallest = i;
            int left = 2*i + 1;
            int right = 2*i + 2;
            if (left < heapSize && heap[left] < heap[smallest])
                smallest = left;
            if (right < heapSize && heap[right] < heap[smallest])
                smallest = right;
            if (smallest != i) {
                swap(i, smallest);
                heapify(smallest);
            }
        }
        public void buildHeap() {
            for (int i = heapSize / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }
        public int top() {
            return heap[0];
        }
        void push(int value) {
            if (heapSize == capacity) {
                capacity *= 2;
                heap = Arrays.copyOf(heap, capacity);
            }
            heap[heapSize] = value;
            heapSize++;
            int i = heapSize - 1;
            while (i != 0 && heap[(i - 1) / 2] > heap[i]) {
                swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
        void pop() {
            if (heapSize == 0) {
                return;
            }
            heap[0] = heap[heapSize - 1];
            heapSize--;
            heapify(0);
        }
    }

    public static void main (String[] args) {
        int[] a = new int[]{7, 12, 6, 10, 17, 15, 2, 4};
        MinHeap heap = new MinHeap(a, 8);
        heap.buildHeap();
        System.out.println(heap.top());
    }
}
