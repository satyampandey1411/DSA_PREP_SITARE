class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q2.add(x);
        
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        if (empty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }
    
    public int top() {
        if (empty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
