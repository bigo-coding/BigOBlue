def MinHeapify(i):
    smallest = i
    left = 2*i + 1
    right = 2*i + 2
    if left < len(h) and h[left] < h[smallest]:
        smallest = left
    if right < len(h) and h[right] < h[smallest]:
        smallest = right
    if smallest != i:
        h[i], h[smallest] = h[smallest], h[i]
        MinHeapify(smallest)

def buildHeap(n):
    for i in range(n//2 - 1, -1, -1):
        MinHeapify(i)

def top():
    return h[0]

def push(value):
    h.append(value)
    i = len(h) - 1
    while i != 0 and h[(i-1) // 2] > h[i]:
        h[i], h[(i-1) // 2] = h[(i-1) // 2], h[i]
        i = (i - 1) // 2

def pop():
    length = len(h)
    if length == 0:
        return
    h[0] = h[length - 1]
    h.pop()
    MinHeapify(0)
    
if __name__ == '__main__':
    h = [7, 12, 6, 10, 17, 15, 2, 4]
    buildHeap(len(h))
    print(h)
