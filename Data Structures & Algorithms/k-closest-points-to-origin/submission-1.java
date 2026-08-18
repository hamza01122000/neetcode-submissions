class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        int[][] result = new int[k][];
        int j = 0;
        
        for(int i = 0; i < points.length; i++){
            int sum = 0;
            int[] point = points[i];
            for(int num : point){
                sum = sum + num * num;
            }
            pq.add(new int[]{sum, i});
        }

        while(k > 0){
            int[] val = pq.poll();
            result[j] = points[val[1]]; 
            k--;
            j++;
        }

        return result;
    }
}