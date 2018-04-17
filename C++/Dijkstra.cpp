#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <functional>
using namespace std;
#define MAX 100
const int INF = 1e9;
vector<vector<pair<int, int> > > graph;
vector<int> dist(MAX, INF);
int path[MAX];
void Dijkstra(int s, vector<vector<pair<int, int> > > &graph){
    priority_queue<pair<int, int>, vector<pair<int, int> >,
        greater<pair<int, int> > > pq;
    pq.push(pair<int, int>(0, s));
    dist[s] = 0;
    while (!pq.empty()) {
        pair<int, int> top = pq.top();
        pq.pop();
        int node = top.second;
        int d = top.first;
        for (int i = 0; i < graph[node].size(); ++i) {
            pair<int, int> neighbor = graph[node][i];
            if (d + neighbor.second < dist[neighbor.first]) {
                dist[neighbor.first] = d + neighbor.second;
                pq.push(pair<int, int>(dist[neighbor.first], neighbor.first));
                path[neighbor.first] = node;
            }
        }
    }
}
int main() {
    int n, s, t;
    dist = vector<int>(MAX, INF);
    cin >> n;
    s = 0, t = 4;
    graph = vector<vector<pair<int, int> > >(MAX + 5, vector<pair<int, int> >());
    int d = 0;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
            cin >> d;
            if(d > 0)
                graph[i].push_back(pair<int, int>(j, d));
        }
    Dijkstra(s, graph);
    int ans = dist[t];
    cout << ans;
    return 0;
}
