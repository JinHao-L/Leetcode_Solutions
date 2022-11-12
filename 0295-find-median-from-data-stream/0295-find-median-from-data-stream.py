class MedianFinder:

    def __init__(self):
        self.front = []
        self.back = []

    def addNum(self, num: int) -> None:
        if len(self.front) == 0 or -self.front[0] > num:
            heappush(self.front, -num)
        else:
            heappush(self.back, num)
            
        if (len(self.back) > len(self.front)):
            heappush(self.front, -heappop(self.back))
        elif (len(self.back) < len(self.front) - 1):
            heappush(self.back, -heappop(self.front))
        
    def findMedian(self) -> float:
        if (len(self.back) == len(self.front)):
            return (-self.front[0] + self.back[0]) / 2
        elif self.front:
            return -self.front[0]
        else:
            return 0

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()