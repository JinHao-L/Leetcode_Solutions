class MyCircularQueue {
    int start, end, size;
    int[] queue;
    
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.start = 0;
        this.end = -1;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        end = next(end);
        queue[end] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        start = next(start);
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[start];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : queue[end];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
    
    private int next(int i) {
        return (i + 1) % queue.length;
    }

    private int prev(int i) {
        return (i - 1 + queue.length) % queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */