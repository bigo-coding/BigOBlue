#include <iostream>
#include <vector>
using namespace std;
int binarySearch(vector<int> a, int left, int right, int x) {
    while (left <= right) {
        int mid = (left + right) / 2;
        if (x == a[mid])
            return mid;
        else if (x < a[mid])
            right = mid - 1;
        else if (x > a[mid])
            left = mid + 1;
    }
    return -1;
}
int binarySearch_recursion(vector<int> a, int left, int right, int x) {
    if (left <= right) {
        int mid = left + (right - left) / 2;
        if (a[mid] == x)
            return mid;
        if (a[mid] > x)
            return binarySearch(a, left, mid - 1, x);
        return binarySearch(a, mid + 1, right, x);
    }
    return -1;
}
int bsFirst(vector<int> &a, int left, int right, int x) {
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
int bsLast(vector<int> a, int left, int right, int x) {
    if (left <= right) {
        int mid = left + (right - left) / 2;
        if ((mid == right || x < a[mid + 1]) && a[mid] == x)
            return mid;
        else if (x < a[mid])
            return bsLast(a, left, (mid - 1), x);
        else
            return bsLast(a, (mid + 1), right, x);
    }
    return -1;
}
int main() {
    freopen("INPUT.INP", "rt", stdin);
    vector<int> a;
    int n, x, value;
    cin >> n >> x;
    for (int i = 0; i < n; i++) {
        cin >> value;
        a.push_back(value);
    }
    int result = binarySearch(a, 0, n - 1, x);
    cout << result;
    return 0;
}
