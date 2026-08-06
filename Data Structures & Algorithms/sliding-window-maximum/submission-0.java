class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxEle;
        ArrayList<Integer> output = new ArrayList<>();
        int[] out = new int[5];

        for(int i = 0; i <= nums.length-k; i++){
            int j = 0;
            maxEle = nums[i];
            int index = i;
            while(j < k){
                if(nums[index] > maxEle){
                    maxEle = nums[index];
                }
                if(j == k-1){
                    output.add(maxEle);
                }
                index++;
                j++;
            }
        }

    // for(int n : output){
    //     System.out.print(n);
    // }

        return output.stream().mapToInt(i -> i).toArray();
    }
}
