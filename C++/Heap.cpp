#include <iostream>
#include <vector>
using namespace std;

void swap(int& x, int& y) {
    int z = x;
    x = y;
    y = z;
}
void MinHeapify(int i) {
    int smallest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;
    if (left < h.size() && h[left] < h[smallest])
        smallest = left;
    if (right < h.size() && h[right] < h[smallest])
        smallest = right;
    if (smallest != i) {
        swap(h[i], h[smallest]);
        MinHeapify(smallest);
    }
}
int top() {
    return h[0];
}
void buildHeap(int n) {
    for (int i = n / 2 - 1; i >= 0; i--) {
        MinHeapify(i);
    }
}
void push(int value)
{
    h.push_back(value);
    int i = h.size() - 1;
    while (i != 0 && h[(i - 1) / 2] > h[i])
    {
        swap(h[i], h[(i - 1) / 2]);
        i = (i - 1) / 2;
    }
}
void pop() {
    int length = h.size();
    if (length == 0) {
        return;
    }
    h[0] = h[length - 1];
    h.pop_back();
    MinHeapify(0);
}
int main() {
    vector<int> a = { 7, 12, 6, 10, 17, 15, 2, 4 };
    h = a;
    buildHeap(h.size());
    return 0;
}
