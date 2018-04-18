#include <string>
#include <iostream>
#define MAX 26
using namespace std;
struct node {
    struct node* child[MAX];
    int countLeaf;
};
struct node *newNode()
{
    struct node *Node = new struct node;
    Node->countLeaf = 0;
    for (int i = 0; i < MAX; i++)
    {
        Node->child[i] = NULL;
    }
    return Node;
}
void addWord(struct node *root, string s)
{
    int ch;
    struct node *temp = root;
    for (int i = 0; i < s.size(); i++)
    {
        ch = s[i] - 'a';
        if (temp->child[ch] == NULL)
        {
            temp->child[ch] = newNode();
        }
        temp = temp->child[ch];
    }
    temp->countLeaf++;
}
bool findWord(struct node *root, string s)
{
    int ch;
    struct node *temp = root;
    for (int i = 0; i < s.size(); i++)
    {
        ch = s[i] - 'a';
        if (temp->child[ch] == NULL)
        {
            return false;
        }
        temp = temp->child[ch];
    }
    return temp->countLeaf > 0;
}
bool isWord(struct node *pNode)
{
    return (pNode->countLeaf != 0);
}
bool isEmpty(struct node *pNode)
{
    for (int i = 0; i < MAX; i++)
    {
        if (pNode->child[i] != NULL)
        {
            return false;
        }
    }
    return true;
}
bool removeWord(struct node *root, string s, int level, int len)
{
    if (!root)
        return false;
    int ch = s[level] - 'a';
    if (level == len)
    {
        if (root->countLeaf > 0)
        {
            root->countLeaf--;
            return true;
        }
        return false;
    }
    int flag = removeWord(root->child[ch], s, level + 1, len);
    if (flag && !isWord(root->child[ch]) && isEmpty(root->child[ch]))
    {
        delete root->child[ch];
        root->child[ch] = NULL;
    }
    return flag;
}
