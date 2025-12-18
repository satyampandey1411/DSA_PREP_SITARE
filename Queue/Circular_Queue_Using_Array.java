class myQueue {
    int[] arr;
    int front, rear, size, capacity;

    public myQueue(int n) {
        arr = new int[n];
        capacity = n;
        front = 0;
        rear = n - 1;
        size = 0;
    }

    // check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // check if full
    public boolean isFull() {
        return size == capacity;
    }

    // enqueue at rear
    public void enqueue(int x) {
        if (isFull()) return;
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    // dequeue from front
    public void dequeue() {
        if (isEmpty()) return;
        front = (front + 1) % capacity;
        size--;
    }

    // get front element
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    // get rear element
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }
}
