class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int[]> waitingQueue = new LinkedList<>();
        int time = 0;
        
        for(char c : tasks){
            freqMap.merge(c, 1, Integer::sum);
        }

        for(int freq: freqMap.values()){
            pq.offer(freq);
        }

        while(!pq.isEmpty() || !waitingQueue.isEmpty()){
            while(!waitingQueue.isEmpty() && waitingQueue.peek()[1] <= time){
                pq.offer(waitingQueue.poll()[0]);
            }

            if(!pq.isEmpty()){
                int remaining = pq.poll();
                remaining--;

                if(remaining > 0) waitingQueue.offer(new int[]{remaining, time+n+1});
            }
            time++;
        }
        
        return time;
    }   
}