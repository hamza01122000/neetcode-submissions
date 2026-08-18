class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Double> pq = new PriorityQueue<>();
        ArrayList<Double> arr = new ArrayList<>();
        int[][] result = new int[k][];
        int j = 0;
        
        for(int i = 0; i < points.length; i++){
            double sum = 0.00;
            int[] point = points[i];
            for(int num : point){
                sum = sum + num * num;
            }
            arr.add(Math.sqrt(sum));
        }
        
        for(Double key : arr){
            pq.add(key);
        }

        while(k > 0){
            double val = pq.poll();
            int index = search(arr, val);
            result[j] = points[index]; 
            k--;
            j++;
        }

        return result;
    }

    public int search(ArrayList<Double> array, double num){
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) == num) {
                array.set(i, -1.00);
                return i;
            }
        }  
        return 0; 
    }
}