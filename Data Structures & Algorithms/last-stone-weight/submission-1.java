class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        if(stones.length == 1) return stones[0];

        for(int num : stones){
            pq.add(num);
        }
        while(!pq.isEmpty() || pq.size() > 1){
            if(pq.size() == 1) return pq.peek();
            int x = pq.poll();
            int y = pq.poll();

            int diff = x - y;
            if(diff != 0) pq.add(diff);
        }
        
        return 0;

    }
}
