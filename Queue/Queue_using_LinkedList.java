
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}


class myQueue {
    Node front, rear; 
    int count;       


    public myQueue() {
        front = null;
        rear = null;
        count = 0;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Add element to rear
    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }

    // Remove element from front
    public void dequeue() {
        if (isEmpty()) return;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        count--;
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) return -1;
        return front.data;
    }

    // Get current size
    public int size() {
        return count;
    }
}
