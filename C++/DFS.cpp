#include <iostream>
#include <vector>
#include <stack>
using namespace std;
#define MAX 100
int V;
bool visited[MAX];
int path[MAX];
vector<int> graph[MAX];
void DFS(int src) {
    for (int i = 0; i < V; i++) {
        visited[i] = false;
        path[i] = -1;
    }
    stack<int> s;
    visited[src] = true;
    s.push(src);
    while (!s.empty()) {
        int u = s.top();
        s.pop();
        for (int i = 0; i < graph[u].size(); i++) {
           int v = graph[u][i];
            if (!visited[v]) {
                visited[v] = true;
                s.push(v);
                path[v] = u;
            }
        }
    }
}
void DFSRecursion(int s) {
    visited[s] = true;
    for (int i = 0; i < graph[s].size(); i++) {
        int v = graph[s][i];
        if (!visited[v]) {
            path[v] = s;
            DFSRecursion(v);
        }
    }
}
void printPathRecursion(int s, int f) {
    if (s == f)
        cout << f << " ";
    else {
        if (path[f] == -1)
            cout << "No path" << endl;
        else {
            printPathRecursion(s, path[f]);
            cout << f << " ";
        }
    }
}
void printPath(int s, int f) {
    int b[MAX];
    int m = 0;
    if (f == s) {
        cout << s;
        return;
    }
    if (path[f] == -1) {
        cout << "No path" << endl;
        return;
    }
    while (1) {
        b[m++] = f;
        f = path[f];
        if (f == s) {
            b[m++] = s;
            break;
        }
    }
    for (int i = m - 1; i >= 0; i--) {
        cout << b[i] << " ";
    }
}
int main() {
    int E, u, v;
    cin >> V >> E;
    for (int i = 0; i < E; i++) {
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    int s = 0;
    int f = 5;
    DFS(s);
    printPath(s, f);
    return 0;
}
