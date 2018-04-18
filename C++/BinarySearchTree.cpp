#include <iostream>
using namespace std;
struct Node {
    int key;
    Node *left;
    Node *right;
};
Node* createNode(int x) {
    Node *newnode = new Node;
    newnode->key = x;
    newnode->left = newnode->right = NULL;
    return newnode;
}
Node* insertNode(Node* root, int x) {
    if (root == NULL)
        return createNode(x);
    if (x < root->key)
        root->left = insertNode(root->left, x);
    else if (x > root->key)
        root->right = insertNode(root->right, x);
    return root;
}
void createTree(Node* &root, int a[], int n) {
    for (int i = 0; i < n; i++)
        root = insertNode(root, a[i]);
}
Node* searchNode(Node *root, int x) {
    if (root == NULL || root->key == x)
        return root;
    if (root->key < x)
        return searchNode(root->right, x);
    return searchNode(root->left, x);
}
Node* minValueNode(Node* node) {
    Node* current = node;
    while (current->left != NULL) {
        current = current->left;
    }
    return current;
}
Node* deleteNode(Node* &root, int x) {
    if (root == NULL)
        return root;
    if (x < root->key)
        root->left = deleteNode(root->left, x);
    else if (x > root->key)
        root->right = deleteNode(root->right, x);
    else {
        if (root->left == NULL) {
            Node *temp = root->right;
            delete root;
            return temp;
        }
        else if (root->right == NULL) {
            Node *temp = root->left;
            delete root;
            return temp;
        }
        Node* temp = minValueNode(root->right);
        root->key = temp->key;
        root->right = deleteNode(root->right, temp->key);
    }
    return root;
}
void traversalTree(Node *root) {
    if (root != NULL) {
        traversalTree(root->left);
        cout << root->key << " ";
        traversalTree(root->right);
    }
}
int size(Node* node) {
    if (node == NULL)
        return 0;
    else
        return (size(node->left) + 1 + size(node->right));
}
void deleteTree(Node* node) {
    if (node == NULL)
        return;
    deleteTree(node->left);
    deleteTree(node->right);
    delete(node);
}
