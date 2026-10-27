class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    double median;


    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        median = 0;
    }
    
    public void addNum(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            minHeap.add(num);
        } else {
            if (num > minHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        }

        if (minHeap.size() > maxHeap.size()) {
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        } else if (minHeap.size() < maxHeap.size()) {
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        }   
    }
    
    public double findMedian() {
        if ((minHeap.size() + maxHeap.size()) % 2 == 1) {
            if (minHeap.size() < maxHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
