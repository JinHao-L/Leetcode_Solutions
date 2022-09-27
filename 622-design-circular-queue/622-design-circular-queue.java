class MyCircularQueue {
    int start, end, size, k;
    int[] queue;
    
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.start = 0;
        this.end = 0;
        this.k = k;
        this.size = 0;
        queue[start] = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[end] = value;
        end = next(end);
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        queue[start] = -1;
        start = next(start);
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return queue[start];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return queue[prev(end)];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
    
    private int next(int i) {
        return (i + 1) % k;
    }

    private int prev(int i) {
        return (i - 1 + k) % k;
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