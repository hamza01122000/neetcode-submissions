class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int maxSize;

    public KthLargest(int k, int[] nums) {
        maxSize = k;
        for(int num : nums){
            if(pq.size() < maxSize)
                pq.add(num);
            
            else if(pq.peek() < num){
                pq.add(num);
                pq.remove(pq.peek());
            }
        }
    }
    
    public int add(int val) {

        if(pq.size() < maxSize) pq.add(val);
    
        else if(pq.peek() < val){
            pq.add(val);
            pq.remove(pq.peek());
        }

        return pq.peek();
    }
}

