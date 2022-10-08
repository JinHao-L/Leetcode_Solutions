class MyCalendarThree {
    private Map<Integer, Integer> events;

    public MyCalendarThree() {
        events = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);

        int max = 0, nOverlap = 0;
        for (int change : events.values()) {
            nOverlap += change;
            max = Math.max(max, nOverlap);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */