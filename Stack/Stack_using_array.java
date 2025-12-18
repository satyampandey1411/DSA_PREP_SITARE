class myStack {
    int top;
    int arr[];
    int capacity;

    public myStack(int n) {
        arr = new int[n];   
        capacity = n;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            return; 
        }
        top++;
        arr[top] = x;
    }


    public int pop() {
        if (isEmpty()) {
            return -1; 
        }
        int val = arr[top];
        top--;
        return val;
    }


    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }


    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}
