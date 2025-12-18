class myStack {
    Node top;   
    int count;  

    public myStack() {
        top = null;
        count = 0;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Push element onto stack
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        count++;
    }

    // Pop element from stack
    public void pop() {
        if (isEmpty()) return;
        top = top.next;
        count--;
    }

    // Peek top element
    public int peek() {
        if (isEmpty()) return -1;
        return top.data;
    }

    // Return current size
    public int size() {
        return count;
    }
}
