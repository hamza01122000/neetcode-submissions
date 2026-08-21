class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(left.isEmpty()) left.offer(num);
        else if(right.isEmpty()){
            if(left.peek() > num){
                right.offer(left.poll());
                left.offer(num);
            }
            else right.offer(num);
        }
        else if(left.peek() >= num && right.peek() >= num){
            if(left.size() == right.size()) left.offer(num);
            else{
                right.offer(left.poll());
                left.offer(num);
            }
        }
        else if(left.peek() <= num && num <= right.peek()){
            if(left.size() == right.size()) left.offer(num);
            else right.offer(num);
        }
        else if(left.peek() <= num && right.peek() <= num){
            if(left.size() == right.size()){
                left.offer(right.poll());
                right.offer(num);
            }
            else right.offer(num);
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size() + 1){
            return (double) left.peek();
        }
        else{
            return (double) (left.peek() + right.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */