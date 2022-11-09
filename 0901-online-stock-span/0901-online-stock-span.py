class StockSpanner:
    
    def __init__(self):
        self.stack = []
        self.day = 0

    def next(self, price: int) -> int:
        while (len(self.stack) > 0 and self.stack[-1][1] <= price) :
            self.stack.pop()
        
        prevDay = 0 if len(self.stack) == 0 else self.stack[-1][0]
        self.day += 1
        self.stack.append((self.day, price))
        return self.day - prevDay


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)